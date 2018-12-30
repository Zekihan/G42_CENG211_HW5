package business;

import business.doctor.Doctor;

public class App {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		hospital.addDoctor(new Doctor("Rasit Midilli", "KBB"));

		HospitalManager mng = new HospitalManager(hospital);
		mng.start();
	}
}
