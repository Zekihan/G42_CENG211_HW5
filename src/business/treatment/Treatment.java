package business.treatment;

import java.util.Date;

public abstract class Treatment {
	
	private Date date;
	
	public Treatment(Date date) {
		setDate(date);
	}

	private void setDate(Date date) {
		this.date = date;
	}
}
