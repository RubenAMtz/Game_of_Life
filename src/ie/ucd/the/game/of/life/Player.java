package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Player {
	// Attributes/Properties
	private static int number = 0;
	private int pNum;
	private Node position;
	private int money;
	private int loan;
	private String career;
	private boolean degree;
	private int turn;
	private Pawn pawn;
	private boolean status; //marital
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int houses;
	private int salary;
	private boolean retired;
	
	public Player() {
		number += 1;
		setpNum(number);
		this.retired = false;		
	}

	public String cardsToString() {
		String cards = "";
		for(Card card : this.cards) {
			cards = cards + " || " + card.getName();
		}
		cards += " ||";
		return cards;
  }

	public boolean isRetired(){
		return getRetired();
	}

	public boolean getRetired(){
		return this.retired;
	}

	public void setRetired(boolean value){
		this.retired = value;
	}
	
	// Setters/Getters for all attributes
	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int value) {
		this.salary = value;
	}

	public int getHouses(){
		return this.houses;
	}

	public void setHouses(int houses){
		this.houses = houses;
	}

	public ArrayList<Card> getCards(){
		return this.cards;
	}

	public void setCards(Card card){
		this.cards.add(card);
	}

	public void addCard(Card card){
		this.setCards(card);
	}
	
	public Node getPosition() {
		return position;
	}

	public void setPosition(Node position) {
		this.position = position;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addMoney(int money){
		this.money = this.money + money;
	}

	public boolean getStatus(){
		return this.status;
	}

	public void setStatus(boolean status){
		this.status = status;
	}
	
	public int getLoan() {
		return loan;
	}

	public void setLoan(int loan) {
		this.loan = loan;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public boolean isDegree() {
		return degree;
	}

	public void setDegree(boolean degree) {
		this.degree = degree;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getNumber() {
		return number;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public Pawn getPawn() {
		return this.pawn;
	}

	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}

	public void paysMoneyTo(Player player, int amount) {
		this.setMoney(this.getMoney() - amount);
		player.setMoney(player.getMoney() + amount);	
	}

	// Methods Declaration, can possibly be extended for lower classes
	// public abstract void choosePawn(String pawn);
	// public abstract void choosePath(int cOrCc);
	// public abstract void chooseCareer(boolean pickOne);
	// public abstract void spin();
	// public abstract void drawCard();		// include draw action, career, house or any like such
	// public abstract void payMoney();		// to bank or player
	// public abstract void receiveMoney();	// from bank or player
	// public abstract void changePosition();	// for spinner, then turn update
	// public abstract void chooseSpinToWin();	// return number chosen
	// public abstract int getLoans();
}
