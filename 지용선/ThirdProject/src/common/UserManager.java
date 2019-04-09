package common;

import java.util.ArrayList;


public class UserManager {
	private ArrayList<User> user;
	
	public UserManager() {
		this.user = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		if(findUserByName(user.getUserName()) == null) {
			System.out.println("\'" +user.getUserName() +"\' 계정이 정상 생성되었습니다.");
			this.user.add(user);			
		}
		else {
			System.out.println("이미 등록된 사용자입니다.");
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
