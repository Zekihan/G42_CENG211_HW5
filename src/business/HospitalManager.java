package business;

import java.util.*;
import business.doctor.*;
import business.patient.*;
import dataaccess.ConsoleInput;

public class HospitalManager {
	
	private Hospital hospital;
	private Map<Doctor, Queue<Patient>> doctorLine;
	private ConsoleInput consoleIn; 
	private List<String> receptionistList;
	
	public HospitalManager() {
		setDoctorLine(new HashMap<>());
		setHospital(new Hospital());
		setConsoleIn(new ConsoleInput());
		setReceptionistList(new ArrayList<>());
		
	}
	
	public void start() {
		System.out.println("Login as: "); 
		int login = consoleIn.readInt();
		switch(login) {
			case 0: doctorAccess();
					break;
			case 1: receptionistAccess();
					break;
			default:
					break;
		}
	}
	
	private void receptionistAccess() {
		System.out.println("Please Choose Your Name: " + System.lineSeparator());
		for (int i = 0; i < receptionistList.size(); i++) {
			int lineNum = i + 1;
			System.out.println(lineNum + ") " + receptionistList.get(i));
		}
		int lineNum = consoleIn.readInt();
		
		System.out.println("Welcome " + receptionistList.get(lineNum - 1) );
		System.out.println("Press enter to register new patient");
		consoleIn.readString();
		System.out.println("Enter the patient's name: ");
		String patientName = consoleIn.readString();
		System.out.println("Enter the doctor's name: ");
		String doctorName = consoleIn.readString();
		registerPatient(patientName, doctorName);
		System.out.println("Successfully registered the patient");
	}

	private void doctorAccess() {
		System.out.println("Please Choose Your Name: " + System.lineSeparator());
		Map<Integer, Doctor> doctorMap = new HashMap<>();
		int lineNum = 1;
		for (Doctor doctor : hospital.getDoctors()) {
			System.out.println(lineNum + ") " + doctor.getName());
			doctorMap.put(lineNum, doctor);
			lineNum++;
		}
		int choosenNum = consoleIn.readInt();
		Doctor doctor = doctorMap.get(lineNum);
		System.out.println("Welcome Dr " + doctor.getName());
		
		System.out.println("Menu: " + System.lineSeparator() + 
				"1) See next paitent on the waiting line " + System.lineSeparator() +
				"2) List all patient under your care " + System.lineSeparator() + 
				"3) Search and see result of analysis " + System.lineSeparator() + 
				"4) List all patient examined " + System.lineSeparator() + 
				"5) Search any patient examined in the past " + System.lineSeparator() + 
				"6) Search any appointed surgery for him/her ");
	}
	

  	private void registerPatient(String patientName, String doctorName) {
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
	
	public void seeNextPatient(Doctor doctor) {
		try {
			Patient patient = doctorLine.get(doctor).remove();
			Examination examination = new Examination(doctor, patient);
			
			
		}catch(NoSuchElementException e){
			System.out.println("There aren't any patient waiting"); 
		}
		
	}

	private void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	private void setDoctorLine(Map<Doctor, Queue<Patient>> doctorLine) {
		this.doctorLine = doctorLine;
	}

	private void setConsoleIn(ConsoleInput consoleIn) {
		this.consoleIn = consoleIn;
	}

	private void setReceptionistList(List<String> receptionistList) {
		this.receptionistList = receptionistList;
	}
	

}
