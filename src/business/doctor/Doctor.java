package business.doctor;

public class Doctor {
	
	private String name;
	private String profession;
	
	public Doctor(String name, String profession) {
		setName(name);
		setProfession(profession);
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setProfession(String profession) {
		this.profession = profession;
	}
}
