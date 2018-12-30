package dataaccess;

import java.io.*;
import java.util.*;

public class  ReadCsv {

	private String fileName;
	
	public ReadCsv(String fileName) {
		setFileName(fileName);
	}

	public String[][] readCsv() {
		ArrayList<String[]> lineList = new ArrayList<String[]>();
		boolean done = false;
		
			try {
				BufferedReader fileInStream = new BufferedReader(new FileReader(fileName));
				while(done == false) {
					String line = fileInStream.readLine();
					if(line != null) {
						StringTokenizer st = new StringTokenizer(line, ",");
						ArrayList<String> tokenList = new ArrayList<String>();
						while(st.hasMoreTokens()){
							tokenList.add(st.nextToken());
						}
						String[] tokenArr = tokenList.toArray(new String[tokenList.size()]);
						lineList.add(tokenArr);
					} else {
						done = true;
						fileInStream.close();
					}
				}	
			} catch(FileNotFoundException e) {
				System.out.println("File" + fileName + "not found");
				System.out.println("Exception: " + e.getMessage());
				System.exit(-1);
			} catch(IOException e) {
				System.out.println("Error reading from file" + fileName);
				System.out.println("Exception: " + e.getMessage());
				System.exit(-1);
			}
			
			String[][] lineArr = lineList.toArray(new String[lineList.size()][lineList.get(0).length]);
			return lineArr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReadCsv [fileName=").append(fileName).append("]");
		return builder.toString();
	}

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
