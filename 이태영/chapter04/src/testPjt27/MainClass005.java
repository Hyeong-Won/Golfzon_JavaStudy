package testPjt27;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainClass005 {

	public static void main(String[] args) {
		String fileName = "C:\\java\\helloReader.txt";
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr =  new FileReader(fileName);
			br = new BufferedReader(fr);
			
			String strLine;
			
			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
