package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Pawn {
	
	// The pawn is the car which will belong to a player and move accross the board
	// 4 defeault colors at start that update when they are selected
	public static ArrayList<String> pawns = new ArrayList<String>() {{
		add("pink");
		add("blue");
		add("green");
		add("yellow");
	}};
	private String carColor;	// General Pawn properties
	private String gender;
	private int children;
	private boolean spouse;
	
	public Pawn() {
		// when creating a pawn, nothing special happens
		this.spouse = false;
		this.children = 0;
		this.carColor = "";
	}

	public void chosenPawn(String carColor) {	// Choosing a pawn and update elements in static list
		if (pawns.contains(carColor)) {		// if the string exists, set carcolor and remove from list
			setCarColor(carColor);
			pawns.remove(carColor);
		}
		else {				// To add repeat option here perhaps but that depends on GUI or not
			System.out.print("The pawn does not exist, choose another color from the list: ");
			printAvailablePawns();
		}
	}

	public void printAvailablePawns() {
		System.out.println(pawns);
	}
	
	// Getters/Setters
	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String color) {
		this.carColor = color;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {		// Two possibilities only
		this.gender = (gender == "male") ? gender : "female";
	}

	public int getChildren() {
		return children;
	}
	
	public void setChildren(int children) {
		this.children = children;
	}
	
	public boolean isSpouse() {
		return spouse;
	}
	
	public void setSpouse(boolean spouse) {
		this.spouse = spouse;
	}

}
