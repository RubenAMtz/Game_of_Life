package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Block {
	

	n1.addNode("action", "main")); 
	//public Node(String data, Node first, Node second)
	public Node(blocktype...) {
		this.block = new Block("action");
		this.fisrt = ...
		this.second = ....
	}

	//The constructor of Block then:
	public Block(String type) {// Block type
		this.type = ConstructBlock("action"); //<----
	}
		
	public Block ConstructBlock(type) {
		if type == "action"
			this.prop = ...
			this.prop2 = ....
		else if type == ¿?
			this.prop = ...
			this.prop2 = ....
	}

	ajam, y ademas al crear el nodo, ya estarisa asignando las propiedades, si pq tendrias
	la referencia del bloque.

	y despues, puedes retrievear el block.type directamente
	Es que, cuando muevas al player un bloque adelante (nextBlock)
	nextBlock podria regresar el bloque, ajam.
	Y por ejemplo, el bloque podria tener una propiedad que se llame : shouldAsk = false/true
	o si el bloque tiene pay = true, pues haces algo diferente
	um?
	pues es que nodo tiene referencia de bloque, pero no al reves.
	Bloque no tiene re
	// obviamente no pondrias ese nombre culero, pondrias algo descriptivo como...	
	/*public static final ArrayList<String> BLOCK = new ArrayList<String>() {{
	    add("action");
	    add("payday");
	    add("house");
	    add("spin2win");
	    add("babyg");
	    add("babyb");
	    add("baby2");
	    add("holiday");
	    add("stop");
	    add("splitns");
	    add("splitfam");
	    add("house");
	}};*/
	
	public int blockType(ArrayList<String> block);
	public void action(Player player);
	

	public void nextBlock(Player player) {
		// get position of player and make it move one node further
		Node position = player.getPosition(); //default starting position for the first case
		Node nextNode = position.getFirst(); 
		if (position.getSecond() != null) {	// if alternative path exist, give player choice
            //check for type of block <---------------------------
            //I think we should check for the type of block first? and then ask for the input?
            //this is so we can print whatever message
            blockLogic(player);//
            System.out.printf("Go through secondary?: (y/n)\n");
			setKeyboard(input.next());
			if (getKeyboard() == "n" || getKeyboard() == "N"){
				nextNode = position.getFirst(); //this line might be unnecessary since it is already defined										
			}
			else if (getKeyboard() == "y" || getKeyboard() == "Y") {
				nextNode = position.getSecond();
			}
			input.close();
		}
		player.setPosition(nextNode);
    }

	//checks the type of block and takes action based on that (feeds nextBlock)
	public void blockLogic(Player player) {
		String blockType = player.getPosition().getData();
		//setBlockType(player.getPosition().getData());	// "action", "payday", etc...
		if (blockType == "splitns") {
			System.out.printf("Do you want to go for night school? (y/n)\n");
			
		}
		else if (blockType == "splitfam") {
			
		}
		else if (blockType() == "stop") {
			System.out.println("\nHit a STOP block\n");
			System.out.println(player.getPosition().getId());
		}
		else if (blockType == "payday") {
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





}
