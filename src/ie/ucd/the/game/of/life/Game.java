package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  private ArrayList<Player> players;
  private Board board;

  public Game(ArrayList<Player> players) {
    this.board = new Board();
    this.players = players;
    setInitPosition();
  }
                                                                                        
  public void setInitPosition() {
    // set every player in the root node
    Node root = this.board.getPath().getRoot();
    for(int i = 0; i < this.players.size(); i++) {
      this.players.get(i).setPosition(root);
    }
  }
  
  public void movePlayer(int steps, Player player) {
    for(int x = 0; x < steps; x++)  {
      toNextBlock(player);
      blockLogic(player);
    }
  }
 

 
}