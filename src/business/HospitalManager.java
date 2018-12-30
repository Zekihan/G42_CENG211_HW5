package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import business.analysis.Analysis;
import business.doctor.*;
import business.exceptions.*;
import business.patient.*;
import dataaccess.ConsoleInput;

public class HospitalManager {
	
	private Hospital hospital;
	private Map<Doctor, Queue<Patient>> doctorLine;
	private ConsoleInput consoleIn; 
	private List<String> receptionistList;
	private Map<Doctor, Set<Patient>> examinedPatients;
	
	public HospitalManager() {
		setDoctorLine(new HashMap<>());
		setHospital(new Hospital());
		setConsoleIn(new ConsoleInput());
		setReceptionistList(new ArrayList<>());
		setExaminedPatients(new HashMap<>());
	}
	
	public void start() {
		System.out.println("Login as: "); 
		int login = consoleIn.readInt();
		try {
			switch(login) {
			case 0: doctorAccess();
					break;
			case 1: receptionistAccess();
					break;
			default:
					break;
		}
		}catch(DoctorNotFoundException e) {
			
		}catch(AnalysisNotFoundException e){
			
		}catch(PatientNotFoundException e) {
			
		}
		
	}
	
	private void receptionistAccess() throws DoctorNotFoundException {
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

	private void doctorAccess() throws PatientNotFoundException, AnalysisNotFoundException, DoctorNotFoundException {
		System.out.println("Please Choose Your Name: " + System.lineSeparator());
		Map<Integer, Doctor> doctorMap = new HashMap<>();
		int lineNum = 1;
		for (Doctor doctor : hospital.getDoctors()) {
			System.out.println(lineNum + ") " + doctor.getName());
			doctorMap.put(lineNum, doctor);
			lineNum++;
		}
		Doctor doctor = doctorMap.get(lineNum);
		System.out.println("Welcome Dr " + doctor.getName() + System.lineSeparator() +
				"Menu: " + System.lineSeparator() + 
				"1) See next paitent on the waiting line " + System.lineSeparator() +
				"2) List all patient under your care " + System.lineSeparator() + 
				"3) Search and see result of analysis " + System.lineSeparator() + 
				"4) List all patient examined " + System.lineSeparator() + 
				"5) Search any patient examined in the past " + System.lineSeparator() + 
				"6) Search any appointed surgery for you ");
		int option = consoleIn.readInt();
		switch(option) {
			case 1: seeNextPatient(doctor);
					break;
			case 2: listAllPatientsUnderCare(doctor);
					break;
			case 3: System.out.println("Enter the name of the patient:");
					searchAnalysisResult(consoleIn.readString());
					break;
			case 4: listAllPatientExamined(doctor);
					break;
			case 5: System.out.println("Enter the name of the patient:");
					searchPatientExamined(consoleIn.readString());
					break;
			case 6: searchSurgeryAppointed(doctor);
		}
	}
	
	private void registerPatient(String patientName, String doctorName) throws DoctorNotFoundException {
		Patient patient = new WalkingCase(patientName);
		Doctor doc = hospital.searchDoctorByName(doctorName);
		if(!doctorLine.containsKey(doc)) {
			doctorLine.put(doc, new LinkedList<Patient>());
		}
		doctorLine.get(doc).add(patient);
	}
	
	private void seeNextPatient(Doctor doctor) throws DoctorNotFoundException {
		Examination examination = examinePatient(doctor);
		System.out.println(
				"1) Ask for blood test" + System.lineSeparator() + 
				"2) Ask for radiology" + System.lineSeparator() + 
				"3) Write prescription" + System.lineSeparator() + 
				"4) Decide on surgery" + System.lineSeparator() + 
				"5) Decide on therapy");
		int decision = consoleIn.readInt();
		switch(decision) {
			case 1: hospital.addAnalysis(examination.getPatient(), examination.askForBloodTest());
					break;
			case 2: hospital.addAnalysis(examination.getPatient(), examination.askForRadiology());
					break;
			case 3: examination.writePrescription();
					break;
			case 4: examination.decideSurgery();
					System.out.println("Enter date in format (dd-MM-yyyy): ");
					Date surgeryDate = dateParser(consoleIn.readString());
					if (doctor.getClass() != Surgeon.class) {
						SurgeryAppointment appointment = new SurgeryAppointment(surgeryDate,doctor,3);
					}
					
					break;
			case 5: examination.decideTherapy();
					break;
			default:
					break;
		}
		hospital.addPatient(examination.getPatient(), doctor);
		if(!examinedPatients.containsKey(doctor)) {
			examinedPatients.put(doctor, new HashSet<Patient>());
		}
		examinedPatients.get(doctor).add(examination.getPatient());
	}

  	private void listAllPatientsUnderCare(Doctor doctor) {
  		int lineNum = 1;
		for(Patient patient: hospital.getAllPatientsUnderDoctorCare(doctor)) {
			System.out.println(lineNum + ") " + patient.toString());
			lineNum++;
		}
	}

	private void searchAnalysisResult(String patientName) throws PatientNotFoundException, AnalysisNotFoundException {
		Patient patient = hospital.searchPatientByName(patientName);
		Set<Analysis> analyses = hospital.searchAnalyses(patient);
		int lineNum = 1;
		for (Analysis analysis: analyses) {
			if(analysis.getResult() == 1) {
				System.out.println(lineNum + ") " + analysis.getClass().getName() + " Result is positive");
			}else {
				System.out.println(lineNum + ") " + analysis.getClass().getName() + " Result is negative");
			}
			lineNum++;
		}
	}

	private void listAllPatientExamined(Doctor doctor) {
		System.out.println("Today you have examined: ");
		int lineNum = 1;
		for(Patient patient: examinedPatients.get(doctor)){
			System.out.println(lineNum + ") " + patient.toString());
			lineNum++;
		}
		
	}

	private Patient searchPatientExamined(String name) throws PatientNotFoundException {
		return hospital.searchPatientByName(name);
	}

	private void searchSurgeryAppointed(Doctor doctor) {
		int lineNum = 1;
		Set<SurgeryAppointment> appointments = hospital.searchAnyAppointedSurgeryForSurgeon(doctor);
		for(SurgeryAppointment appointment: appointments) {
			System.out.println(lineNum + ") " + appointment.toString());
			lineNum++;
		}
	}
  	
	private Examination examinePatient(Doctor doctor) {
		try {
			Patient patient = doctorLine.get(doctor).remove();
			Examination examination = new Examination(doctor, patient);
			return examination;
		}catch(NoSuchElementException e){
			System.out.println("There aren't any patient waiting"); 
		}
		return null;
		
	}
	
	private Date dateParser(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
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

	private void setExaminedPatients(Map<Doctor, Set<Patient>> examinedPatients) {
		this.examinedPatients = examinedPatients;
	}
}
