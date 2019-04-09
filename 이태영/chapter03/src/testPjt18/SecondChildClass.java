package testPjt18;

public class SecondChildClass extends ParentClass {
		public SecondChildClass() {
			System.out.println("SecondClass constructor");
		}
		
		@Override
		public void makeJJang() {
			System.out.println("-- SecondClass's makeJJang() --");
		}		
}
