package business;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import business.doctor.*;
import business.patient.*;

public class HospitalManager {
	
	private Hospital hospital;
	private Map<Doctor, Queue<Patient>> doctorLine;
	
	public HospitalManager() {
		setDoctorLine(new HashMap<>());
		setHospital(new Hospital());
		
	}
	
	public void registerPatient(String patientName, String doctorName) {
		Patient patient = new WalkingCase(patientName);
		hospital.addPatient(patient);
	}

	private void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	private void setDoctorLine(Map<Doctor, Queue<Patient>> doctorLine) {
		this.doctorLine = doctorLine;
	}
	
	
}
