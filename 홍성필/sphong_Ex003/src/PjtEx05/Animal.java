package PjtEx05;

public abstract class Animal {

	public String kind;
	
	public void breathe() {
		System.out.println("숨쉬기");
	}
	
	public abstract void sound(); //추상메소드
}
