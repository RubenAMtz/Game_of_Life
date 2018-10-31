package ie.ucd.the.game.of.life;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tree:
		// main and secondary for PATH (not for node branches).
		
		// Tree t = new Tree("begin");
		// t.addNode("A", "main");
		// t.split_path();
		// t.addNode("B", "main");
		// t.addNode("C", "main");
		// t.addNode("D", "secondary"); //it knows that it should go to the split point
		// t.addNode("E", "secondary");
		// t.join_path();
		// t.addNode("end", "secondary");

		// t.printTree(t.getRoot());

		// Board:
		/*Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);*/
		
		Board board = new Board();
		Tree tree = board.getPath();
		tree.print(board.getPath().getRoot());
		
		//Game lifeBoard = new Game(players);
		//Spinner spin = new Spinner();
		
		// Player moving through board commented as methods need adjusting
		/*// first turn
		System.out.printf("Player%d moves forward: %d\n", p1.getpNum(), spin.getSpin());
		lifeBoard.moveForward(spin.getSpin(), p1);
		System.out.print("Player position: ");
		System.out.print(p1.getPosition().getData());
		System.out.printf("\n\n");
		
		// second turn
		System.out.printf("Player%d moves forward: %d\n", p1.getpNum(), spin.getSpin());
		lifeBoard.moveForward(spin.getSpin(), p1);
		System.out.print("Player position: ");
		System.out.print(p1.getPosition().getData());
		System.out.printf("\n\n");
		
		// third turn
		System.out.printf("Player%d moves forward: %d\n", p1.getpNum(), spin.getSpin());
		lifeBoard.moveForward(spin.getSpin(), p1);
		System.out.print("Player position: ");
		System.out.print(p1.getPosition().getData());
		System.out.printf("\n\n");*/

		/*lifeBoard.nextBlock(players.get(0));
		System.out.printf("Player position: ");
		System.out.print(p1.getPosition().getData());
		System.out.printf("\n\n");
		//lifeBoard.nextBlock(players.get(0));
		System.out.printf("Player position: ");
		System.out.print(p1.getPosition().getData());
		System.out.printf("\n\n");
		//lifeBoard.nextBlock(players.get(0));
		System.out.printf("Player position: ");
		System.out.print(p1.getPosition().getData());
		System.out.printf("\n\n");*/
		//lifeBoard.getPath().print(lifeBoard.getPath().getRoot());
		//lifeBoard.getPath().printTree(lifeBoard.getPath().getRoot());
	}
}
