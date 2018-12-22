package business;

import java.util.Date;

public class SurgeryAppointment {

	private Date date;
	private String surgeonName;
	private int numDaysAsInmate;
	
	public SurgeryAppointment(Date date, String surgeonName, int days) {
		setDate(date);
		setSurgeonName(surgeonName);
		setNumDaysAsInmate(days);
	}

	public Date getDate() {
		return date;
	}

	public String getSurgeonName() {
		return surgeonName;
	}

	public int getNumDaysAsInmate() {
		return numDaysAsInmate;
	}

	private void setDate(Date date) {
		this.date = date;
	}

	private void setSurgeonName(String surgeonName) {
		this.surgeonName = surgeonName;
	}

	private void setNumDaysAsInmate(int numDaysAsInmate) {
		this.numDaysAsInmate = numDaysAsInmate;
	}
	
	
}
