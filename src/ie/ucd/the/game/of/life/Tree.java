package ie.ucd.the.game.of.life;

public class Tree {
    private Node root;      //first node (root)
    private Node mainLastNode;  //tracker, 
    private Node secondaryLastNode; //tracker,
    private Node splitNode; // it's a node reference
    private boolean splitFlag; // flag
    private boolean joinFlag;  // flag
    
    // Constructor
    public Tree(String data) {
        this.root = new Node(data, null, null);
        // tracking:
        // mainLastNode is used to track last node in main path
        this.mainLastNode = this.root;
        // SecondaryLastNode is used to track last node in secondary path
        this.secondaryLastNode = null;

        // split settings/variables:
        this.joinFlag = false;
        this.splitFlag = false;
        this.splitNode = null;
    }

    public void addNode(String data, String branch) {
        // create new node with no children
        Node newNode = new Node(data, null, null);
        
        if (branch == "secondary" && this.splitFlag == false) {
            // ideally this should throw an error?
            System.out.printf("\n\nNode will be added to first path (secondary is off): ");
            System.out.print(newNode);
            System.out.printf("\n\n");
        }

        if (this.joinFlag) {
            // adds refernce of new node to both of the last tracked nodes (main and secondary paths)
            this.mainLastNode.setFirst(newNode);
            this.secondaryLastNode.setFirst(newNode);
            this.mainLastNode = newNode;
            // reset variables to default state
            this.secondaryLastNode = null;
            this.joinFlag = false;
            this.splitNode = null;
        }            
        else if (branch == "secondary" && this.splitFlag){
            // if the node where it splits, has no new second node
            if (this.splitNode.getSecond() == null) {
                this.splitNode.setSecond(newNode);
                // tracks last node in secondary path
                this.secondaryLastNode = newNode;
            }
            else {
                // adds node to secondary path
                this.secondaryLastNode.setFirst(newNode);
                // tracks last node in secondary path
                this.secondaryLastNode = newNode;           
            }
        }
        else if (branch == "main"){            
            this.mainLastNode.setFirst(newNode);
            this.mainLastNode = newNode;
        }
    }

    public void split_path(){
        //sets a flag
        //saves the reference from previous node
        if (this.splitFlag == false) {
            this.splitFlag = true;
            this.splitNode = this.mainLastNode;
        }
        
    }

    public void join_path(){
      //unsets the flag set by split_path
      //connects the branches together
        if (this.splitFlag == true) {
            this.splitFlag = false;
            this.joinFlag = true;
        }      
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
    public Node getRoot() {
        return this.root;
    }

    public void print(Node node) {
        if (node != null){
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
    }

    public void printTree(Node node) {
        Node mainLast = node;
        Node secondaryLast = null;
        Node splitNode = null;
        boolean splitted = false;

        while (mainLast != null) {
            // print path
            if (secondaryLast == null) {
                System.out.printf("- ");
                System.out.print(mainLast.getId());
                System.out.printf("\n");
            }
            else if (secondaryLast != null){
                System.out.printf("-   ");
                System.out.print(mainLast.getId());
                System.out.printf(" --- ");
                System.out.print(secondaryLast.getId());
                System.out.printf("\n");
            }

            // identify split
            if (mainLast.getSecond() != null && splitted == false) {
                splitted = true;
                splitNode = mainLast;
            }
            
            if (splitted) {
                if (splitNode != null){
                    mainLast = splitNode.getFirst();
                    secondaryLast = splitNode.getSecond();
                    splitNode = null;
                }
                else {
                    mainLast = mainLast.getFirst();
                    secondaryLast = secondaryLast.getFirst();
                }
                // if both point to the same node, means that they joined path
                if (mainLast == secondaryLast){
                    secondaryLast = null;
                    splitted = false;
                }
            }
            else {
                mainLast = mainLast.getFirst();
            }
        }
    }
}
