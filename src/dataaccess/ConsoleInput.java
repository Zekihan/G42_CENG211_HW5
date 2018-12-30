package dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConsoleInput {
	
	private Scanner keyboard;
	
	public ConsoleInput() {
		setKeyboard(new Scanner(System.in));
	}
	
	public int readInt() {
		int inputValue = keyboard.nextInt();
		return inputValue;
	}
	
	public String readString() {
		keyboard.useDelimiter(System.lineSeparator());
		String inputValue = keyboard.next();
		return inputValue;
	}
	
	public double readDouble() {
		
		double inputValue = keyboard.nextDouble();
		return inputValue;
	}
	
	public List<String> readLineOfString() {
		
		List<String> inputList = new ArrayList<String>();
		String str = keyboard.next();
		StringTokenizer strTok = new StringTokenizer(str, ",");
		while(strTok.hasMoreTokens()) {
			inputList.add(strTok.nextToken());
		}
		return inputList;
	}
	
	public List<Integer> readLineOfInteger() {
		
		List<Integer> inputList = new ArrayList<>();
		String str = keyboard.next();
		StringTokenizer strTok = new StringTokenizer(str, ",");
		while(strTok.hasMoreTokens()) {
			inputList.add(Integer.parseInt(strTok.nextToken()));
		}
		return inputList;
	}
	public void closeKeyboard() {
		keyboard.close();
	}

	private void setKeyboard(Scanner keyboard) {
		this.keyboard = keyboard;
	}
	
	
	
}
