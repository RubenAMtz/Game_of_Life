package ie.ucd.the.game.of.life;

public class Pawn extends Player {
	
	private String color;
	private String gender;
	private int children;
	private boolean spouse;
	
	public Pawn(String colorChoice, String genderChoice) {
		this.color = colorChoice;
		this.gender = genderChoice;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
