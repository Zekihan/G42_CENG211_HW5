package business.doctor;

public class Doctor {
	
	private String name;
	private String profession;
	
	public Doctor(String name, String profession) {
		setName(name);
		setProfession(profession);
	}
	
	public String getName() {
		return name;
	}


	public String getProfession() {
		return profession;
	}


	private void setName(String name) {
		this.name = name;
	}
	
	private void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", profession=" + profession + "]";
	}
	
}
