package common;

import java.util.ArrayList;


public class UserManager {
	private ArrayList<User> user;
	
	public UserManager() {
		this.user = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		if(findUserByName(user.getUserName()) == null) {
			System.out.println("\'" +user.getUserName() +"\' ������ ���� �����Ǿ����ϴ�.");
			this.user.add(user);			
		}
		else {
			System.out.println("�̹� ��ϵ� ������Դϴ�.");
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
	
	public void printAllUser() {
		
		for (User user : this.user) {
			System.out.println(user);
		}
	}
}
