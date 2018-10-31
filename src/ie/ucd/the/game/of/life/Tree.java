package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Tree {
    private Node root;      //first node (root)
    //private Node mainLastNode;  //tracker, 
    //private Node secondaryLastNode; //tracker,
    private ArrayList<Node> nodes = new ArrayList<Node>(); // first can be root, others tracker
    private Node splitNode; // it's a node reference
    private boolean splitFlag; // flag
    private boolean joinFlag;  // flag
    
    //we haven't changed the tree class, however, it will change dramatically since we need to implement the new arraylist<Node>
    //the logic below won't work as it won't be scalable, thinking that we theoretically could have an infinite number of branches:

    // Constructor
    public Tree(String data) {	// change to Block from String type
        this.root = new Node(data, null);
        //this.root = new Node(data.getType(), null);
        // tracking:
        // mainLastNode is used to track last node in main path
      //  this.mainLastNode = this.root;
        // SecondaryLastNode is used to track last node in secondary path
      //  this.secondaryLastNode = null;
        this.nodes.add(this.root);
        //this.nodes.set(0, this.root);	// Creates two nodes within the tree and sets main and secondary
        this.nodes.add(null);
        //this.nodes.add(null);		// splitNode - TEST

        // split settings/variables:
        this.joinFlag = false;
        this.splitFlag = false;
        this.splitNode = null;
    }
    // Thinking of replacing the "main/secondary" logic with integers to add as many branches as required
    // until the join path is called. . .
    // Also main/secondary nodes to its own ArrayList in trees
    public void addNode(String data, int branch) {
        // create new node with no children
        Node newNode = new Node(data, null);
        //Node newNode = new Node(data.getType(), null);
        
        if (branch > 0 && this.splitFlag == false) {
            // ideally this should throw an error?
            System.out.printf("\n\nNode will be added to first path (secondary is off): ");
            System.out.print(newNode);
            System.out.printf("\n\n");
        }

        if (this.joinFlag) {
            	// adds reference of new node to both of the last tracked nodes (main and secondary paths)
           // this.mainLastNode.setFirst(newNode);
           // this.secondaryLastNode.setFirst(newNode);
            this.nodes.get(0).setNodes(0, newNode);
            this.nodes.get(1).setNodes(1, newNode);
            
           // this.mainLastNode = newNode;
            this.nodes.set(0, newNode);
            	// reset variables to default state
           // this.secondaryLastNode = null;
            this.nodes.set(1, null);
            
            this.joinFlag = false;
            this.splitNode = null;
        }            
        else if (branch > 0 && this.splitFlag){
            // if the node where it splits, has no new second node
            /*if (this.splitNode.getSecond() == null) {
                this.splitNode.setSecond(newNode);
                // tracks last node in secondary path
                this.secondaryLastNode = newNode;
            }
            else {
                // adds node to secondary path
                this.secondaryLastNode.setFirst(newNode);
                // tracks last node in secondary path
                this.secondaryLastNode = newNode;           
            }*/
            if (this.splitNode.getNodes(1) == null) {
            	this.splitNode.setNodes(1, newNode);
            	// tracks last node in secondary path
            	this.nodes.set(1, newNode);
            }
            else {
            	// adds node to secondary path
            	this.nodes.get(1).setNodes(0, newNode);
            	// tracks last node in secondary path
            	this.nodes.set(1, newNode);
            }
        }
        else if (branch == 0) {            
         //   this.mainLastNode.setFirst(newNode);
         //   this.mainLastNode = newNode;
            this.nodes.get(0).setNodes(0, newNode);
            this.nodes.set(0, newNode);
        }
        
    }

    public void split_path(){
        //sets a flag
        //saves the reference from previous node
        if (this.splitFlag == false) {
            this.splitFlag = true;
           // this.splitNode = this.mainLastNode;
            this.splitNode = this.nodes.get(0);
        }
        
    }

    public void join_path(){
      //resets the flag set by split_path
      //connects the branches together
        if (this.splitFlag == true) {
            this.splitFlag = false;
            this.joinFlag = true;
        }      
    }
    
    public Node getRoot() {
        return this.root;
    }
    
    // new tree
    // add node
    // split path
    // add node first
    // add node first
    // add node secondary
    // join path
    // add node first

/*
                        1.- ONLY can split once.
                        create tree
                        O
                       / \              -> addnode("action", first)
                      O                 -> split_path()  %flag set
                     / \                -> addNode("normal", first)
                    O   O               -> addNode("normal", secondary)
                   /\  /\                -> join_path()   %flag unset
                  O                 -> addNode("normal", first) %the last two has to reference

*/
    public void print(Node node) {
        if (node != null) {
            // recursive calls
            print(nodes.get(0));
            print(nodes.get(1));
            
            // print data.
            System.out.printf("Type:\n"); 
            System.out.print(node.getTest());
            System.out.printf(", Id: "); 
            System.out.print(node.getId());
            if (node.getNodes(0) != null) {
                System.out.printf("\nFirst:\n"); 
                System.out.print( node.getNodes(0).getId() );
            }
            if (node.getNodes(1) != null) {
                System.out.printf("\nSecond:\n"); 
                System.out.print( node.getNodes(1).getId() );
            }
            
            System.out.printf("\n\n------------\n\n");
        }
    }
    
    /*public void print(Node node) {
        if (node != null) {
            // recursive calls
            print(node.getFirst());
            print(node.getSecond());
            
            // print data.
            System.out.printf("Type:\n"); 
            System.out.print(node.getData());
            System.out.printf(", Id: "); 
            System.out.print(node.getId());
            if (node.getFirst() != null){
                System.out.printf("\nFirst:\n"); 
                System.out.print( node.getFirst().getId() );
            }
            if (node.getSecond() != null) {
                System.out.printf("\nSecond:\n"); 
                System.out.print( node.getSecond().getId() );
            }
            
            System.out.printf("\n\n------------\n\n");
        }
    }*/
}
