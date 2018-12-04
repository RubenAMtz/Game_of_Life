package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Collections;
import javax.lang.model.util.ElementScanner6;

public class Game {
	private ArrayList<Player> players;
	private Spinner spinner;
	private Input input;
	private static int chosenPath = 0;
	Node position;
	Node nextNode;
	private boolean retirement;

	private Deck action_deck;
	private	Deck house_deck;
	private Deck career_deck;
	private Deck college_career_deck;

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

	public Game() {						
		players = new ArrayList<Player>();
		pawns = new Pawn();
		this.spinner = new Spinner();
		input = new Input();
		StartGame();
		this.players = getPlayers();
		beginGameMessages();
		initiateMovement();
	}

	public void beginGameMessages() {
		message("\n**************************************** Let's Play ******************************************");
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

				if (!currentPlayer.isRetired()) {
					this.playerTurn(currentPlayer, spinner);
				}
				printPlayerProperties(currentPlayer);
				//message("Retirement: %s", this.retirement);
				//printDecks();
				if (!repeatPlayerTurn) {
					turn = turn + 1;
				}
			}
		}		
		announceWinner();
		announcePlacements();
	}


	public void announceWinner() {
		message("Congratulations Player" + this.winner.getpNum() + ". You're the Winner!");
	}

	public void announcePlacements() {
		for(int i = 0; i < placements.size(); i++) {
			message((i+1) + ".- Player" + this.placements.get(i).getpNum() + " Money: " + this.placements.get(i).getMoney());
		}
	}

	public void printPlayersPosition() {
		for(int i = 0; i < this.getNumPlayers(); i++){
			message("Positions: ");
			message(this.players.get(i).getPosition().getId());
			message(this.players.get(i).getPosition().getData());
		}
	}

	public void printPlayerProperties(Player currentPlayer) {
		message("-------------------------------PLAYER %d ATTRIBUTES-------------------------------", currentPlayer.getpNum());
		message("Position: " + currentPlayer.getPosition().getData());
		message("Block ID: " + currentPlayer.getPosition().getId());
		message("Cards: " + currentPlayer.cardsToString());
		message("Career: " + currentPlayer.getCareer());
		message("Salary: " + currentPlayer.getSalary());
		message("Account: %d", currentPlayer.getMoney());
		message("Loans: %d", currentPlayer.getLoan());
		message("Status: " + (currentPlayer.getPawn().isSpouse() ? "Married" : "Single"));
		message("Houses: %d", currentPlayer.getHouses());
		message("Kids: %d", currentPlayer.getPawn().getChildren());
		message("Retired players: %d", this.retiredPlayers);
		message("---------------------------------------------------------------------------------");
	}

	public void printDecks(){
		message("-------------------------------DECKS-------------------------------");
		message("Action Deck:" + action_deck.deckToString());
		message(" ");
		message("House Deck:" + house_deck.deckToString());
		message(" ");
		message("Career Deck:" + career_deck.deckToString());
		message(" ");
		message("College Career Deck:" + college_career_deck.deckToString());
		message(" ");
		message("-------------------------------------------------------------------");
	}
	
	public void execute(Player player, int totalSteps) {
		Node currentPosition = player.getPosition();
		String blockType = currentPosition.getBlock().getType();
		int cardIndex;
		ArrayList<Card> playerCards;
		int playerKids;
		chosenPath = 0;
		int poolPrice;
		//split nodes share the stop property, so they are tested at stop:
		if (currentPosition.getBlock().getStop()) {
			if (blockType.equals("start")){
				// all split cases here
				message("Which path would you like to take: Press (0) for Career path or Press (1) for College career path");
				this.input.inputNumber();
				chosenPath = this.input.getNumber();
				//player takes college career path:
				if (this.input.getNumber() == 1){
					//player.setMoney(player.getMoney()-100000);
					player.addMoney(-100000);
				}
				else if (this.input.getNumber() == 0){
					message("Card1: %s (salary: $%d)", career_deck.getDeck().get(0).getName(), career_deck.getDeck().get(0).getSalary());
					message("Card2: %s (salary: $%d)", career_deck.getDeck().get(1).getName(), career_deck.getDeck().get(1).getSalary());
					message("Select Card1 (1) or Card2 (2):");
					this.input.inputNumber();
					//assign card to player
					cardIndex = this.input.getNumber()-1;
					player.addCard(career_deck.getDeck().get(cardIndex));
					//assign name to player's career:
					player.setCareer(career_deck.getDeck().get(cardIndex).getName());
					player.setSalary(career_deck.getDeck().get(cardIndex).getSalary());
					//remove cards from deck, set left card at the bottom of the deck:
					if (this.input.getNumber()==1){
						//check if the card is place at the bottom of the deck?
						career_deck.getDeck().add(career_deck.getDeck().get(1));
						//index minus 1 to match correct order:
						career_deck.getDeck().remove(0);
						career_deck.getDeck().remove(0);
					}
					else{
						//in case the other card was selected
						career_deck.getDeck().add(career_deck.getDeck().get(0));
						career_deck.getDeck().remove(0);
						career_deck.getDeck().remove(0);
						
					}	
				}
				else {
					message("Error...");
				}
			}
			if (blockType.equals("splitns")){
				/*The player can decide to keep his/her job or change career. If the player decides to change career, s/he should give the bank 100K, take the top college career card on the deck and place the current career/college career card at the bottom of the deck. In any of these cases the player will have to move his/her car pawn again using the spinner.*/
				// System.out.println("Which path would you like to take: Press (0) for Same path or Press (1) for Night School path");
				message("Which path would you like to take: Press (0) for Same path or Press (1) for Night School path");
				this.input.inputNumber();
				chosenPath = this.input.getNumber();
				//stop moving and spin again
				stopFlag = true;
				repeatPlayerTurn = true;
				
				//if the player selects nights school
				if (this.input.getNumber() == 1) {
					//player.setMoney(player.getMoney() - 100000);
					player.addMoney(-100000);
					//remove card from players deck, and set it at bottom of the deck
					playerCards = player.getCards();
					for(int i = 0; i < playerCards.size(); i++){
						if (playerCards.get(i).getType().equals("career")){
							career_deck.getDeck().add(playerCards.get(i));
							playerCards.remove(i);
							message("A Career card has been placed at the bottom of the deck");
						}
						else if (playerCards.get(i).getType().equals("college_career")){
							college_career_deck.getDeck().add(playerCards.get(i));
							playerCards.remove(i);
							message("A College Career card has been placed at the bottom of the deck");
						}
					}
					//take top card from deck
					message("Card picked is: %s", college_career_deck.getDeck().get(0).getName());
					//assign card to player
					player.addCard(college_career_deck.getDeck().get(0));
					//assign name to player's career:
					player.setCareer(college_career_deck.getDeck().get(0).getName());
					player.setSalary(college_career_deck.getDeck().get(0).getSalary());
				}
			}
					
			if (blockType.equals("splitfam")){
				message("Which path would you like to take: Press (0) for Family path or Press (1) for No Family path");
				this.input.inputNumber();
				chosenPath = this.input.getNumber();
			}
					/*The player should decide whether to move towards the family path (i.e. having kids) or towards the life path (i.e. not having kids). */
				
			if (blockType.equals("graduationstop")){
				/*The current player should take the top 2 College Career cards from the deck. S/he should choose his/her favorite card
				and keep it because that will represent his/her job. The other card should be placed at the bottom of the deck.*/
				// System.out.println("You have stopped at Graduation Stop");
				message("You have stopped at Graduation Stop");
				message("Card1: %s (salary: $%d)", college_career_deck.getDeck().get(0).getName(), college_career_deck.getDeck().get(0).getSalary());
				message("Card2: %s (salary: $%d)", college_career_deck.getDeck().get(1).getName(), college_career_deck.getDeck().get(1).getSalary());
				message("Select Card1 (1) or Card2 (2):");
				this.input.inputNumber();
				//assign card to player
				cardIndex = this.input.getNumber()-1;
				player.addCard(college_career_deck.getDeck().get(cardIndex));
				//assign name to player's career:
				player.setCareer(college_career_deck.getDeck().get(cardIndex).getName());
				player.setSalary(college_career_deck.getDeck().get(cardIndex).getSalary());
				//remove card from deck, set left card at the bottom of the deck:
				if (this.input.getNumber()==1){
					//check if the card is place at the bottom of the deck?
					college_career_deck.getDeck().add(college_career_deck.getDeck().get(1));
					//index minus 1 to match correct order:
					college_career_deck.getDeck().remove(0);
					college_career_deck.getDeck().remove(0);
				}
				else{
					//in case the other card was selected
					college_career_deck.getDeck().add(college_career_deck.getDeck().get(0));
					college_career_deck.getDeck().remove(0);
					college_career_deck.getDeck().remove(0);
				}	
			}
			if (blockType.equals("marriagestop")){
				message("You have stopped and are getting married");
				player.getPawn().setSpouse(true);
				ArrayList<Player> players = this.players;
				for(int index = 0; index < this.getNumPlayers(); index++){
					if (players.get(index).getpNum() != player.getpNum()){
						this.spinner.spin();
						message("Player%d spins: %d", players.get(index).getpNum(), this.spinner.getValue());
						if (this.spinner.getValue() % 2 != 0){
							players.get(index).paysMoneyTo(player, 100000);
							message("Player%d pays 100000 to Player%d",players.get(index).getpNum(), player.getpNum());
						}
						else{
							players.get(index).paysMoneyTo(player, 50000);
							message("Player%d pays 50000 to Player%d",players.get(index).getpNum(), player.getpNum());
						}
					}
				}
				//stop moving and spin again
				stopFlag = true;
				repeatPlayerTurn = true;
			}
					/*The status of the car pawn should be updated to indicate that the player has a spouse. Each of the other players should spin 
					the spinner. If the spinner ends up on an odd number, the player spinning the spinner has to give the married player 100K, 50K 
					otherwise. Finally the married player should spin the spinner to move again.*/
			if (blockType.equals("babystop")){
				message("You have stopped to see how many babies you had");
				message("Press enter to Spin:");
				this.input.inputString();
				this.spinner.spin();
				message("Player%d spins: %d", player.getpNum(), this.spinner.getValue());
				if (this.spinner.getValue() < 4) {
					player.getPawn().setChildren(player.getPawn().getChildren() + 0);
				}
				else if (this.spinner.getValue() > 3 && this.spinner.getValue() < 7) {
					player.getPawn().setChildren(player.getPawn().getChildren() + 1);
				}
				else if (this.spinner.getValue() > 6 && this.spinner.getValue() < 9){
					player.getPawn().setChildren(player.getPawn().getChildren() + 2);
				}
				else {
					player.getPawn().setChildren(player.getPawn().getChildren() + 3);
				}
			}
					/*The player should spin the spinner to see how many babies s/he had. 1-3 on the spinner corresponds to zero kids. 4-6 on the spinner corresponds to 1 kid. 7-8 on the spinner corresponds to 2 kids. 9-10 on the spinner corresponds to 3 kids. */
			if (blockType.equals("holidaystop")){
				message("You have stopped for holidays, enjoy");
			}
					/*the current player should do nothing.*/
			if (blockType.equals("retirement")){
					Card house_to_sell;
					message("You have reached retirement, time to enjoy life");
					//test variable:
					player.setRetired(true);
					this.retiredPlayers = 0;
					for (int i = 0; i < this.getNumPlayers(); i++){
						if (this.players.get(i).isRetired()){
							this.retiredPlayers++;
						}
					}
					stopFlag = true;
					poolPrice = 500000 - this.retiredPlayers * 100000;
					//player.setMoney(player.getMoney() + poolPrice);
					player.addMoney(poolPrice);
					//player.setMoney(player.getLoan() * 60000);
					player.addMoney(player.getLoan() * -60000);
					//all players are retired:
					message("Retired players: %d", this.retiredPlayers);
					message("Num of players: %d", this.getNumPlayers());
					if (this.retiredPlayers == this.getNumPlayers()){
						this.retirement = true;
						for (int i = 0; i < this.getNumPlayers(); i++){
							playerCards = this.players.get(i).getCards();
							playerKids = this.players.get(i).getPawn().getChildren();
							this.players.get(i).addMoney(playerKids * 50000);
							for(int j = 0; j < playerCards.size(); j++){
								if (playerCards.get(j).getType().equals("action")){
									this.players.get(i).addMoney(100000);
								}
								//houses to sell
								if (playerCards.get(j).getType().equals("house")){
									house_to_sell = playerCards.get(j);
									//player.getCards().remove(j);
									message("Press enter to Spin to determine the selling price");
									this.input.inputString();
									spinner.spin();
									if (spinner.getValue() % 2 != 0){
										message("House will be sold for: %d", house_to_sell.getSpinRedPrice());
										player.addMoney(house_to_sell.getSpinRedPrice());
									}
									else{
										message("House will be sold for: %d", house_to_sell.getSpinBlackPrice());
										player.addMoney(house_to_sell.getSpinBlackPrice());
									}
								}
							}
						}
						// list of
						ArrayList<Integer> playersMoney = new ArrayList<Integer>();
						//ArrayList<Player> placements = new ArrayList<Player>();
						for (Player p : this.players) {
							playersMoney.add(p.getMoney());							
						}
						// sorts in ascending order
						Collections.sort(playersMoney, Collections.reverseOrder());
						// for(int i = 0; i < playersMoney.size(); i++) {
						// 	message(i + ".- Money: " + playersMoney.get(i));
						// }

						// iterate over players money (sorted)						
						for (int playerMoney : playersMoney) {
							// iterate over players
							for (Player p : this.players) {
								// find money of every player and place the player in placements in order
								if (playerMoney == p.getMoney()) {
									this.placements.add(p);
								}
							}
						}

						this.winner = this.placements.get(0);

						// for(int i = 0; i < placements.size(); i++) {
						// 	message(i + ".- Player" + this.placements.get(i).getpNum() + " Money: " + this.placements.get(i).getMoney());
						// }
					}
					
				}
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
			Card action_card;
			String card_name;
			Deck chosenDeck;

			if ((totalSteps-1) == playerSteps){
				action_card = action_deck.getDeck().get(0);
				card_name = action_deck.getDeck().get(0).getName();
				player.addCard(action_card);
				action_deck.getDeck().remove(0);
				message("Your action card is: " + card_name);
				
				if (card_name.equals("career_change")){
					message("You have selected a career change card");
					message("Do want College or Career deck? Press (0) for College Career deck or Press (1) for Career deck");
					this.input.inputNumber();
					if (this.input.getNumber()==0){
						chosenDeck = college_career_deck;
					}
					else{	
						chosenDeck = career_deck;
					}
					message("Card1: %s (salary: $%d)", chosenDeck.getDeck().get(0).getName(), chosenDeck.getDeck().get(0).getSalary());
					message("Card2: %s (salary: $%d)", chosenDeck.getDeck().get(1).getName(),chosenDeck.getDeck().get(1).getSalary());
					message("Select Card1 (1) or Card2 (2):");
					this.input.inputNumber();
					//remove current card from player and place it in the deck it belongs to
					playerCards = player.getCards();
					for(int i = 0; i < playerCards.size(); i++){
						if (playerCards.get(i).getType().equals("career")){
							career_deck.getDeck().add(playerCards.get(i));
							playerCards.remove(i);
							message("A Career card has been placed at the bottom of the deck");
						}
						else if (playerCards.get(i).getType().equals("college_career")){
							college_career_deck.getDeck().add(playerCards.get(i));
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
				if (card_name.equals("players_pay")){
					message("You have selected a Players Pay card");
					message("Please select one of the players to get money from: ");
					for (int i = 0; i < this.getNumPlayers(); i++){
						if (player.getpNum() != this.players.get(i).getpNum()){
							message("For Player%d, press %d ", this.players.get(i).getpNum(), this.players.get(i).getpNum());	
						}
					}
					//check that player selected is different than current player:
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
				if (card_name.equals("pay_the_bank")){
					int amount;
					amount = action_card.getAmount();
					message("You had %d", player.getMoney());
					message("You now pay the bank: %d", amount);
					player.addMoney(-amount);
					message("You now have %d", player.getMoney());
				}
				if (card_name.equals("bank_pays_you")){
					int amount;
					amount = action_card.getAmount();
					message("You had %d", player.getMoney());
					message("You get paid by the bank: %d", amount);
					player.addMoney(amount);
					message("You now have %d", player.getMoney());
				}			
			}
		}
		if (currentPosition.getBlock().getDrawHouseCard()) {
			Card house_to_sell;
			if ((totalSteps-1) == playerSteps){
				message("You are at a House block! Buy or sell a house?, (0) to buy (1) to sell");
				this.input.inputNumber();
				//player takes college career path:
				if (this.input.getNumber() == 1 && player.getHouses() == 0){
					message("Sorry, you don't have any houses");
					this.input.setNumber(0);
					message("Try buying a house first:");
				}

				if (this.input.getNumber() == 1 && player.getHouses() > 0){
					//TODO
					// check if player has any house cards
				
					
					message("Select a house to sell from your deck: ");
					for (int i = 0; i < player.getCards().size(); i++){
						message("(%d) for Card: %s", i+1, player.getCards().get(i).getName());
					}
					this.input.inputNumber();
					while(player.getCards().get(this.input.getNumber()-1).getType() != "house"){
						message("Please select a house card");
						this.input.inputNumber();
					}
					house_to_sell = player.getCards().get(this.input.getNumber()-1);
					player.getCards().remove(this.input.getNumber()-1);
					message("Press enter to Spin to determine the selling price");
					this.input.inputString();
					spinner.spin();
					if (spinner.getValue() % 2 != 0){
						message("House will be sold for: %d", house_to_sell.getSpinRedPrice());
						player.addMoney(house_to_sell.getSpinRedPrice());
					}
					else{
						message("House will be sold for: %d", house_to_sell.getSpinBlackPrice());
						player.addMoney(house_to_sell.getSpinBlackPrice());
					}
					house_deck.getDeck().add(house_to_sell);
					player.setHouses(player.getHouses()-1);
					
				}
				else if  (this.input.getNumber() == 0){
					message("Card1: %s (for $%d)", house_deck.getDeck().get(0).getName(), house_deck.getDeck().get(0).getPurchase());
					message("Card2: %s (for $%d)", house_deck.getDeck().get(1).getName(), house_deck.getDeck().get(1).getPurchase());
					message("Select Card1 (1) or Card2 (2):");
					this.input.inputNumber();
					cardIndex = this.input.getNumber()-1;
					if (player.getMoney() >= house_deck.getDeck().get(cardIndex).getPurchase()){
						player.addMoney(-house_deck.getDeck().get(cardIndex).getPurchase());
						player.addCard(house_deck.getDeck().get(cardIndex));
						player.setHouses(player.getHouses()+1);
						//remove card from deck, set left card at the bottom of the deck:
						if (this.input.getNumber()==1){
							//check if the card is place at the bottom of the deck?
							house_deck.getDeck().add(house_deck.getDeck().get(1));
							house_deck.getDeck().remove(0);
							house_deck.getDeck().remove(0);
						}
						else{
							//in case the other card was selected
							house_deck.getDeck().add(house_deck.getDeck().get(0));
							house_deck.getDeck().remove(0);
							house_deck.getDeck().remove(0);
						}	
					}
					else{
						message("Sorry, you don't have enough money. House costs %d and you only have %d",house_deck.getDeck().get(cardIndex).getPurchase(), player.getMoney());
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

		if (chosenPath != 0){
			this.nextPosition.set(player.getpNum()-1, nextPosition(currentPosition, chosenPath));
		}
		
		else if (!player.isRetired()){
			this.nextPosition.set(player.getpNum()-1, nextPosition(currentPosition));
		}
		
		// if (currentPosition.getBlock().getDrawCollegeCareerCard()) {}	
		// if (currentPosition.getBlock().getPaysBank()) {}
		// if (currentPosition.getBlock().getUpdatePawn()) {}
		// if (currentPosition.getBlock().getMarriage()) {}
		// if (currentPosition.getBlock().getPlayerSpin()) {}
		// if (currentPosition.getBlock().getRetirement()) {}

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
		message("------------------------------PLAYER IS MOVING------------------------------");
		for(this.playerSteps = 0; (this.playerSteps < totalSteps) && !stopFlag ; this.playerSteps++)  {
			if (player.getPosition().getBlock().getType().equals("start")) {
				message("                                                       Player steps: %s", player.getPosition().getData());
				message("                                                                -");
			}
			nextBlock(player, totalSteps);
			message("                                                       Player steps: %s", player.getPosition().getData());
			message("                                                                -");
		}
		message("--------------------------------PLAYER STOPS--------------------------------");
		message("Press ENTER to go to the next turn");
		this.input.inputString();
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
		message("You rolled %d, now moving %d blocks ", spinner.getValue(), spinner.getValue());
		
		this.moveForward(spinner.getValue(), currentPlayer);
	}

	public static void message(Object text, Object ... args) {
		String convertedToString = String.valueOf(text);
		System.out.printf(convertedToString + "\n", args);
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
		this.board = new Board();		// create board
		this.path = board.getPath();
		this.action_deck = new Deck("action");
		this.house_deck = new Deck("house");
		this.career_deck = new Deck("career");
		this.college_career_deck = new Deck("college_career");

		message("Enter Player Count (2-4 Players): ");
		this.input.inputNumber();

		while(input.getNumber() < 2 || input.getNumber() > 4) {
			message("Invalid Player Count! Please Enter Player Count Between 2-4");
			this.input.inputNumber();
		}
	}

	public void createPlayers() {
		while(this.players.size() < this.input.getNumber()) {
			this.players.add(new Player());
			nextPosition.add(this.path.getRoot());
		}
	}

	public void setPlayersProperties() {		// All players - input to set there properties
		for(int i = 0; i < this.players.size(); i++) {
			this.players.get(i).setPosition(this.path.getRoot());	// Node root = this.path.getRoot();
			this.players.get(i).setMoney(200000);
			this.players.get(i).setLoan(0);
			this.players.get(i).setStatus(false);
			message("Player%d: Choose a pawn color: ", i + 1);
			pawns.printAvailablePawns();
			this.players.get(i).setPawn(choosePawn());
			message("Player%d: Press enter to spin and determine your turn order: ", i + 1);
			this.players.get(i).setTurn(setPlayersTurn());
	    }	
	}

	public Pawn choosePawn() {
		Pawn pawn = new Pawn();
		// ask for color
		this.input.inputString();
		pawn.chosenPawn(this.input.getString());
		message("Choose a gender (male or female): ");
		this.input.inputString();
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
	
	public void sortPlayers() {
		Collections.sort(this.players, new Sort());
	}

	public Tree getPath(){
		return this.path;
	}
}