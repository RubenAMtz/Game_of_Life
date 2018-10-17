package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private String keyboard;
    private ArrayList<Player> players;
    private String blockType;
    Scanner input = new Scanner(System.in);
    //private Board board;
    //private Deck deck; *1

    //TODO:
    //I consider that the cards have to be created by the game as well, since they are part of the game, whereas 
    //players are their own entity *1
    public Game(ArrayList<Player> players) {
        this.board = new Board();
        this.players = players;
        //this.cards = new Deck() *1
        setInitPosition();
    }
    
    public Board board() {
        return this.board.getBoard().getPath();
    }
                                                                                          
    public void setInitPosition() {
		// set every player in the root node
		Node root = this.board.getPath().getRoot();
		for(int i = 0; i < this.players.size(); i++) {
			this.players.get(i).setPosition(root);
		}
    }
    
    //-possible refactoring to movePlayer (could allow for moving backwards..)
    // we defined moveForward as movePlayer (moveFoward is not intuitive enough, as it does not refer to a player)
    public void movePlayer(int steps, Player player) {
		for(int x = 0; x < steps; x++)  {
			nextBlock(player);	
			blockLogic(player);
        }
    }
 
    public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}
 /*
	public String getBlockType() {
		return blockType;
	}

	public void setBlockType(String blockType) {
		this.blockType = blockType;
    }
   */ 
    public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}