package lec13Pjt001;

public class ChildClass {

	public int i = 10;
	public boolean b = true;
	public double d = 1.23d;
	public char c = 'j';
	public String s = "java";
	
	// 생성자
	public ChildClass() {
		System.out.println("ChildClass constructor");
	}
	
	// 반환 형
	public String getS() {
			
		return s;
			
	}
		
	// 중복 메서드(overloading)
	public void getInfo() {
		
		System.out.println("-- getInfo - I --");
		System.out.println(" i = " + i);
		System.out.println(" b = " + b);
		System.out.println(" d = " + d);
		System.out.println(" c = " + c);
		System.out.println(" s = " + s);
	}
	
	public void getInfo(int x, int y) {
		
		System.out.println("-- getInfo - II --");
		System.out.printf("parameter --> x : %d, y : %d\n", x, y);

	}

	public void getInfo(String s1, String s2) {
	
		System.out.println("-- getInfo - III --");
		System.out.printf("parameter --> s1 : %s, s2 : %s\n", s1, s2);

	}
	
	// 매개변수(parameter)
	public void setInfo(int i, boolean b, double d, char c, String s) {
		
		this.i = i;
		this.b = b;
		this.d = d;
		this.c = c;
		this.s = s;

	}
	
	// 접근자
	private void methodPrivate() {
		
		System.out.println(" -- methodPrivate --");
		
	}
	
	public void methodPublic() {
		
		System.out.println(" -- methodPublic --");
		methodPrivate();
		
	}
}
