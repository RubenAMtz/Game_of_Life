package ie.ucd.the.game.of.life;

public class ActionCards extends Cards {
	
	private int trackNum;
	
	public ActionCards() {		// Constructor default set to initial value of 55 cards that exist
		setTrackNum(55);
	}
	
	public void doAction() {
		// Subclasses will override functionality of this so to be referred to those
	}
	
	public void cardType() {	// If we want to confirm the type of the current card set then it is returned as a print
		System.out.println("Action Card");
	}
	
	public void isDrawn(boolean check) {	// decrement remaining action cards that are called
		if (check == true)
			setTrackNum(getTrackNum() - 1);
	}

	public int getTrackNum() {
		return trackNum;
	}

	public void setTrackNum(int trackNum) {
		this.trackNum = trackNum;
	}
	
}
