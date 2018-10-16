package ie.ucd.the.game.of.life;

import java.util.*;

public class Player {
	// Attributes/Properties
	private Node position;
	private int money;
	private int children;
	private boolean spouse;
	private int loan;
	private String color;
	private String career;
	private boolean degree;
	private boolean turn;
	
	// Setters/Getters for all attributes
	public Node getPosition() {
		return position;
	}
	public void setPosition(Node position) {
		this.position = position;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public boolean isSpouse() {
		return spouse;
	}
	public void setSpouse(boolean spouse) {
		this.spouse = spouse;
	}
	public int getLoan() {
		return loan;
	}
	public void setLoan(int loan) {
		this.loan = loan;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
