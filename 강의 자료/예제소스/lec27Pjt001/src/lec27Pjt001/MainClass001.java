package lec27Pjt001;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainClass001 {
	
	public static void main(String[] args) {
		
		/*
		// read()
		InputStream inputStream = null;
		try {
			
			inputStream = new FileInputStream("C:\\java\\pjt_ex\\hello.txt");
			int data = 0;
			
			while(true) {
				
				try {
					data = inputStream.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(data == -1) break;
				System.out.println("data : " + data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
				try {
					if(inputStream != null) inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		*/
		
		
		// read(byte[])
				InputStream inputStream = null;
				try {
					
					inputStream = new FileInputStream("C:\\java\\pjt_ex\\hello.txt");
					int data = 0;
					byte[] bs = new byte[3]; 
					
					while(true) {
						
						try {
							data = inputStream.read(bs);
						} catch (IOException e) {
							e.printStackTrace();
						}
						if(data == -1) break;
						System.out.println("data : " + data);
						for (int i = 0; i < bs.length; i++) {
							System.out.println("bs[" + i + "] : " + bs[i]);
						}
						
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
						try {
							if(inputStream != null) inputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
		
	}
	
}
