package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Node {

    public static int cls_id = 0;
    
    private Block block;
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private String test;
    private int id;

    //changes to node structure (at the bottom), we changed the variable names as well
    public Node(String type, ArrayList<Node> nodes) {
        this.block = new Block(type);
        this.test = type;
        this.nodes = nodes;
        this.id = cls_id;
        cls_id = cls_id + 1;
    }
    
    // Getters
    public Block getBlock() {
        return this.block;
    }

    public Node getNodes(int index) {
        return this.nodes.get(index);                
    }

    public int getId() {
        return this.id;
    }
    
    public String getTest() {
		return test;
	}
    
    // Setters
    public void setNodes(int index, Node nodes) {
        this.nodes.set(index, nodes);
    }

    public void setBlock(String type) {
        this.block = new Block(type);
    }
    // TODO Fix the null pointer error here for the arraylist of nodes
	/*public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}*/
}



/*
NODE:

    _________
    |       |
    | block | ---> block object
    |_______|
    |       |
    | nodes | ---> [list of children nodes]
    |_______|
    
*/