package testPjt18;

public class FirstChildClass extends ParentClass {

		public FirstChildClass() {
			System.out.println("FirstChildClass constructor");
		}		
		
		@Override
		public void makeJJang() {
			System.out.println("-- more makeJJang() --");
		}		
}
