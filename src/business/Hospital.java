package business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import business.analysis.Analysis;
import business.doctor.Doctor;
import business.doctor.Surgeon;
import business.patient.Patient;
import business.exceptions.*;

public class Hospital {
	
	private Map<Doctor, Set<Patient>> doctorsMap;
	private Map<Doctor, Set<SurgeryAppointment>> surgeryAppointments;
	private Map<Patient, Set<Analysis>> analyses;
	
	public Hospital() {
		setDoctors(new HashMap<Doctor,Set<Patient>>() );
	    setSurgeryAppointments(new HashMap<Doctor,Set<SurgeryAppointment>>());
	    setAnalyses(new HashMap<Patient, Set<Analysis>>());
	}
	
	public Set<Doctor> getDoctors() {
	    return doctorsMap.keySet();
	}

	public Set<Patient> getPatients() {
		Set<Patient> patients = new HashSet<Patient>();
		for(Set<Patient> patientSet : doctorsMap.values()) {
			patients.addAll(patientSet);
		}
	    return patients;
	}

	public void addDoctor(Doctor doctor) {
	    doctorsMap.put(doctor,new HashSet<Patient>());
	}
	
	public void addDoctor(Doctor doctor, Set<Patient> patients) {
	    doctorsMap.put(doctor, patients);
	}
	
	public void addPatient(Patient patient, Doctor doctor) throws DoctorNotFoundException {
	    if(doctorsMap.containsKey(doctor)) {
	    	doctorsMap.get(doctor).add(patient);
	    }else {
	    	throw new DoctorNotFoundException();
	    }
	}
	
	public void addSurgeryAppointment(Doctor doctor, SurgeryAppointment appointment) {
		surgeryAppointments.get(doctor).add(appointment);
	    surgeryAppointments.put(doctor,surgeryAppointments.get(doctor));
	}
	
	public void addAnalysis(Patient patient,Analysis analysis){
		if(!analyses.containsKey(patient)) {
			analyses.put(patient, new HashSet<Analysis>());
		}
		analyses.get(patient).add(analysis);
	}
	
	public Set<Analysis> searchAnalyses(Patient patient) throws AnalysisNotFoundException{
		Set<Analysis> analysis = analyses.get(patient);
		if(analysis == null) {
			throw new AnalysisNotFoundException();
		}else {
			return analysis;
		}
	}
	
	public Set<Patient> getAllPatientsUnderDoctorCare(Doctor doctor) {
		return doctorsMap.get(doctor);
	}
	
	public Set<Patient> getAllPatientsDoctorExamined(Doctor doctor) {
		return doctorsMap.get(doctor);
	}
	
	public Doctor searchSurgeonWithProfession(String profession) throws DoctorNotFoundException {
		for (Doctor doctor: doctorsMap.keySet()) {
			if(profession.equals(doctor.getProfession()) && doctor.getClass() == Surgeon.class) {
				return doctor;
			}
		}
		throw new DoctorNotFoundException();
	}
	
	public Set<Patient> searchAnyPatientThatExaminedInThePast(Doctor doctor) {
		return doctorsMap.get(doctor);
	}
	
	public Set<SurgeryAppointment> searchAnyAppointedSurgeryForSurgeon(Doctor surgeon) {
		return surgeryAppointments.get(surgeon);
	}
	
	public Patient searchPatientByName(String name) throws PatientNotFoundException {
		Set<Patient> patients = getPatients();
		for(Patient patient: patients) {
			if(patient.getName().equals(name)) {
				return patient;
			}
		}
		throw new PatientNotFoundException();
	}
	
	public Doctor searchDoctorByName(String name) throws DoctorNotFoundException {
		Set<Doctor> doctorsSet = getDoctors();
		for(Doctor doctor: doctorsSet) {
			if(doctor.getName().equals(name)) {
				System.out.println("yes");
				return doctor;
			}
		}
		throw new DoctorNotFoundException();
	}
	
	private void setDoctors(Map<Doctor,Set<Patient>> doctors) {
	    this.doctorsMap = doctors;
	}

	private void setSurgeryAppointments(Map<Doctor, Set<SurgeryAppointment>> surgeryAppointments) {
		this.surgeryAppointments = surgeryAppointments;
	}

	private void setAnalyses(Map<Patient, Set<Analysis>> analysisResults) {
		this.analyses = analysisResults;
	}
}
