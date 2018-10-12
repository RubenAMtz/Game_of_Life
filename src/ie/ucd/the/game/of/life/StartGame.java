package ie.ucd.the.game.of.life;

import java.util.Scanner;

public class StartGame {
	
	private Scanner input = new Scanner(System.in);
	private int players;
	
	public int getPlayers() {
		return players;
	}
	
	public void setPlayers(int players) {
		this.players = players;
	}
	
	public StartGame() {
		players = 0;
	}
	
	public void initiate() {
		System.out.print("Enter Player Count (2-4 Players): ");
		int n = input.nextInt(); // Scans the next token of the input as an int.
		//once finished
		input.close();
		
		if (n < 2 || n > 4) {
			System.out.println("Invalid Player Count, Please Enter Player Count between 2-4");
		}
		
		setPlayers(n);
	}
	
	public static void main(String[] args) {		// TEST Case
		StartGame yes = new StartGame();
		
		System.out.println(yes.getPlayers());
		
		yes.initiate();
		
		System.out.println(yes.getPlayers());
		
	}
}
