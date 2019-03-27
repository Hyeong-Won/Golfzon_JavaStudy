package PjtEx05;

public class ObjectEx {
	
	int num;
	String str;
	int nums[];
	
	public ObjectEx() {
		System.out.println("Default constructor");
	}
	
	public ObjectEx(int i) {
		System.out.println("Custom constructor");
		
		num = i;
	}
	
	public ObjectEx(String s, int i[]) {
		System.out.println("UserDefined constructor");
		
		str = s;
		nums = i;
	}
	
	public ObjectEx(int i, String s, int is[]) {
		System.out.println("UserDefined constructor");
		
		this.num = i;
		this.str = s;
		this.nums = is;	
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(" -- finalize() method --");
		
		super.finalize();
	}

}
