package business;

import business.patient.*;
import business.treatment.Therapy;
import business.treatment.Treatment;
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
		patient = new Inmate(patient.getName());
	}
	
	public Treatment decideTherapy() {
		return new Therapy();
	}	
	
	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}
	
	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Examination [doctor=" + doctor + ", patient=" + patient + "]";
	}


	
}
