package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	private Tree path;
	//private String keyboard;
	//private String blockType;
	//private ArrayList<Player> players;
	//Scanner input = new Scanner(System.in);

	public Board() { // ArrayList<Player> players
		this.path = createDefaultBoard();
		/*this.players = players;
		setInitPosition();*/
			
	}	
	/*
	public void setInitPosition() {
		// set every player in the root node
		Node root = this.path.getRoot();
		for(int i = 0; i < this.players.size(); i++) {
			this.players.get(i).setPosition(root);
		}
	}
	//Game class
	public void moveForward(int steps, Player player) {
		for(int x = 0; x < steps; x++)  {
			nextBlock(player);		
			blockLogic(player);
		}
	}
	//
	//checks the type of block and takes action based on that (feeds nextBlock)
	public void blockLogic(Player player) {
		// String blockType = player.getPosition().getData();
		setBlockType(player.getPosition().getData());	// "action", "payday", etc...
		if (getBlockType() == "splitns") {
			System.out.printf("Do you want to go for night school? (y/n)\n");
			
		}
		else if (getBlockType() == "splitfam") {
			
		}
		else if (getBlockType() == "stop") {
			System.out.println("\nHit a STOP block\n");
			System.out.println(player.getPosition().getId());
		}
		else if (getBlockType() == "payday") {
			System.out.println("\nHit a PAYDAY block\n");
			System.out.println(player.getPosition().getId());
		}
		else if (getBlockType() == "action") {
			
		}
		else if (getBlockType() == "holiday") {
			
		}
		else if (getBlockType() == "spin2win") {
			
		}
		else if (getBlockType() == "baby_g") {
			
		}
		else if (getBlockType() == "baby_b") {
			
		}
		else if (getBlockType() == "baby_2") {
			
		}
		else if (getBlockType() == "house") {
			
		}
		else {
			System.out.println("Not possible");
		}
	}
	
	public void nextBlock(Player player) {
		// get position of player and make it move one node further
		Node position = player.getPosition(); //default starting position for the first case
		Node nextNode = position.getFirst();
		if (position.getSecond() != null) {	// if alternative path exist, give player choice
			//check for type of block
			//might be commented and ask the question on the "blocktype identification wrapper":
			System.out.printf("Choose a path: (y/n)\n");
			setKeyboard(input.next());
			if (getKeyboard() == "n" || getKeyboard() == "N"){
				nextNode = position.getFirst();												
			}
			else if (getKeyboard() == "y" || getKeyboard() == "Y") {
				nextNode = position.getSecond();
			}
			input.close();
		}
		player.setPosition(nextNode);
	}
	*/
	public Tree createDefaultBoard() {	
		// Pay-day
		// action
		// holiday
		// spin2win
		// baby (number of babies varies)
		// house
		// stop:
			// Graduation stop
			// Get married stop
			// Night school stop
			// Family stop
			// baby stop
			// holiday stop
		
		Tree t = new Tree("start");
		t.split_path();
		t.addNode("action", "main"); //2 tracker, accmain += 1
		t.addNode("payday", "main"); //3 tracker, accmain += 1
		t.addNode("action", "main"); //4 tracker, accmain += 1
		t.addNode("action", "main"); //5 tracker, accmain += 1
		t.addNode("action", "secondary"); //6 tracker, accsecondary += accmain + 1
		t.addNode("action", "secondary"); //7 tracker, accsecondary += accmain + 1
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("stop", 	"secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.join_path();                   //if there is a join_path flag
		t.addNode("action",		"main"); // 8 tracker, accmain = accsecondary;
		t.addNode("payday", 	"main");
		t.addNode("holiday", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("payday", 	"main");
		t.addNode("action",		"main");
		t.addNode("stop",		"main");
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("holiday",	"main");
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("payday",		"main");
		t.addNode("action",		"main");
		t.addNode("spin2win",	"main");
		t.addNode("action",		"main");
		t.addNode("house",		"main");
		t.addNode("action",		"main");
		t.addNode("splitns",		"main");
		t.split_path();
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("holiday",	"main");
		t.addNode("action",		"main");
		t.addNode("payday",		"main");
		t.addNode("action",		"main");
		t.addNode("action", "secondary");
		 t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("payday", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		 t.join_path();
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("house",		"main");
		t.addNode("action",		"main");
		t.addNode("payday",		"main");
		t.addNode("baby_2",		"main");//********** 
		t.addNode("action",		"main");
		t.addNode("spin2win",	"main");
		t.addNode("holiday",	"main");
		t.addNode("action",		"main");
		t.addNode("house",		"main");
		t.addNode("payday",		"main");
		t.addNode("splitfam",		"main");
		t.split_path();
		t.addNode("action",		"main");
		t.addNode("baby_2",		"main");//*****
		t.addNode("house",		"main");
		t.addNode("baby_g",		"main");
		t.addNode("baby_2",		"main");
		t.addNode("holiday",	"main");
		t.addNode("baby_g",		"main");
		t.addNode("baby_b",		"main"); //we need to specify if it is baby boy or girl 
		t.addNode("action",		"main");
		t.addNode("stop",		"main");
		t.addNode("action", 	"secondary");
		t.addNode("holiday", 	"secondary");
		t.addNode("action", 	"secondary");
		t.addNode("action", 	"secondary");
		t.addNode("action", 	"secondary");
		t.addNode("payday", 	"secondary");
		t.addNode("action", 	"secondary");
		t.join_path();
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("baby_g", 	"main");
		t.addNode("action", 	"main");
		t.addNode("house", 		"main");
		t.addNode("payday", 	"main");
		t.addNode("baby_b", 	"main");
		t.addNode("stop", 		"main");
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("house", 		"main");
		t.addNode("action", 	"main");
		t.addNode("payday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("stop", 		"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("holiday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("payday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("house", 		"main");
		t.addNode("payday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("retirement", "main");
		
		return t;
	}

	public Tree getPath(){
		return this.path;
	}

	/*public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public String getBlockType() {
		return blockType;
	}

	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}*/
}
