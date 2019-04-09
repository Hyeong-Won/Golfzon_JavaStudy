package lec21Pjt002;

import com.java.toy.Toy;
import com.java.toy.ToyAirplane;
import com.java.toy.ToyRobot;

public class MainClass {

	public static void main(String[] args) {
		
		Toy robot = new ToyRobot();
		Toy airplane = new ToyAirplane();
		
		Toy toys[] = {robot, airplane};
		
		for (int i = 0; i < toys.length; i++) {
			toys[i].walk();
			toys[i].run();
			toys[i].alarm();
			toys[i].light();
			
			System.out.println();
		}
		
	}
	
}
