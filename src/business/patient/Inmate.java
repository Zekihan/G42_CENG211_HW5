package business.patient;

public class Inmate extends Patient {

	public Inmate(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public Inmate(Patient patient) {
		super(patient.getName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Inmate [toString()=" + super.toString() + "]";
	}
	
}
