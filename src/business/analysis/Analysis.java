package business.analysis;

import java.util.Date;
import java.util.Random;

public abstract class Analysis {
	
	private int result;
	private Date resultDate;
	
	public Analysis(int NumOfDaysRequired){
		setResult(-1);
		setResultDate(resultDateCalc(NumOfDaysRequired));
	}
	
	public int getResult() {
		Date now = new Date();
		if(result == -1 && now.after(resultDate)) {
			Random rand = new Random();
			setResult(rand.nextInt(2));
		}
		return result;
	}
	
	public Date getResultDate() {
		return resultDate;
	}

	private Date resultDateCalc(int NumOfDaysRequired) {
		long timeInMs = NumOfDaysRequired * 86400000;
		Date dateNow = new Date();
		Date resultDate = new Date(dateNow.getTime() + timeInMs);
		return resultDate;
	}

	private void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	private void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Analysis [result=" + result + ", resultDate=" + resultDate + "]";
	}
	
}
