package ie.ucd.the.game.of.life;

import java.util.Vector;

public abstract class Board {
	//attributes of class board
	private int numBlocks;
	private int numPaths;
	private int numActionBlocks;
	private int numHouseBlocks;
	private int numBabies;
	private int numStoppingBlocks;
	private int numSpin2WinBlocks;
	private int numVacationBlocks;
	private String[] nameOfPaths;
	private Vector<Integer> lengthOfPaths;
	private boolean defaultBoard;
	
	public Board() {
		this.numActionBlocks = 100;
		this.numPaths = 2;
		this.numActionBlocks = numActionBlocks;		
	}

/* 							O
						  /   \
						 X     O
						  \   /
						 	O
							|
							O
							|
							X

							 */
	//Getters:
	
	public int getNumBlocks() {
		return numBlocks;
	}
	public int getNumPaths() {
		return numPaths;
	}
	public int getNumActionBlocks() {
		return numActionBlocks;
	}
	public int getNumHouseBlocks() {
		return numHouseBlocks;
	}
	public int getNumBabies() {
		return numBabies;
	}
	public int getNumStoppingBlocks() {
		return numStoppingBlocks;
	}
	public int getNumSpin2WinBlocks() {
		return numSpin2WinBlocks;
	}
	public int getNumVacationBlocks() {
		return numVacationBlocks;
	}
	public String[] getNameOfPaths() {
		return nameOfPaths;
	}
	public Vector<Integer> getLengthOfPaths() {
		return lengthOfPaths;
	}
	public boolean isDefaultBoard() {
		return defaultBoard;
	}
	
	//Setters:
	
	public void setNumBlocks(int numBlocks) {
		this.numBlocks = numBlocks;
	}
	public void setNumPaths(int numPaths) {
		this.numPaths = numPaths;
	}
	public void setNumActionBlocks(int numActionBlocks) {
		this.numActionBlocks = numActionBlocks;
	}
	public void setNumHouseBlocks(int numHouseBlocks) {
		this.numHouseBlocks = numHouseBlocks;
	}
	public void setNumBabies(int numBabies) {
		this.numBabies = numBabies;
	}
	public void setNumStoppingBlocks(int numStoppingBlocks) {
		this.numStoppingBlocks = numStoppingBlocks;
	}
	public void setNumSpin2WinBlocks(int numSpin2WinBlocks) {
		this.numSpin2WinBlocks = numSpin2WinBlocks;
	}
	public void setNumVacationBlocks(int numVacationBlocks) {
		this.numVacationBlocks = numVacationBlocks;
	}
	public void setNameOfPaths(String[] nameOfPaths) {
		this.nameOfPaths = nameOfPaths;
	}
	public void setLengthOfPaths(Vector<Integer> lengthOfPaths) {
		this.lengthOfPaths = lengthOfPaths;
	}
	public void setDefaultBoard(boolean defaultBoar) {
		this.defaultBoard = defaultBoar;
	}
	
	//Methods
	public void createBoard() {
		//this methods defines the structure of the final board
		//number of blocks, type of blocks, alternative paths, etc.
	}
	
}
