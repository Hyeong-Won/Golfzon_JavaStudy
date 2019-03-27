package testPjt18;

public class MainClass {

		public static void main(String[] args) {
			
				ParentClass[] pArr = new ParentClass[2];
				
									
				ParentClass fch = new FirstChildClass();
				ParentClass sch = new SecondChildClass();
				
				pArr[0] = fch;
				pArr[1] = sch;
				
						
				/*
				childClass.childFun();
				childClass.parentFun();
				*/
				
				
		}
}
