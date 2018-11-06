package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Node {

    public static int cls_id = 0;
    
    private Block block;
    private ArrayList<Node> nodes = new ArrayList<Node>();
//    private ArrayList<Nodes> branches;
    private String type;
    private int id;

    //changes to node structure (at the bottom), we changed the variable names as well
    public Node(String type) {
        this.block = new Block(type);
        this.type = type;
        this.nodes.add(null);	// first
        this.nodes.add(null);	// second
        this.id = cls_id;
        cls_id = cls_id + 1;
    }
    
    public void addToList(int size) {
    	while(this.nodes.size() < size)  {
    		this.nodes.add(null);
    	}
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
    
    public String getData() {
		return type;
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