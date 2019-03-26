package PjtEx05;

public class AnimalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		
		dog.sound();
		System.out.println("----------");
		
		Animal animal = null;
		animal = new Dog();
		animal.sound();
		
		System.out.println("----------");
	}

}
