package PjtEx05;

public class Dog extends Animal {

	public Dog() {
		this.kind = "포유류";
		System.out.println("종 : "+this.kind);
	}
	
	//추상메소드 재정의
	@Override
	public void sound() {
		System.out.println("왈왈!");
	}
}
