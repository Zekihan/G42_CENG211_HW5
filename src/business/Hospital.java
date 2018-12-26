package business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import business.doctor.Doctor;
import business.patient.Patient;

public class Hospital {
	
	private Set<Doctor> doctors;
	private Set<Patient> patients;
	private List<SurgeryAppointment> surgeryAppointments;
	
	public Hospital() {
		this(new HashSet<>(), new HashSet<>(), new ArrayList<>());
	}
	
	public Hospital(Set<Doctor> doctors, Set<Patient> patients, List<SurgeryAppointment> surgeryAppointments) {
	    setDoctors(doctors);
	    setPatients(patients);
	    setSurgeryAppointments(surgeryAppointments);
	}
	
	public Set<Doctor> getDoctors() {
	    return doctors;
	}

	public Set<Patient> getPatients() {
	    return patients;
	}

	public void addDoctor(Doctor doctor) {
	    doctors.add(doctor);
	}
	
	public void addPatient(Patient patient) {
	    patients.add(patient);
	}
	
	public void addSurgeryAppointment(SurgeryAppointment appointment) {
	    surgeryAppointments.add(appointment);
	}
	
	private void setDoctors(Set<Doctor> doctors) {
	    this.doctors = doctors;
	}

	private void setPatients(Set<Patient> patients) {
	    this.patients = patients;
	}

	private void setSurgeryAppointments(List<SurgeryAppointment> surgeryAppointments) {
		this.surgeryAppointments = surgeryAppointments;
	}
	
	
}
