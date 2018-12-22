package business.patient;

public abstract class Patient {
	
	private String name;
	
	public Patient(String name) {
		setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}
	
}
