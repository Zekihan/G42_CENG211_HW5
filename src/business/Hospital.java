package business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import business.analysis.Analysis;
import business.doctor.Doctor;
import business.doctor.Surgeon;
import business.patient.Patient;

public class Hospital {
	
	private Map<Doctor, Set<Patient>> doctors;
	private Map<Doctor, Set<SurgeryAppointment>> surgeryAppointments;
	private Map<Patient, Set<Analysis>> analyses;
	
	public Hospital() {
		setDoctors(new HashMap<Doctor,Set<Patient>>() );
	    setSurgeryAppointments(new HashMap<Doctor,Set<SurgeryAppointment>>());
	    setAnalyses(new HashMap<Patient, Set<Analysis>>());
	}
	
	public Set<Doctor> getDoctors() {
	    return doctors.keySet();
	}

	public Set<Patient> getPatients() {
		Set<Patient> patients = new HashSet<Patient>();
		for(Set<Patient> patientSet : doctors.values()) {
			patients.addAll(patientSet);
		}
	    return patients;
	}

	public void addDoctor(Doctor doctor) {
	    doctors.put(doctor,new HashSet<Patient>());
	}
	
	public void addDoctor(Doctor doctor, Set<Patient> patients) {
	    doctors.put(doctor, patients);
	}
	
	public void addPatient(Patient patient, Doctor doctor) throws DoctorNotFoundException {
	    if(doctors.containsKey(doctor)) {
	    	doctors.get(doctor).add(patient);
	    }else {
	    	throw new DoctorNotFoundException();
	    }
	}
	
	public void addSurgeryAppointment(Surgeon surgeon, SurgeryAppointment appointment) {
		surgeryAppointments.get(surgeon).add(appointment);
	    surgeryAppointments.put(surgeon,surgeryAppointments.get(surgeon));
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
		return doctors.get(doctor);
	}
	
	public Set<Patient> getAllPatientsDoctorExamined(Doctor doctor) {
		return doctors.get(doctor);
	}
	
	public Set<Patient> searchAnyPatientThatExaminedInThePast(Doctor doctor) {
		return doctors.get(doctor);
	}
	
	public Set<SurgeryAppointment> searchAnyAppointedSurgeryForSurgeon(Doctor surgeon) {
		return surgeryAppointments.get(surgeon);
	}
	
	private void setDoctors(Map<Doctor,Set<Patient>> doctors) {
	    this.doctors = doctors;
	}

	private void setSurgeryAppointments(Map<Doctor, Set<SurgeryAppointment>> surgeryAppointments) {
		this.surgeryAppointments = surgeryAppointments;
	}

	private void setAnalyses(Map<Patient, Set<Analysis>> analysisResults) {
		this.analyses = analysisResults;
	}
}
