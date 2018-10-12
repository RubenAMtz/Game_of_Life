package ie.ucd.the.game.of.life;

import java.util.Random;

public class Spinner {
	private Random rand = new Random();
	private int spin;
	private String color;
	
	public Spinner() {	//Constructor
		Spin();
	}
	
	public int getSpin() {	//Return attribute
		return spin;
	}
	
	public void Spin() {	// Manually call a spin whenever a turn is completed
		spin = rand.nextInt(10) + 1;
		color = ((spin % 2 == 1) ? "red" : "black");
		/*if (spin % 2 == 1) {
			color = "red";
		}
		else {
			color = "black";
		}*/
	}
	
	public String getColor() {
		return color;
	}
	
	public static void main(String[] args) {		// TEST Case
		Spinner test = new Spinner();
		
		System.out.println(test.getSpin());
		System.out.println(test.getColor());
		test.Spin();
		System.out.println(test.getSpin());
		System.out.println(test.getColor());
	}
}
