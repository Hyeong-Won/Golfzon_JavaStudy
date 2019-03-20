package PjtEx06.com.java.main;

import PjtEx06.com.java.employeeBank.EmployeeBank;

public class MainClass {

	public static void main(String[] args) {
			
		System.out.println();
		
		EmployeeBank kangBank = new EmployeeBank("강정호");
		kangBank.saveMoney(100);
		
		EmployeeBank leeBank = new EmployeeBank("이승엽");
		leeBank.saveMoney(300);
		leeBank.getBankInfo();
		kangBank.spendMoney(400);
		leeBank.getBankInfo();		
	}
	
}
