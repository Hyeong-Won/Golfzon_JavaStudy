package lec27Pjt004;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainClass0041 {
	
	public static void main(String[] args) {
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
		try {
			
			inputStream = new FileInputStream("C:\\java\\pjt_ex\\helloWorld.txt");
			dataInputStream = new DataInputStream(inputStream);
			
			String str = dataInputStream.readUTF();
			
			outputStream = new FileOutputStream("C:\\java\\pjt_ex\\helloWorldCopy.txt");
			dataOutputStream = new DataOutputStream(outputStream);
			
			dataOutputStream.writeUTF(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(dataOutputStream != null) dataOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(outputStream != null) outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
