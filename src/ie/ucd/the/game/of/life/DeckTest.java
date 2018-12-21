package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testDeckCreationAndShuffle() {
		Deck deck = new Deck("college_career");
		String currentOrder = deck.deckToString();
		deck.shuffle();
		assertFalse(deck.deckToString().equals(currentOrder));
	}
	
	@Test
	void test() {
        Deck deck = new Deck("action");
        Deck actionCardsBefore = deck;
        deck.getDeck().remove(0);
        assertFalse(deck.deckToString().equals(actionCardsBefore.toString()));
	}

}
