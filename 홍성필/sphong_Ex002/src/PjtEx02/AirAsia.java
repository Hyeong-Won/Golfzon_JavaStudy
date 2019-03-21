package PjtEx02;

public class AirAsia {

	public String color;
	public String weight;
	public String length;
	
	public AirAsia() {
		System.out.println("AirAsia constructor");
	}
	
	public void takeoff() {
		System.out.println("--- takeoff ---");
	}
	
	public void landing() {
		System.out.println("--- landing ---");
	}
	
	public void info() {
		System.out.println("--- info ---");
		System.out.println("color : " + color);
		System.out.println("weight : " + weight);
		System.out.println("length : " + length);
	}
	
}
