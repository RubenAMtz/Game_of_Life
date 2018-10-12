package ie.ucd.the.game.of.life;

public class GetCashFromTheBank extends ActionCards {
	private int trackCardsRemain;
	
	public GetCashFromTheBank() {
		setTrackCardsRemain(20);
		System.out.print("You have to change your career now!");
		System.out.println("Pick 2 cards from the top of the deck and choose 1");
	}
	
	public void isDrawn() {
		setTrackCardsRemain(getTrackCardsRemain() - 1);
	}
	
	public void doAction() {
		//TODO Implement functionality to initialize Bank to Player account money transfer
	}
	
	public void cardType() {	// If we want to confirm the type of the current card set then it is returned as a print
		System.out.println("Get Cash From The Bank Action Card");
	}
	
	public int getTrackCardsRemain() {
		return trackCardsRemain;
	}

	public void setTrackCardsRemain(int trackCardsRemain) {
		this.trackCardsRemain = trackCardsRemain;
	}
}
