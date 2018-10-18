package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Node {
    // class variable
    public static int id = 0;
    
    private Block data;
    private ArrayList<Node> nodes;
    // instance variable
    private int ins_id;
    public Node(Block data, ArrayList<Node> nodes) {
        this.data = data;
        this.nodes = nodes;
        // instance variable
        this.ins_id = id;
        // class variable
        id = id + 1;
    }
    
    // Getters
    public Block getData() {
        return this.data;
    }

    public ArrayList<Node> getNodes() {
        return this.nodes;                
    }

    public int getId() {
        return this.ins_id;
    }
    
    // Setters
    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public void setData(Block data) {
        this.data = data;
    }
}


/*
n5 = new Node("finish', null, null);
n4 = new Node('normal', n5, null);
n3 = new Node('action', n5, null);
n2 = new Node('normal', n3, n4);
n1 = new Node('normal', n2, null);
*/
/*

NODE:

    _________
    |       |
    |  data |
    |_______|
    |       |
    | first |------> Node
    |_______|
    |       |
    |second |------> Node
    |_______|
    
*/