package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
	private ArrayList<Player> players;
	private Spinner spinner;
	private Input input;
	private static int chosenPath = 0;
	Node position;
	Node nextNode;
	private boolean retirement;

	private Deck actionDeck;
	private	Deck houseDeck;
	private Deck careerDeck;
	private Deck collegeCareerDeck;

	private Pawn pawns;			// Pawn which belong to player and are updated in this class
	private Board board;		// default board
	private Tree path;			// tree of the default board
	private ArrayList<Node> nextPosition = new ArrayList<Node>();
	private boolean stopFlag = false;
	private boolean repeatPlayerTurn = false;
	private int retiredPlayers = 0;
	private int playerSteps = 0;
	private ArrayList<Player> placements = new ArrayList<Player>();
	private Player winner;
	public static int[] playerNumbers = {2, 3, 4};
	public static int[] pathSelection = {0, 1};
	public static int[] cardSelection = {1, 2};
	public static String[] genderSelection = {"male", "female"};
	public ArrayList<Integer> inputArray  = new ArrayList<Integer>();

	public Game() {
		this.input = new Input();
		StartGame();
		this.players = getPlayers();
		beginGameMessages();
		initiateMovement();
	}

	public void beginGameMessages() {
		message("\n**************************************** Let's Play ******************************************\n");
	}

	public void initiateMovement() {
		int turn = 0;
		Player currentPlayer;
		//testing for continuity
		while(!this.retirement){
			for(turn = 0; turn < this.getNumPlayers();) {
				//reset stop flag from moveForward():
				stopFlag = false;
				repeatPlayerTurn = false;
				currentPlayer = this.getPlayer(turn);
				// printBoardForPlayer(currentPlayer);

				if (!currentPlayer.isRetired()) {
					message("Press ENTER to go to the next turn");
					this.input.inputString();
					printArrPlayerProperties(this.players);
					this.playerTurn(currentPlayer, spinner);
				}
				if (!repeatPlayerTurn) {
					turn = turn + 1;
				}
			}
		}
		checkWinner();
		announceWinner();
		announcePlacements();
	}

	public void checkWinner() {
		// list of
        ArrayList<Integer> playersMoney = new ArrayList<Integer>();
        for (Player p : players) {
            playersMoney.add(p.getMoney());							
        }
        // sorts in ascending order
        Collections.sort(playersMoney, Collections.reverseOrder());

        // iterate over players money (sorted)						
        for (int playerMoney : playersMoney) {
            // iterate over players
            for (Player p : players) {
                // find money of every player and place the player in placements in order
                if (playerMoney == p.getMoney()) {
                    placements.add(p);
                }
            }
        }
        winner = placements.get(0);
	}

	public void announceWinner() {
		message("Congratulations Player" + this.winner.getpNum() + ". You're the Winner!");
	}

	public void announcePlacements() {
		for(int i = 0; i < placements.size(); i++) {
			message((i+1) + ".- Player" + this.placements.get(i).getpNum() + " Money: " + this.placements.get(i).getMoney());
		}
		message("Thanks for playing...Press Enter to quit");
		this.input.inputString();
		this.input.inputClose();
	}

	public void printPlayersPosition() {
		for(int i = 0; i < this.getNumPlayers(); i++) {
			message("Positions: ");
			message(this.players.get(i).getPosition().getId());
			message(this.players.get(i).getPosition().getData());
		}
	}

	public void printArrPlayerProperties(ArrayList<Player> currentPlayer) {
		for(int i = 0; i < currentPlayer.size(); i++) {
			message("-------------------------------PLAYER %d (%s) ATTRIBUTES-------------------------------", currentPlayer.get(i).getpNum(), currentPlayer.get(i).getPawn().getCarColor());
			message("Position: " + currentPlayer.get(i).getPosition().getData());
			message("Block ID: " + currentPlayer.get(i).getPosition().getId());
			message("Cards: " + currentPlayer.get(i).cardsToString());
			message("Career: " + currentPlayer.get(i).getCareer());
			message("Salary: " + currentPlayer.get(i).getSalary());
			message("Bonus Number: " + currentPlayer.get(i).getBonusNum());
			message("Account: %d", currentPlayer.get(i).getMoney());
			message("Loans: %d", currentPlayer.get(i).getLoan());
			message("Status: " + (currentPlayer.get(i).getPawn().isSpouse() ? "Married" : "Single"));
			message("Houses: %d", currentPlayer.get(i).getHouses());
			message("Kids: %d", currentPlayer.get(i).getPawn().getChildren());
			message("Retired players: %d", this.retiredPlayers);
			message("------------------------------------------------------------------------------------");
		}
	}

	public void printDecks() {
		message("-------------------------------DECKS-------------------------------");
		message("Action Deck:" + actionDeck.deckToString());
		message(" ");
		message("House Deck:" + houseDeck.deckToString());
		message(" ");
		message("Career Deck:" + careerDeck.deckToString());
		message(" ");
		message("College Career Deck:" + collegeCareerDeck.deckToString());
		message(" ");
		message("-------------------------------------------------------------------");
	}
	
	public void execute(Player player, int totalSteps) {
		Node currentPosition = player.getPosition();
		String blockType = currentPosition.getBlock().getType();
		int cardIndex;
		chosenPath = 0;
		ArrayList<Card> playerCards;
		//split nodes share the stop property, so they are tested at stop:
		if (currentPosition.getBlock().getStop()) {
			currentPosition.getBlock().getTestStop().action(player, careerDeck, collegeCareerDeck, houseDeck, this.players);
			chosenPath = currentPosition.getBlock().getTestStop().getChosenPath();
			this.stopFlag = currentPosition.getBlock().getTestStop().isStop();
			this.repeatPlayerTurn = currentPosition.getBlock().getTestStop().isRepeat();
			this.retirement = currentPosition.getBlock().getTestStop().isRetirement();
		}
		
		if (currentPosition.getBlock().getPay()) {
			playerCards = player.getCards();
			for (int i = 0; i < playerCards.size(); i++){
				if (player.getCards().get(i).getSalary() != -1){
					player.addMoney(player.getCards().get(i).getSalary());
					message("You got paid your salary: %d", player.getCards().get(i).getSalary());
				}
			}
			if ((totalSteps-1) == this.playerSteps){
				player.addMoney(100000);
				message("& a bonus of 100000");
			}
		}
		
		if (currentPosition.getBlock().getDrawActionCard()) {
			Card actionCard;
			String cardName;
			Deck chosenDeck;

			if ((totalSteps-1) == playerSteps){
				actionCard = actionDeck.getDeck().get(0);
				cardName = actionDeck.getDeck().get(0).getName();
				player.addCard(actionCard);
				actionDeck.getDeck().remove(0);
				message("Your action card is: " + cardName);
				
				if (cardName.equals("career_change")){
					message("You have selected a career change card");
					message("Do want College or Career deck?");
					this.input.strictInputNumber(pathSelection, "Press (0) for College Career deck or Press (1) for Career deck");
					if (this.input.getNumber()==0){
						chosenDeck = collegeCareerDeck;
					}
					else{	
						chosenDeck = careerDeck;
					}
					message("Card1: %s, SALARY %dK, Bonus Number %d", chosenDeck.getDeck().get(0).getName(), chosenDeck.getDeck().get(0).getSalary()/1000, chosenDeck.getDeck().get(0).getBonus());
					message("Card2: %s, SALARY %dK, Bonus Number %d", chosenDeck.getDeck().get(1).getName(), chosenDeck.getDeck().get(1).getSalary()/1000, chosenDeck.getDeck().get(1).getBonus());
					this.input.strictInputNumber(cardSelection, "Select Card1 (1) or Card2 (2):");
					//remove current card from player and place it in the deck it belongs to
					playerCards = player.getCards();
					for(int i = 0; i < playerCards.size(); i++){
						if (playerCards.get(i).getType().equals("career")){
							careerDeck.getDeck().add(playerCards.get(i));
							playerCards.remove(i);
							message("A Career card has been placed at the bottom of the deck");
						}
						else if (playerCards.get(i).getType().equals("college_career")){
							collegeCareerDeck.getDeck().add(playerCards.get(i));
							playerCards.remove(i);
							message("A College Career card has been placed at the bottom of the deck");
						}
					}
					//assign card to player
					cardIndex = this.input.getNumber()-1;
					player.addCard(chosenDeck.getDeck().get(cardIndex));
					//assign name to player's career:
					player.setCareer(chosenDeck.getDeck().get(cardIndex).getName());
					player.setSalary(chosenDeck.getDeck().get(cardIndex).getSalary());
					player.setBonusNum(chosenDeck.getDeck().get(cardIndex).getBonus());
					//remove card from deck, set left card at the bottom of the deck:
					if (this.input.getNumber()==1){
						chosenDeck.getDeck().add(chosenDeck.getDeck().get(1));
						chosenDeck.getDeck().remove(0);
						chosenDeck.getDeck().remove(0);
					}
					else{
						//in case the other card was selected
						chosenDeck.getDeck().add(chosenDeck.getDeck().get(0));
						chosenDeck.getDeck().remove(0);
						chosenDeck.getDeck().remove(0);
					}	
				}
				if (cardName.equals("players_pay")) {
					message("You have selected a Players Pay card");
					message("Please select a player to get money from: ");
					for (int i = 0; i < this.getNumPlayers(); i++){
						if (player.getpNum() != this.players.get(i).getpNum()){
							message("For Player%d ($%d), press %d ", this.players.get(i).getpNum(), this.players.get(i).getMoney(), this.players.get(i).getpNum());	
							inputArray.add(player.getpNum());
						}
					}
					//check that player selected is different than current player
					// this.input.strictIntInputNumber(inputArray, "Please select a player number");
					this.input.inputNumber();
					while(this.input.getNumber() == player.getpNum() || this.input.getNumber() > this.players.size()){
						message("Please enter a correct input");
						this.input.inputNumber();
					}
					for  (int i = 0; i < this.getNumPlayers(); i++){
						if (this.players.get(i).getpNum() == this.input.getNumber()){
							this.players.get(i).addMoney(-20000);
							player.addMoney(20000);
							message("Player%d payed you 20k", this.players.get(i).getpNum());	
						}
					}

				}
				if (cardName.equals("pay_the_bank")){
					int amount;
					amount = actionCard.getAmount();
					message("You had %d", player.getMoney());
					message("You now pay the bank: %d", amount);
					player.addMoney(-amount);
					message("You now have %d", player.getMoney());
				}
				if (cardName.equals("bank_pays_you")){
					int amount;
					amount = actionCard.getAmount();
					message("You had %d", player.getMoney());
					message("You get paid by the bank: %d", amount);
					player.addMoney(amount);
					message("You now have %d", player.getMoney());
				}			
			}
		}
		if (currentPosition.getBlock().getDrawHouseCard()) {
			int[] houseBlock = {0, 1, 2};
			if ((totalSteps-1) == playerSteps) {
				
				message("You are at a House block! Buy or sell a house?");
				this.input.strictInputNumber(houseBlock, "Press (0) to do nothing or (1) to buy or (2) to sell");
				//player takes college career path:
				if (this.input.getNumber() == 2 && player.getHouses() == 0) {
					message("Sorry, you don't have any houses. Try buying a house first:");
					this.input.strictInputNumber(pathSelection, "Press (0) to do nothing or (1) to buy");
				}

				if (this.input.getNumber() == 2 && player.getHouses() > 0) {	// Logic for selling a house
					player = sellHouseCard(player, 1, this.input, houseDeck, spinner);
				}
				else if  (this.input.getNumber() == 1) {
					message("You have $%d", player.getMoney());
					message("Card1: %s, Purchase Price %dK", houseDeck.getDeck().get(0).getName(), houseDeck.getDeck().get(0).getPurchase()/1000);
					message("Spin for Sale Price\nSpin Red (%d)\nSpin Black (%d)", houseDeck.getDeck().get(0).getSpinRedPrice(), houseDeck.getDeck().get(0).getSpinBlackPrice());
					message("Card2: %s, Purchase Price %dK", houseDeck.getDeck().get(1).getName(), houseDeck.getDeck().get(1).getPurchase()/1000);
					message("Spin for Sale Price\nSpin Red (%d)\nSpin Black (%d)", houseDeck.getDeck().get(1).getSpinRedPrice(), houseDeck.getDeck().get(1).getSpinBlackPrice());
					this.input.strictInputNumber(cardSelection, "Select Card1 (1) or Card2 (2):");
					cardIndex = this.input.getNumber()-1;
					if (player.getMoney() >= houseDeck.getDeck().get(cardIndex).getPurchase()){
						player.addMoney(-houseDeck.getDeck().get(cardIndex).getPurchase());
						player.addCard(houseDeck.getDeck().get(cardIndex));
						player.setHouses(player.getHouses()+1);
						//remove card from deck, set left card at the bottom of the deck:
						if (this.input.getNumber()==1){
							//check if the card is place at the bottom of the deck?
							houseDeck.getDeck().add(houseDeck.getDeck().get(1));
							houseDeck.getDeck().remove(0);
							houseDeck.getDeck().remove(0);
						}
						else{
							//in case the other card was selected
							houseDeck.getDeck().add(houseDeck.getDeck().get(0));
							houseDeck.getDeck().remove(0);
							houseDeck.getDeck().remove(0);
						}	
					}
					else{
						message("Sorry, you don't have enough money. House costs %d and you only have %d",houseDeck.getDeck().get(cardIndex).getPurchase(), player.getMoney());
					}	
				}
			}
		}
		if (currentPosition.getBlock().getBaby()) {
			if ((totalSteps-1) == playerSteps){
				if (blockType.equals("baby_2")){
					player.getPawn().setChildren(player.getPawn().getChildren()+2);
					message("You just had 2 children, congratulations!");
				}
				else if (blockType.equals("baby_g")){
					player.getPawn().setChildren(player.getPawn().getChildren()+1);
					message("You just had a baby girl, congratulations!");
				}
				//else if because babystop has this property and could be enter to the else case:
				else if (blockType.equals("baby_b")){
					player.getPawn().setChildren(player.getPawn().getChildren()+1);
					message("You just had a baby boy, congratulations!");
				}
			}
		}
		if (currentPosition.getBlock().getSpin2Win()) {
			ArrayList<Integer> selectedNumbers = new ArrayList<Integer>();
			ArrayList<Integer> playersNumber = new ArrayList<Integer>(this.players.size());
			ArrayList<Integer> availableNumbers = new ArrayList<Integer>() {{add(1); add(2); add(3); add(4); add(5); add(6); add(7); add(8); add(9); add(10);}};
			boolean breakFlag = false;

			if ((totalSteps-1) == playerSteps){
				message("You are now in a Spin2Win block, select 2 different numbers between 1-10:");
				this.input.inputNumber();
				selectedNumbers.add(this.input.getNumber());
				this.input.inputNumber();
				selectedNumbers.add(this.input.getNumber());
				//remove selected numbers from availablenumbers:
				for (int j = 0; j < selectedNumbers.size(); j++){
					for (int i = 0; i < availableNumbers.size(); i++){
						if (availableNumbers.get(i) == selectedNumbers.get(j)){
							availableNumbers.remove(i);
						}
					}
				}
				int counter = 0;
				//ask rest of players for numbers, make sure those numbers are available or else keep asking for it:
				for (int i = 0; i < this.players.size(); i++){
					if (player.getpNum() != this.players.get(i).getpNum()){
						message("Player%d, select a number between 1-10", this.players.get(i).getpNum());
						this.input.inputNumber();
						while(counter<1){
							for (int j = 0; j < availableNumbers.size(); j++){
								if (this.input.getNumber() == availableNumbers.get(j)){
									counter++;
								}									
							}
							if (counter == 0){
								message("Please enter a remaining number");
								this.input.inputNumber();
							}
						}
						playersNumber.add(this.input.getNumber());	
						counter = 0;										
					}
					else{
						//to keep order information a 0 is added where the current player is suppose to go:
						playersNumber.add(0);
					}
				}
				//keep spining until there is a winner:
				while(!breakFlag){
					message("Player%d, press ENTER to spin the spinner", player.getpNum());
					this.spinner.spin();
					this.input.inputString();
					message("The spinner gives: %d", this.spinner.getValue());
					//compare against currentplayer numbers
					for (int i = 0; i < selectedNumbers.size(); i++){
						if (this.spinner.getValue() == selectedNumbers.get(i)){
							player.addMoney(200000);
							message("You have earned 200k");
							breakFlag = true;
						}
					}
					//compare against playersnumber using all players array
					for (int i = 0; i < this.players.size(); i++){
						if (this.spinner.getValue() == playersNumber.get(i)){
							message("Player%d has earned 200k", this.players.get(i).getpNum());
							this.players.get(i).addMoney(200000);
							breakFlag = true;
						}
					}
				}
			}
		}

		if (chosenPath != 0) {
			this.nextPosition.set(player.getpNum()-1, nextPosition(currentPosition, chosenPath));
		}
		else if (!player.isRetired()) {
			this.nextPosition.set(player.getpNum()-1, nextPosition(currentPosition));
		}
	}
	
	public Node nextPosition(Node currentPosition, int path){
		return currentPosition.getNodes(path);
	}

	// overloading
	public Node nextPosition(Node currentPosition) {
		nextPosition(currentPosition, 0);
		return currentPosition.getNodes(0);
	}
  
	public void moveForward(int totalSteps, Player player) {
		//added stop flag to break out of nested loops
		message("----------------------------PLAYER %d (%s) IS MOVING---------------------------------", player.getpNum(), player.getPawn().getCarColor());
		for(this.playerSteps = 0; (this.playerSteps < totalSteps) && !stopFlag ; this.playerSteps++)  {
			if (player.getPosition().getBlock().getType().equals("start")) {
				message("                                                       Player steps: %s", player.getPosition().getData());
				message("                                                                -");
			}
			nextBlock(player, totalSteps);
			message("                                                       Player steps: %s", player.getPosition().getData());
			message("                                                                -");
		}
		// Bonus Number checks ... May need to be moved because can activate after career has been changed but that might be ok also
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).getBonusNum() == spinner.getValue()) {
				message("The bonus number on the card of Player%d matches the spinned number %d. They get 20K", i+1, spinner.getValue());
				this.players.get(i).addMoney(20000);
			}
		}
		message("-------------------------------PLAYER %d (%s) STOPS----------------------------------", player.getpNum(), player.getPawn().getCarColor());
	}
	
	public void nextBlock(Player player, int totalSteps) {
		//execute current block and find next block
		if (player.getPosition().getBlock().getType().equals("start")){
			execute(player, totalSteps);
		}
		player.setPosition(this.nextPosition.get(player.getpNum() - 1));
		execute(player, totalSteps);
	}

	public Player getPlayer(int index) {
		return this.players.get(index);
	}

	public int getNumPlayers() {
		return this.players.size();
	}

	public void playerTurn(Player currentPlayer, Spinner spinner){
		message("Player%d, press enter to spin: ", currentPlayer.getpNum());
		this.input.inputString();
		spinner.spin();
		message("You rolled %d (%s), now moving %d blocks ", spinner.getValue(), spinner.getColor(), spinner.getValue());
		
		this.moveForward(spinner.getValue(), currentPlayer);
	}

	public static void message(Object text, Object ... args) {
		String convertedToString = String.valueOf(text);
		System.out.printf(convertedToString + "\n", args);
	}

	public static Player sellHouseCard(Player player, int numberToSell, Input input, Deck houseDeck, Spinner spinner) {	// second parameter determines amount of houses to be sold
		Card houseToSell;
		if (!player.isRetired()) {
			message("Select a house to sell from your deck: ");
			for (int i = 0; i < player.getCards().size(); i++) {
				if (player.getCards().get(i).getType() == "house") {
					message("(%d) for Card: %s", i+1, player.getCards().get(i).getName());
				}
			}
			input.inputNumber();
			while(player.getCards().get(input.getNumber()-1).getType() != "house"){
				message("Please select a house card");
				input.inputNumber();
			}
			numberToSell = input.getNumber() - 1;
		}
		
		houseToSell = player.getCards().get(numberToSell);
		player.getCards().remove(numberToSell);
		message("Press enter to Spin to determine the selling price of your house");
		input.inputString();
		spinner.spin();
		if (spinner.getColor().equals("red")) {
			message("House (%s) will be sold for: %d", houseToSell.getName(), houseToSell.getSpinRedPrice());
			player.addMoney(houseToSell.getSpinRedPrice());
		}
		else {
			message("House (%s) will be sold for: %d", houseToSell.getName(), houseToSell.getSpinBlackPrice());
			player.addMoney(houseToSell.getSpinBlackPrice());
		}

		if (!player.isRetired()) {
			houseDeck.getDeck().add(houseToSell);
			player.setHouses(player.getHouses()-1);
		}
		return player;
	}


	//MIGRATED METHODS FROM STARTGAME

	public void StartGame() {
		bootup();
		initiate();
		createPlayers();
		setPlayersProperties();
		sortPlayers();
	}

	public void bootup() {
		message("The Game Of Life");
		message("Press enter to begin");
		this.input.inputString();
	}
	
	public void initiate() {
		this.players = new ArrayList<Player>();
		this.pawns = new Pawn();
		this.spinner = new Spinner();
		this.board = new Board();
		this.path = board.getPath();
		this.actionDeck = new Deck("action");
		this.houseDeck = new Deck("house");
		this.careerDeck = new Deck("career");
		this.collegeCareerDeck = new Deck("college_career");
	}

	public void createPlayers() {
		this.input.strictInputNumber(playerNumbers, "Enter Player Count (2-4 Players):");

		while(this.players.size() < this.input.getNumber()) {
			this.players.add(new Player());
			nextPosition.add(this.path.getRoot());
		}
	}

	public void setPlayersProperties() {		// All players - input to set there properties
		for(int i = 0; i < this.players.size(); i++) {
			this.players.get(i).setPosition(this.path.getRoot());	// Node root = this.path.getRoot();
			this.players.get(i).setMoney(200000);
			// this.players.get(i).setLoan(0);
			this.players.get(i).setStatus(false);
			message("Player%d: Choose a pawn color: ", i + 1);
			pawns.printAvailablePawns();
			this.players.get(i).setPawn(choosePawn());
	    }	
	}

	public void sortPlayers() {
		message("Each player will now spin the spinner. The turns for the players will be sorted accrording to the highest spins!");
		for(int i = 0; i < this.players.size(); i++) {
			message("Player%d: Press enter to spin and determine your turn order: ", i + 1);
			this.players.get(i).setTurn(setPlayersTurn());
		}
		Collections.sort(this.players, new Sort());

		message("Here is the turn order: ");
		for(int i = 0; i < this.players.size(); i++) {
			message("Turn %d: Player%d", i+1, this.players.get(i).getpNum());
		}
	}

	// Pawn properties for each player decided here
	public Pawn choosePawn() {
		Pawn pawn = new Pawn();
		// ask for color
		// this.input.inputString();		// change for easy enter
		this.input.strictArrInputString(pawn.pawns);	// Update list accordingly
		pawn.chosenPawn(this.input.getString());
		message("Choose a gender (male or female): ");
		// this.input.inputString();
		this.input.strictInputString(genderSelection);
		pawn.setGender(this.input.getString());
		return pawn;
	}

	public int setPlayersTurn() {
		this.input.inputString();
		this.spinner.spin();
		message("Your spin number is %d\n", this.spinner.getValue());
		return this.spinner.getValue();
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public Tree getPath(){
		return this.path;
	}
}