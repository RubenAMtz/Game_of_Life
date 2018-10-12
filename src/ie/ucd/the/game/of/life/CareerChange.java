package ie.ucd.the.game.of.life;

public class CareerChange extends ActionCards {
	
	private int trackCardsRemain;
	
	public CareerChange() {
		setTrackCardsRemain(5);
		System.out.print("You have to change your career now!");
		System.out.println("Pick 2 cards from the top of the deck and choose 1");
	}
	
	public void isDrawn() {
		setTrackCardsRemain(getTrackCardsRemain() - 1);
	}
	
	public void doAction() {
		//TODO Implement functionality to initialize the career selection again
	}
	
	public void cardType() {	// If we want to confirm the type of the current card set then it is returned as a print
		System.out.println("Career Change Action Card");
	}
	
	public int getTrackCardsRemain() {
		return trackCardsRemain;
	}

	public void setTrackCardsRemain(int trackCardsRemain) {
		this.trackCardsRemain = trackCardsRemain;
	}
	
	
}
