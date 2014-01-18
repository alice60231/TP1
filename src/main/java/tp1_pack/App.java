package tp1_pack;

import java.sql.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class App {

	//funct. of creating FrenchDepartment
	private static FrenchDepartment createFrenchDepartment(int id, int number)

	throws ParseException {

		FrenchDepartment frenchdepartment = new FrenchDepartment();

		frenchdepartment.setId(id);
		frenchdepartment.setNumber(number);

		return frenchdepartment;
	}
	//funct. of creating FrenchCommune
	private static FrenchCommune createFrenchCommune(int id, String name)

	throws ParseException {

		FrenchCommune frenchcommune = new FrenchCommune();

		frenchcommune.setId(id);
		frenchcommune.setName(name);

		return frenchcommune;
	}
	
	//funct. of creating Town
	private static Town createTown(int id, String name)

	throws ParseException {

		Town town = new Town();

		town.setId(id);
		town.setName(name);

		return town;
	}

	//main--execute queries
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World!");

		//test if connecting to the hsqldb
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}

		//declare EntityManagerFactory to handle queries
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("manage");
		EntityManager em = emf.createEntityManager();

		//start writing about queries
		try {

			//caution!! 
			//the first element of FrenchDepartment, FrenchCommune, and Town is "primary key"(id)
			//if there are errors show, check if there are collisions
			FrenchDepartment fd1 = createFrenchDepartment(5, 5);
			FrenchCommune fc1 = createFrenchCommune(3, "third");
			Town t = createTown(2, "second");

			//execute--create
			em.getTransaction().begin();
			em.persist(fd1);
			em.getTransaction().commit();

			em.getTransaction().begin();
			em.persist(fc1);
			em.getTransaction().commit();

			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();

			//execute--select
			TypedQuery<FrenchDepartment> query = em.createQuery(
					"SELECT f from FrenchDepartment f", FrenchDepartment.class);

			List<FrenchDepartment> flights = query.getResultList();

			for (FrenchDepartment f : flights) {
				System.out.println(f);
			}

		} finally {
			em.close();
			emf.close();
		}

	}
}
