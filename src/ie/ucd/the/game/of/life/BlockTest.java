package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class BlockTest {

	@Test
	void testBlockTypeMustBeValid() {
		assertThrows(InvalidParameterException.class, ()->{
			@SuppressWarnings("unused")
			Block block = new Block("this should fail");
		});
	}
	
	@Test
	void testBlockIsProperlyConstructed() {
		Block startBlock = new Block("start");
		Block actionBlock = new Block("action");
		assertTrue(startBlock.getStop() == true && actionBlock.getStop() == false, "Start Block and Action Block are properly constructed");
	}
}
