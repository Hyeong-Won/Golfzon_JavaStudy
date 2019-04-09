package common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import main.Main;
public class UserManager implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> user;
	
	public UserManager() {
		this.user = new ArrayList<User>();
	}
	
	public void addUser(User user, Socket s) {
		OutputStream     os  = null;
		DataOutputStream dos = null;
		if(findUserByName(user.getUserName()) == null) {
			try {
				os  = s.getOutputStream();
				dos = new DataOutputStream(os);
				
				dos.writeUTF(Main.GetOrderReadString("\'" +user.getUserName() +"\' 계정이 정상 생성되었습니다."));
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.user.add(user);			
		}
		else {
			try {
				os  = s.getOutputStream();
				dos = new DataOutputStream(os);
				
				dos.writeUTF(Main.GetOrderReadString("\'" +user.getUserName() +"\' 로그인 되었습니다."));
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public User findUserByName(String name) {
		for (User user : this.user) {
			if(user.getUserName().equals(name)) {
				return user;
			}
		}
		return null;
	}
	
	public void printAllUser(User curUser) {
		for (User user : this.user) {
			Main.orderRead(curUser.getUserName(), user.toString());
		}
	}
}
