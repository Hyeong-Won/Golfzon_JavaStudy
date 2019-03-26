package java03;

public class ChildClass extends ParentClass{
	int intP = 100;
	
	@Override
	public void makeClass() {
		System.out.println("Child make More Class");
	}
	
	public void printIntP() {
		System.out.println("Parent's P : " + super.intP);
		System.out.println("Child's P : " + this.intP);
	}
	
	public static void main(String[] args) {
		ChildClass c = new ChildClass();
		
		c.printIntP();
	}
}
