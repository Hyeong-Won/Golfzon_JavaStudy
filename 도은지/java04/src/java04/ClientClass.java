package java04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {
	public static void main(String[] args) {

		Socket socket = null;

		OutputStream os = null;
		DataOutputStream dateOS = null;

		InputStream is = null;
		DataInputStream dataIS = null;

		Scanner scn = null;

		try {

			socket = new Socket("localhost", 9000);
			System.out.println("서버 연결 완료");

			os = socket.getOutputStream();
			dateOS = new DataOutputStream(os);

			is = socket.getInputStream();
			dataIS = new DataInputStream(is);

			scn = new Scanner(System.in);

			while (true) {
				System.out.println("메세지 입력");
				
				String outMessage = scn.nextLine();
				
				dateOS.writeUTF(outMessage);
				dateOS.flush();

				String inMessage = dataIS.readUTF();
				
				System.out.println("inMessage : " + inMessage);

				if(outMessage.equals("STOP")) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if(dateOS != null) {
					dateOS.close();
				}
				if(os != null) {
					os.close();
				}
				if(dataIS != null) {
					dataIS.close();
				}
				if(is != null) {
					is.close();
				}
				if(socket != null) {
					socket.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
