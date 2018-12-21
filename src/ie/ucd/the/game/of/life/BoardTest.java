package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testCreateDefaultBoard() {
		Board board = new Board();
		Tree path = board.getPath();
		assertTrue(path.getRoot().getChildren().size() > 0);
	}

}
