package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Collections;

import org.omg.IOP.CodeSets;

public class Cards {

	// private boolean shuffle;
	private ArrayList<Integer> deck = new ArrayList<Integer>();
	private int deckSize;
	private int codeSet;
	
	public Cards(ArrayList<Integer> cardDeck) {
		// this.shuffle = true;
		setDeckSize(cardDeck.size());
		setDeck(cardDeck);
	}	
	public ArrayList<Cards> shuffle() {
		Collections.shuffle(deck);
		return deck;
	}

	// Setters
	public void setDeckSize(int deckSize){
		this.deckSize = deckSize;
	}

	public void setDeck(ArrayList<Integer> cardDeck) {
		this.deck = cardDeck;
	}

	// Getters
	public int getDeckSize(){
		return this.deckSize;
	}

	public int getDeckSize(){
		return this.deckSize;
	}
	
	public int getDeckSize(){
		return this.deckSize;
	}
}
