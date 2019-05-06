package lec22Pjt002;

public abstract class Bank {

	String name;
	String account;
	int totalAmount;
	
	public Bank() {
		System.out.println("Bank constructor");
	}
	
	public Bank(String name, String account, int totalAmount) {
		System.out.println("Bank constructor");
		
		this.name = name;
		this.account = account;
		this.totalAmount = totalAmount;
	}
	
	// 예금
	public void deposit() {
		System.out.println(" -- deposit() START -- ");
	}
	
	// 출금
	public void withdraw() {
		System.out.println(" -- withdraw() START -- ");
	}
	
	// 적금
	public abstract void installmentSavings();
	
	// 해약
	public abstract void cancellation();
	
	// 정보출력
	public void getInfo() {
		System.out.printf("name : %s\n", name);
		System.out.printf("account : %s\n", account);
		System.out.printf("totalAmount : %d\n", totalAmount);
	}
}
