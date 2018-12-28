package business;

import business.patient.*;
import business.analysis.*;
import business.doctor.*;

public class Examination {
	
	private Doctor doctor;
	private Patient patient;
	
	public Examination(Doctor doc, Patient pat) {
		setDoctor(doc);
		setPatient(pat);
	}
	
	public Analysis askForRadiology() {
		return new Radiology();
	}
	
	public Analysis askForBloodTest() {
		return new BloodTest();
	}
	
	public void decideSurgery() {
		if (doctor.getClass() != Surgeon.class) {
			
		}
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void decideTherapy() {
		
	}	
	public void writePrescription() {
		// TODO Auto-generated method stub
		
	}
	
	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}


	
}
