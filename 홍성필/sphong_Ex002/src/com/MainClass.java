package com;

import PjtEx07.com.java.employee.Employee;

public class MainClass {

	public static void main(String[] args) {
		
		Employee employeeLee = new Employee("이승엽", "2018-00001", 1000000);
		
		employeeLee.getInfo();
		
		//employeePark.no = "2018-00002";
		//employeePark.pay = 100000;
		
		employeeLee.setName("강정호");
		employeeLee.setPay(100000);
		
		employeeLee.getInfo();
		
	}
	
}
