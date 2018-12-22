package business;

import java.util.List;

import business.doctor.Doctor;
import business.patient.Patient;

public class Hospital {
	
	private List<Doctor> doctors;
	private List<Patient> patients;
	
	public Hospital(List<Doctor> doctors, List<Patient> patients) {
	    setDoctors(doctors);
	    setPatients(patients);
	}
	
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	private void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	private void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
	
	public void addPatint(Patient patient) {
		patients.add(patient);
	}
	
}
