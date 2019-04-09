package PjtEx03;

import java.io.IOException;
import java.net.Socket;

public class MainClassSocket {

	public static void main(String[] args) {
		
		Socket socket = null; //Socket객체 초기화
		
		try {
			//127.0.0.1
			socket = new Socket("localhost", 9000);	 //localhost , 9000번 포트 생성
			System.out.println("서버 연결~~");
			System.out.println("socket: " + socket);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}	
		
	}
	
}
