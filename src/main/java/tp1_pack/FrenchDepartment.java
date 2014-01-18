package tp1_pack;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class FrenchDepartment {
	
	@Id
	private int id;

	int number;


	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }


}
