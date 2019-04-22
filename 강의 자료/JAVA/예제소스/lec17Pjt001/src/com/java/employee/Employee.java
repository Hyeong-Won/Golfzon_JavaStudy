package com.java.employee;

public class Employee {

//	public String name;
//	public String no;
//	public int pay;
	
	private String name;
	private String no;
	private int pay;
	
	public Employee(String name, String no, int pay) {
		
		this.name = name;
		this.no = no;
		this.pay = pay;
		
	}
	
	public void getInfo() {
		
		System.out.printf("name : %s, no : %s, pay : %d\n", this.name, this.no, this.pay);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println(" -- The name can not be modified.-- ");
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		System.out.println(" -- The no can not be modified.-- ");
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		if(pay < 1000000) {
			System.out.println(" -- The salary can not be reduced to less than 1,000,000 won.-- ");
		} else {
			System.out.println(" -- The salary has been modified -- ");
			this.pay = pay;
		}
	}
	
}
