package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import business.doctor.Doctor;
import business.doctor.Surgeon;
import business.patient.Patient;

public class Hospital {
	
	private Map<Doctor, Set<Patient>> doctors;
	private Map<Surgeon, Set<SurgeryAppointment>> surgeryAppointments;
	private Map<Patient, Set<Patient>> analysisResults;
	
	public Hospital() {
		setDoctors(new HashMap<Doctor,Set<Patient>>() );
	    setSurgeryAppointments(new HashMap<Surgeon,Set<SurgeryAppointment>>());
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
	
	public void addPatient(Patient patient, Doctor doctor) throws NoSuchDoctorException {
	    if(doctors.containsKey(doctor)) {
	    	doctors.get(doctor).add(patient);
	    }else {
	    	throw new NoSuchDoctorException();
	    }
	}
	
	public void addSurgeryAppointment(Surgeon surgeon, SurgeryAppointment appointment) {
		surgeryAppointments.get(surgeon).add(appointment);
	    surgeryAppointments.put(surgeon,surgeryAppointments.get(surgeon));
	}
	
	private void setDoctors(Map<Doctor,Set<Patient>> doctors) {
	    this.doctors = doctors;
	}

	private void setSurgeryAppointments(Map<Surgeon, Set<SurgeryAppointment>> surgeryAppointments) {
		this.surgeryAppointments = surgeryAppointments;
	}
	
	
}
