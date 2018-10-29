package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Node {

    public static int cls_id = 0;
    
    private Block block;
    private ArrayList<Node> nodes;
    private int id;

    //changes to node structure (at the bottom), we changed the variable names as well
    public Node(String type, ArrayList<Node> nodes) {
        this.block = new Block(type);
        this.nodes = nodes;
        this.id = cls_id;
        cls_id = cls_id + 1;
    }
    
    // Getters
    public Block getBlock() {
        return this.block;
    }

    public ArrayList<Node> getNodes() {
        return this.nodes;                
    }

    public int getId() {
        return this.id;
    }
    
    // Setters
    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public void setBlock(String type) {
        this.block = new Block(type);
    }
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