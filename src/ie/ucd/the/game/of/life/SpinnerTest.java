package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpinnerTest {

	@Test
	void testSpinnerSpinsInRange() {
		Spinner spinner = new Spinner();
		spinner.spin();
		assertTrue(spinner.getValue() >= 0 && spinner.getValue() <= 10);
	}

	@Test
	void testSpinnerColor() {
		Spinner spinner = new Spinner();
		spinner.spin();
		assertTrue(spinner.getColor().equals("red") || spinner.getColor().equals("black"));
	}
}
