package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {
	
	@Test
	void testNodeHasIncrementalId() {
		Node node = new Node("action");
		Node node2 = new Node("action");
		
		assertTrue(node.getId() < node2.getId(), "Second instance of node has id bigger than first instance");
	}

	@Test
	void testNodeCanHoldChildrenNodes() {
		Node parent = new Node("action");
		Node child1 = new Node("action");
		Node child2 = new Node("action");
		parent.setNodes(0, child1);
		parent.setNodes(1, child2);
		assertTrue(parent.getChildren().size() == 2);
	}
}
