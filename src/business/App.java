package business;

import business.doctor.Doctor;
import business.doctor.Surgeon;

public class App {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		hospital.addDoctor(new Doctor("Ahmet Öztürk", "KBB"));
		hospital.addDoctor(new Surgeon("Rasit Midilli", "KBB"));
		
		HospitalManager mng = new HospitalManager(hospital);
		mng.start();
	}
}
