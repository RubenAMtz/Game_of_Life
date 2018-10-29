package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Scanner;

public class Block {
	
	private String type;
	
	public Block(String type) {
		this.type = type;
	}
	
	public Block constructBlock(String type) {
		if (type == "splitns") {
			System.out.printf("Do you want to go for night school? (y/n)\n");
		}
		else if (type == "splitfam") {
			
		}
		else if (type == "stop") {
			System.out.println("\nHit a STOP block\n");
		}
		else if (type == "payday") {
			System.out.println("\nHit a PAYDAY block\n");
		}
		else if (type == "action") {
			
		}
		else if (type == "holiday") {
			
		}
		else if (type == "spin2win") {
			
		}
		else if (type == "baby_g") {
			
		}
		else if (type == "baby_b") {
			
		}
		else if (type == "baby_2") {
			
		}
		else if (type == "house") {
			
		}
		else {
			System.out.println("Not possible");
		}
		return null;
	}

	public void nextBlock(Player player) {
		// get position of player and make it move one node further
		Node position = player.getPosition(); //default starting position for the first case
		Node nextNode = position.getFirst(); 
		if (position.getSecond() != null) {	// if alternative path exist, give player choice
            //check for type of block <---------------------------
            //I think we should check for the type of block first? and then ask for the input?
            //this is so we can print whatever message
            blockLogic(player);//
            // System.out.printf("Go through secondary?: (y/n)\n");
			// setKeyboard(input.next());
			// if (getKeyboard() == "n" || getKeyboard() == "N"){
			// 	nextNode = position.getFirst(); //this line might be unnecessary since it is already defined										
			// }
			// else if (getKeyboard() == "y" || getKeyboard() == "Y") {
			// 	nextNode = position.getSecond();
			// }
			// input.close();
		}
		player.setPosition(nextNode);
    }

	public Block getBlockType() {
		return blockType;
	}

	public void setBlockType(Block blockType) {
		this.blockType = blockType;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	//checks the type of block and takes action based on that (feeds nextBlock)
	/*public void blockLogic(Player player) {
		String blockType = player.getPosition().getData();
		//setBlockType(player.getPosition().getData());	// "action", "payday", etc...
		if (blockType == "splitns") {
			System.out.printf("Do you want to go for night school? (y/n)\n");
			
		}
		else if (blockType == "splitfam") {
			
		}
		else if (blockType() == "stop") {
			System.out.println("\nHit a STOP block\n");
		}
		else if (blockType == "payday") {
			System.out.println("\nHit a PAYDAY block\n");
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
	}*/
}
