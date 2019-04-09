package java04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;

		InputStream is = null;
		DataInputStream dataIS = null;

		OutputStream os = null;
		DataOutputStream dateOS = null;

		try {

			serverSocket = new ServerSocket(9000);
			System.out.println("클라이언트 맞을 준비 완료");

			socket = serverSocket.accept();
			
			System.out.println("클라이언트 연결");
			System.out.println("socket : " + socket);

			is = socket.getInputStream();
			dataIS = new DataInputStream(is);

			os = socket.getOutputStream();
			dateOS = new DataOutputStream(os);

			while (true) {
				String clientMessage = dataIS.readUTF();
				
				System.out.println("clientMessage : " + clientMessage);

				dateOS.writeUTF("메시지 전송 완료");
				dateOS.flush();

				if(clientMessage.equals("STOP")) {
					break;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if(dataIS != null) {
					dataIS.close();
				}
				if(is != null) {
					is.close();
				}
				if(dateOS != null) {
					dateOS.close();
				}
				if(os != null) {
					os.close();
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
