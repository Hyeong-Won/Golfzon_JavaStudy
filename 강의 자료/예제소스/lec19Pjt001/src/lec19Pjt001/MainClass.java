package lec19Pjt001;

public class MainClass {

	public static void main(String[] args) {
		
		// 메서드 오버라이드(Override)
		ChildClass child = new ChildClass();
		child.makeJJajang();
		
		System.out.println();
		
		// 자료형(타입)
		ParentClass childs[] = new ParentClass[2];
		childs[0] = new FirstChildClass();
		childs[1] = new SecondChildClass();
		
		for (int i = 0; i < childs.length; i++) {
			childs[i].makeJJajang();
		}
		
		System.out.println();
		
		// Object 클래스
		Object objs[] = new Object[2];
		objs[0] = new FirstChildClass();
		objs[1] = new SecondChildClass();
		
		for (int i = 0; i < objs.length; i++) {
//			objs[i].makeJJajang();
			
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
