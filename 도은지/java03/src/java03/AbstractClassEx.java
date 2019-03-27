package java03;

public abstract class AbstractClassEx {
	int num;
	String str;
	
	public AbstractClassEx() {
		System.out.println("AbstractClassEx constructor");
	}
	
	public AbstractClassEx(int i, String s) {
		System.out.println("AbstractClassEx constructor");
		this.num = i;
		this.str = s;
	}
	
	public void fun1() {
		System.out.println("fun1()");
	}
	
	public abstract void fun2();
}
