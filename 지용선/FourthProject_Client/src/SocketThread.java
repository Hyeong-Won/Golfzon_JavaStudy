

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketThread extends Thread 
{
	Socket s;
	public SocketThread(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() 
	{
		OutputStream     os   = null;
		DataOutputStream dos  = null;
		Scanner          scan = null;
		try {
			scan = new Scanner(System.in);
			
			os  = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			dos.writeUTF(scan.nextLine());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}