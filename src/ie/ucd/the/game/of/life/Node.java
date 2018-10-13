package ie.ucd.the.game.of.life;

public class Node {
    private String data;
    private Node first;
    private Node second;

    public Node(String data, Node first, Node second){
        this.data = data;
        this.first = first;
        this.second = second;
    }
        
    public String getData(){
        return this.data;
    }

    public Node getFirst(){
        return this.first;                
    }
        
    public Node getSecond(){
        return this.second;
    }

    public void setFirst(Node first){
        this.first = first;
    }

    public void setLeft(Node second){
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
    | left  |------> Node
    |_______|
    |       |
    | right |------> Node
    |_______|
    
*/