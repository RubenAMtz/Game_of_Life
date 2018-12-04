package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Tree {
    private Node root;      //first node (root)
    private ArrayList<Node> tracker = new ArrayList<Node>(); // first can be root, others tracker
    private Node splitNode; // it's a node reference
    private boolean splitFlag;
    private boolean joinFlag;
    // + added
    private Node foundNode = null;
    private ArrayList<ArrayList<Node>> levels = new ArrayList<ArrayList<Node>>();
    // private ArrayList<Node> level = new ArrayList<Node>();
    // Constructor
    public Tree(String data) {	// TODO change to Block from String type
        this.root = new Node(data);
        this.tracker.add(this.root);

        this.joinFlag = false; // split settings/variables:
        this.splitFlag = false;
        this.splitNode = null;
    }
    
    public void setTracker(int size) {
    	while(this.tracker.size() < size) {
    		this.tracker.add(null);
    	}
    }
    
    public void addNode(String data, int branch) {
        // create new node with no children
        Node newNode = new Node(data);
        ArrayList<Node> level = new ArrayList<Node>();

        if (branch > 0 && this.splitFlag == false) {
            //throw java.lang.Exception("You have specified a different branch without splitting the branch first! :O");
        }

        if (this.joinFlag) {
        	for(int i = 0; i < this.tracker.size(); i++) {
        		this.tracker.get(i).setNodes(0, newNode);

        		if(i == 0) {
        			this.tracker.set(i, newNode);
        		}
        		else {
        			this.tracker.set(i, null);
        		}
        	}
            
            this.joinFlag = false;
            this.splitNode = null;
        }
        else if (branch > 0 && this.splitFlag) {
            if (this.splitNode.getNodes(branch) == null) {
            	this.splitNode.setNodes(branch, newNode);
            	// tracks last node in secondary path
            	this.tracker.set(branch, newNode);
            }
            else {
            	// adds node to secondary path
            	this.tracker.get(branch).setNodes(0, newNode);
            	// tracks last node in secondary path
            	this.tracker.set(branch, newNode);
            }
        }
        else if (branch == 0) {
            this.tracker.get(branch).setNodes(branch, newNode);
            this.tracker.set(branch, newNode);
        }
        // append to level the nodes in this.tracker
        for(Node node : this.tracker) {
            level.add(node);
        }
        
        this.levels.add(level);
    }

    public void split_path(int paths) {
        //saves the reference from previous node
        if (this.splitFlag == false) {
            this.splitFlag = true;
            this.splitNode = this.tracker.get(0);
            setTracker(paths);
            this.splitNode.addToList(paths);
        }
    }

    public void join_path() {
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

    public Node findId(Node node, int id) {
        Node found = null;
        return findId(node, id, found);
    }
    private Node findId(Node node, int id, Node found) {
        // if (found != null) {
        //     return found;
        // }

        if (node != null) {
            
                if (node.getId() == id) {
                    System.out.println("Found it!");
                    // this.foundNode = node;
                    if (found == null) {
                        System.out.println("null");
                    }
                    else {
                        System.out.println("Im here: " + found.getId());
                    }
                    found = node;
                    return found;
                }
                for(Node child : node.getChildren()) {
                    findId(child, id, found);
                }
            
        }
        return found;
    }
    
    public Node getFoundNode() {
        return this.foundNode;
    }

    public void printTree() {
        ArrayList<Integer> nodeIds = new ArrayList<Integer>();
        // ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Node> level : this.levels) {
            for(Node node : level) {
                if (node != null) {
                    // if ID of node IS NOT in nodeIds
                    if (nodeIds.contains(node.getId()) == false) {
                        // add ID of node to nodeIds
                        nodeIds.add(node.getId());
                        // store list of children nodes
                        ArrayList<Node> children = node.getChildren();
                        //
                    }
                    
                    
                }
            }
            //System.out.println("");
        }
    }

    public void print(Node node) {
        if (node != null) {
            // Recursive calls
            try {
        	print(node.getNodes(0));
            }
            catch(Exception IndexOutOfBoundsException) {
            	
            }
            try {
            print(node.getNodes(1));
            }
            catch(Exception IndexOutOfBoundsException) {
            	
            }
            try {
            	print(node.getNodes(2));
            }
            catch(Exception IndexOutOfBoundsException) {
            	
            }
            // Print data
            System.out.printf("Type:\n"); 
            System.out.print(node.getData());
            System.out.printf(", Id: "); 
            System.out.print(node.getId());
            if (node.getNodes(0) != null) {
                System.out.printf("\nFirst:\n"); 
                System.out.print( node.getNodes(0).getId() );
            }
            try {
	            if (node.getNodes(1) != null) {
	                System.out.printf("\nSecond:\n"); 
	                System.out.print( node.getNodes(1).getId() );
	            }
            }
            catch(Exception IndexOutOfBoundsException) {
            	
            }
            try {
            	if(node.getNodes(2) != null)  {
            		System.out.printf("\nThird:\n"); 
                    System.out.print( node.getNodes(2).getId() );
            	}
            }
            catch(Exception IndexOutOfBoundsException) {
            	
            }
            
            System.out.printf("\n\n------------\n\n");
        }
    }
}
