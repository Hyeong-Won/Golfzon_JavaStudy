package lec17Pjt001;

import com.java.employee.Employee;

public class MainClass {

	public static void main(String[] args) {
		
		Employee employeePark = new Employee("박찬호", "2018-00001", 1000000);
		
		employeePark.getInfo();
		
//		employeePark.no = "2018-00002";
//		employeePark.pay = 900000;
		
		employeePark.setName("박병호");
		employeePark.setPay(900000);
		
		employeePark.getInfo();
		
	}
	
}
