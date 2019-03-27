package com.java.main;

import com.java.dailyJournal.DailyJournal;
import com.java.employee.Employee;
import com.java.employeeBank.EmployeeBank;
import com.java.pay.Payment;
import com.java.pay.fullTime.FullTime;
import com.java.pay.partTime.PartTime;
import com.java.util.Util;
import com.java.welfare.Welfare;

public class MainClass {

	public static void main(String[] args) {
		
		DailyJournal dailyJournal = new DailyJournal();
		Employee employee = new Employee();
		Payment payment = new Payment();
		FullTime fullTime = new FullTime();
		PartTime partTime = new PartTime();
		Util util = new Util();
		Welfare welfare = new Welfare();
		
		System.out.println();
		
		EmployeeBank parkBank = new EmployeeBank("¹ÚÂùÈ£");
		parkBank.saveMoney(100);
		
		EmployeeBank leeBank = new EmployeeBank("ÀÌ½Â¿±");
		leeBank.saveMoney(300);
		
		leeBank.getBankInfo();
		
		parkBank.spendMoney(400);
		
		leeBank.getBankInfo();
		
		
	}
	
}
