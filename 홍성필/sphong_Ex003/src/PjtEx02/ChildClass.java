package PjtEx02;

public class ChildClass extends ParentClass {

	int openYear = 2000;
	
	public ChildClass() {
		System.out.println("ChildClass constructor");
	}
	
	@Override
	public void makeJJajang() {
		System.out.println(" -- more delicious makeJJajang() START --");
	}
	
	public void getOpenYear() {
		System.out.println("ChildClass's Open year : " + this.openYear);
		System.out.println("ParentClass's Open year : " + super.openYear);
	}

}
