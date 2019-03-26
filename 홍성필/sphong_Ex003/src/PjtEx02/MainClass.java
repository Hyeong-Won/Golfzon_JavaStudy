package PjtEx02;

public class MainClass {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass(); //객체생성
		child.makeJJajang();//부모클래스를 오버라이드하여 사용
		
		System.out.println();
		
		ParentClass childs[] = new ParentClass[2]; 
		childs[0] = new FirstChildClass();
		childs[1] = new SecondChildClass();
		
		for (int i = 0; i < childs.length; i++) {
			childs[i].makeJJajang();
		}
		
		System.out.println();
		
		Object objs[] = new Object[2];
		objs[0] = new FirstChildClass();
		objs[1] = new SecondChildClass();
		
		for (int i = 0; i < objs.length; i++) {
			
			if(i == 0) {
				((FirstChildClass)objs[i]).makeJJajang();
			} else {
				((SecondChildClass)objs[i]).makeJJajang();
			}
		}
		
		System.out.println();
		
		// super
		ChildClass c = new ChildClass();
		c.getOpenYear();
	}
	
}
