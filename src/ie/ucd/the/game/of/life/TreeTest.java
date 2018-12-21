package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class TreeTest {

	@Test
	void testAddNode() {
		Tree tree = new Tree("start");
		tree.addNode("action", 0);
		
		String name = tree.getRoot().getChildren().get(0).getBlock().getType();
		assertTrue(name.equals("action"));
	}
	
	@Test
	void testCantAddNodeWhenNotSplitted() {
		assertThrows(InvalidParameterException.class, ()->{
			Tree tree = new Tree("start");
			tree.addNode("action", 0);
			tree.addNode("splitns", 0);
			tree.addNode("action", 0);
			tree.addNode("action", 1);
		});
	}

}
