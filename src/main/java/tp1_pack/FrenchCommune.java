package tp1_pack;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrenchCommune {

	@Id
	private int id;

	String name;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


}