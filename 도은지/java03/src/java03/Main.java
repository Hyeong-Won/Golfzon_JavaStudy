package java03;

public class Main {
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		cc.makeClass();
		
		//자료형은 ParentClass 이지만 객체생성은 ChildClass
		ParentClass pc = new ChildClass();
		pc.makeClass();
		
		ParentClass pc2 = new ParentClass();
		pc2.makeClass();
		
		ParentClass p[] = new ParentClass[2];
		p[0] = new ChildClass();
		p[1] = new ChildClass2();
		
		for(int i=0; i<p.length; i++) {
			p[i].makeClass();
		}
	}
}
