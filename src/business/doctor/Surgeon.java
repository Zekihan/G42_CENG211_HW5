package business.doctor;

public class Surgeon extends Doctor {
	
	public Surgeon(String name, String profession) {
		super(name, profession);
	}
	
	public void doSurgery() {
		
	}

	@Override
	public String toString() {
		return "Surgeon"  + super.toString()  ;
	}
	
}
