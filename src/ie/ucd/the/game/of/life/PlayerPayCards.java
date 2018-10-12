package ie.ucd.the.game.of.life;

public class PlayerPayCards extends ActionCards {
	
	private int trackCardsRemain;
	
	public PlayerPayCards() {
		setTrackCardsRemain(10);
		System.out.print("You have to change your career now!");
		System.out.println("Pick 2 cards from the top of the deck and choose 1");
	}
	
	public void isDrawn() {
		setTrackCardsRemain(getTrackCardsRemain() - 1);
	}
	
	public void doAction() {
		//TODO Implement functionality to initialize the maoney transfer from player to player
	}
	
	public void cardType() {	// If we want to confirm the type of the current card set then it is returned as a print
		System.out.println("Player Pay Action Card");
	}
	
	public int getTrackCardsRemain() {
		return trackCardsRemain;
	}

	public void setTrackCardsRemain(int trackCardsRemain) {
		this.trackCardsRemain = trackCardsRemain;
	}
	
}
