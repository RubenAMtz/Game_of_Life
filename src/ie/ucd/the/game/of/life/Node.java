package ie.ucd.the.game.of.life;

public class Node {
    // class variable
    public static int id = 0;

    private Block data;
    private Node first;
    private Node second;
    // instance variable
    private int ins_id;
    public Node(Block data, Node first, Node second){
        this.data = data;
        this.first = first;
        this.second = second;
        // instance variable
        this.ins_id = id;
        // class variable
        id = id + 1;
    }
        
    public Block getData(){
        return this.data;
    }

    public Node getFirst(){
        return this.first;                
    }
        
    public Node getSecond(){
        return this.second;
    }

    public int getId(){
        return this.ins_id;
    }

    public void setFirst(Node first){
        this.first = first;
    }

    public void setSecond(Node second){
        this.second = second;
    }

    public void setData(String data){
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