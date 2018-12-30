package business.patient;

public abstract class Patient {
	
	private String name;
	
	public Patient(String name) {
		setName(name);
	}
	
	public Patient(Patient patient) {
		setName(patient.name);
	}
	

	public String getName() {
		return name;
	}


	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + "]";
	}
	
}
