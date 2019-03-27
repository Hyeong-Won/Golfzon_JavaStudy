package java03;

public class ClassEx extends AbstractClassEx{
	
	public ClassEx() {
		System.out.println("ClassEx constructor");
	}
	
	public ClassEx(int i, String s) {
		super(i,s);
	}
	
	@Override
	public void fun2() {
		System.out.println("fun2()");
	}
	
	public static void main(String[] args) {
		AbstractClassEx ac = new ClassEx(1,"java");
		
		ac.fun1();
		ac.fun2();
		
		System.out.println(ac.num + "," + ac.str);
	}
}
