package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Node {

    public static int cls_id = 0;
    
    private Block block;
    private ArrayList<Node> nodes = new ArrayList<Node>();;
    private String type;
    private int id;

    public Node(String type) {
        this.block = new Block(type);
        this.type = type;
        this.id = cls_id;
        cls_id = cls_id + 1;
    }
    
    public void addToList(int index) {
    	while(this.nodes.size() <= index)  {
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
        if (index >= this.nodes.size()-1){
            this.addToList(index);
        }
        this.nodes.set(index, nodes);
    }

    public void setBlock(String type) {
        this.block = new Block(type);
    }
}
/*




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