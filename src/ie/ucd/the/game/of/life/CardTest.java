package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void testBlockTypeMustBeValid() {
		assertThrows(InvalidParameterException.class, ()->{
			@SuppressWarnings("unused")
			Card card = new Card("this should fail", "hello");
		});
	}
}
