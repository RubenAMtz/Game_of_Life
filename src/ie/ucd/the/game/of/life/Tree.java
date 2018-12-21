package ie.ucd.the.game.of.life;

import java.security.InvalidParameterException;

import java.util.ArrayList;

public class Tree {
    private Node root;      //first node (root)
    private ArrayList<Node> tracker = new ArrayList<Node>(); // first can be root, others tracker
    private Node splitNode; // it's a node reference
    private boolean splitFlag;
    private boolean joinFlag;

    // private ArrayList<Node> level = new ArrayList<Node>();
    // Constructor
    public Tree(String data) {
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
            throw new InvalidParameterException("You have specified a different branch without splitting the branch first!");
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

}
