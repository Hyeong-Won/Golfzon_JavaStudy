package testPjt28;

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
			
			InputStream inputStream = null;
			DataInputStream dataInputStream = null;
			
			OutputStream outputStream = null;
			DataOutputStream dataOutputStream = null;
			
			try {
				serverSocket = new ServerSocket(9000);
				System.out.println("Ŭ���̾�Ʈ ���� �غ� �Ϸ�!!");
				
				socket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ ����!!");
				System.out.println("socket : " + socket);
				
				inputStream = socket.getInputStream();
				dataInputStream = new DataInputStream(inputStream);
				
				outputStream = socket.getOutputStream();
				dataOutputStream = new DataOutputStream(outputStream);
				
				while(true) {
					String clientMessage = dataInputStream.readUTF();
					System.out.println("clientMessage : " + clientMessage);
					
					dataOutputStream.writeUTF("�޽��� ���� �Ϸ�!!");
					dataOutputStream.flush();
					
					if(clientMessage.equals("STOP")) break;
				}
				
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(dataOutputStream != null) dataOutputStream.close();
						if(outputStream != null) outputStream.close();
						if(dataInputStream != null) dataInputStream.close();
						if(inputStream != null) inputStream.close();
						if(socket != null) socket.close();
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			
	
	}
	
}
