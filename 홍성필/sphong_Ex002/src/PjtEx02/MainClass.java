package PjtEx02;

import PjtEx02.Bicycle;
import PjtEx02.AirAsia;

public class MainClass {

	public static void main(String[] args) {
		
		AirAsia airplane = new AirAsia();
		airplane.color = "Red";
		airplane.weight = "285t";
		airplane.length = "73m";
		
		airplane.takeoff();
		airplane.landing();
		airplane.info();
		
		System.out.println();
		
		AirAsia airplane2 = new AirAsia();
		airplane2.color = "blue";
		airplane2.weight = "310t";
		airplane2.length = "85m";
		
		airplane2.takeoff();
		airplane2.landing();
		airplane2.info();
		
		System.out.println();
		
		Bicycle myBicycle1 = new Bicycle();
		myBicycle1.info();
		
		System.out.println();
		
		Bicycle myBicycle2 = new Bicycle("red", 100000);
		myBicycle2.info();
		
		
	}
	
}
