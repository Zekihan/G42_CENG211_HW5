package business;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
		Set<Doctor> doctorSet = hospital.getDoctors();
		Search<Doctor> search = new Search<>();
		Doctor doc = search.searchByName(doctorSet, doctorName);
		if(doctorLine.containsKey(doc)) {
			doctorLine.get(doc).add(patient);
		}else {
			doctorLine.put(doc, new LinkedList<Patient>());
			doctorLine.get(doc).add(patient);
		}
		
	}

	private void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	private void setDoctorLine(Map<Doctor, Queue<Patient>> doctorLine) {
		this.doctorLine = doctorLine;
	}
	

}
