package ie.ucd.the.game.of.life;

import java.util.Random;

public class Spinner {
	private Random rand = new Random();
	private int spin;
	private String color;
	
	public Spinner() {	//Constructor
		spin();
	}
	
	public void spin() {	// Manually call a spin whenever a turn is completed
		this.spin = rand.nextInt(10) + 1;
		color = ((spin % 2 == 1) ? "red" : "black");
	}
	
	public int getValue() {	//Return attribute
		return this.spin;
	}
	
	public String getColor() {
		return color;
	}
}