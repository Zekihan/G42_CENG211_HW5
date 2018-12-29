package business;

import java.util.Date;

import business.doctor.Doctor;
import business.doctor.Surgeon;

public class SurgeryAppointment {

	private Date date;
	private Doctor surgeon;
	private int numDaysAsInmate;
	
	public SurgeryAppointment(Date date, Doctor doctor, int days) {
		setDate(date);
		setSurgeon(doctor);
		setNumDaysAsInmate(days);
	}

	public Date getDate() {
		return date;
	}

	public String getSurgeonName() {
		return surgeon.getName();
	}

	public int getNumDaysAsInmate() {
		return numDaysAsInmate;
	}

	private void setDate(Date date) {
		this.date = date;
	}

	private void setSurgeon(Doctor surgeon) {
		this.surgeon = surgeon;
	}

	private void setNumDaysAsInmate(int numDaysAsInmate) {
		this.numDaysAsInmate = numDaysAsInmate;
	}
	
	
}
