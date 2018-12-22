package business;

import business.patient.*;
import business.doctor.*;

public class Examination {
	
	private Doctor doctor;
	private Patient patient;
	
	public Examination(Doctor doc, Patient pat) {
		setDoctor(doc);
		setPatient(pat);
	}
	
	public void decideTreatment() {
		
	}
	
	public void askAnalysis() {
		
	}
	

	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
