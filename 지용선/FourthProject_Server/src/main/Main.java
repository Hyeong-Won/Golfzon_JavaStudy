package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import common.CommonConst;
import common.FileManager;
import common.User;
import common.UserManager;

public class Main {
	public static HashMap<String,Socket> clients = null;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket       client       = null;		
		OutputStream     os  = null;
		DataOutputStream dos = null;
		
		InputStream     is  = null;
		DataInputStream dis = null;
		String username     = null;
		try {
			serverSocket = new ServerSocket(9998);
			clients      = new HashMap<String,Socket>();
			while(true) {
				try {
					client = serverSocket.accept();
					
					os  = client.getOutputStream();
					dos = new DataOutputStream(os);
					is  = client.getInputStream();
					dis = new DataInputStream(is);
					
					username = dis.readUTF();
					
					UserManager um = new UserManager();
					um = FileManager.loadFile(um);
					if(um.findUserByName(username) == null) {
						User user = new User(username);
						um.addUser(user, client);
						FileManager.saveFile(um);
					}
					System.out.println(username+" 연결");
					new SocketThread(client, username).start();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clients.put(username,client);
				System.out.println("쓰레드추가");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String GetMenu()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("=========================\n");
		sb.append("1: 캐시충전/아이템 구매\n");
		sb.append("2: 게임시작\n");
		sb.append("3: 전체유저보기\n");
		sb.append("4: 전체게임로그보기\n");
		sb.append("99: 종료\n");
		sb.append("=========================\n");
		return sb.toString(); 
	}
	
	public static String GetOrderReadString(String s) {
		return CommonConst.ORDER_READ + CommonConst.ORDER_DELEMETER + s;
	}
	
	public static String GetOrderWriteString() {
		return CommonConst.ORDER_WRITE + CommonConst.ORDER_DELEMETER + "/";
	}
	
	public static String GetOrderTerminateString() {
		return CommonConst.ORDER_TERMINATE + CommonConst.ORDER_DELEMETER + "/";
	}
	
	public static String getUserName()
	{
		return "유저 이름을 입력해주세요 : ";
	}
	
	public static void orderRead(String username, String text)
	{
		OutputStream     os  = null;
		DataOutputStream dos = null;
		
		Socket s = clients.get(username);
		
		try {
			os  = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			dos.writeUTF(GetOrderReadString(text));
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void orderTerminate(String username)
	{
		OutputStream     os  = null;
		DataOutputStream dos = null;
		
		Socket s = clients.get(username);
		
		try {
			os  = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			dos.writeUTF(GetOrderTerminateString());
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String orderWrite(String username)
	{
		InputStream     is  = null;
		DataInputStream dis = null;
		OutputStream     os  = null;
		DataOutputStream dos = null;
		
		Socket s = clients.get(username);
		
		try {
			is  = s.getInputStream();
			dis = new DataInputStream(is);
			os  = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			dos.writeUTF(GetOrderWriteString());
			
			return dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public static void BroadCastAllUser(String Text)
	{
		OutputStream     os  = null;
		DataOutputStream dos = null;
		
		for(String key : clients.keySet()) {
			Socket s = clients.get(key);
			try {
				os  = s.getOutputStream();
				dos = new DataOutputStream(os);
				
				dos.writeUTF(GetOrderReadString(Text));
				dos.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

