package ie.ucd.the.game.of.life;

public class Player {
	// Attributes/Properties
	private static int number = 0;
	private int pNum;
	private Node position;
	private int money;
	private int loan;
	private String career;
	private boolean degree;
	private boolean turn;
	
	public Player() {
		number += 1;
		setpNum(number);
	}
	
	// Setters/Getters for all attributes
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
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
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
