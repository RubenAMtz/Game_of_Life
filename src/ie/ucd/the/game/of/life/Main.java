/*
 * TEST CASE FOR FUNCTIONALITY!
 */

package ie.ucd.the.game.of.life;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Main code to test Cards all added here //
		// print("Blocks:\n");
		// Block actionBlock = new Block("action");
		// actionBlock.getProperties();
		// Block marriageBlock = new Block("marriagestop");
		// marriageBlock.getProperties();

		// // Node
		// // Node is a structure used to create links between them and contain Blocks
		// print("Nodes:\n");
		// Node node = new Node("action");
		// Block blockFromNode = node.getBlock();
		// blockFromNode.getProperties();
		
		// // Tree
		// // Tree is constructed with helper functions using Nodes
		// print("Trees:\n");				
		// Tree t = new Tree("start");
		// t.addNode("action", 0);
		// t.split_path(3);
		// t.addNode("action", 0); 
		// t.addNode("action", 1);
		// t.addNode("action", 1);
		// t.addNode("action", 2);
		// t.join_path();
		// t.addNode("action",		0);
		// t.addNode("spin2win", 	0);
		// t.print(t.getRoot());
		
		// // Board
		// // Board encapsulates the Tree, using it to create a default path (the actual board)
		// // It will also be used to store status info about the board
		// print("Board:");		
		// Board board = new Board();
		// Tree path = board.getPath();
		// print("Initial Block from board");
		// path.getRoot().getBlock().getProperties();
									
		// // Card
		// Card card = new Card("action","career_change");
		// print("Name of the card");
		// print(card.getName());
		// print("Type of the card (from within that group)");
		// print(card.getType());
		// // Subclasses of Card
		// ActionCard action_card_01 = new ActionCard("career_change", 0);
		// ActionCard action_card_02 = new ActionCard("players_pay", 10000);
		// print("Get amount (defined for the action card)");
		// print(action_card_01.getAmount());
		// print("Get name of the action card");
		// print(action_card_02.getName());
		// // Deck
		// Deck action_deck = new Deck("action");
		// print("Print deck of action cards, (actioncard objects)");
		// print(action_deck.getDeck());
		// print("Number of cards in deck");
		// print(action_deck.getDeck().size());
		// print("Name of first card from the action card deck");
		// print(action_deck.getDeck().get(0).getName());
		// print("Type of 15th card from the action card deck");
		// print(action_deck.getDeck().get(15).getType());
		// print("Name of 15th card from the action card deck");
		// print(action_deck.getDeck().get(15).getName());
		// //Testing recently added house deck
		// Deck house_deck = new Deck("house");
		// print("Print deck of house cards, (housecard objects)");
		// print(house_deck.getDeck());
		// print("Number of cards in deck");
		// print(house_deck.getDeck().size());
		// //Testing recently added career deck
		// Deck career_deck = new Deck("career");
		// print("Print deck of career cards, (careercard objects)");
		// print(career_deck.getDeck());
		// print("Number of cards in deck");
		// print(career_deck.getDeck().size());
		// //Testing collegecareer deck
		// Deck college_career_deck = new Deck("college_career");
		// print("Print deck of college career cards, (collegecareercard objects");
		// print(college_career_deck.getDeck());
		// print("Number of cards in deck");
		// print(college_career_deck.getDeck().size());
		// //testing polymorphism
		// print("Polymorphism test: ");
		// print("Amount: ");
		// print(action_deck.getDeck().get(6).getAmount());
		// print("Spin Red price: ");	
		// print(house_deck.getDeck().get(1).getSpinRedPrice());
		// print("Salary for College Career Cards");
		// print(college_career_deck.getDeck().get(0).getSalary());
		// print("Salary for Career cards");
		// print(career_deck.getDeck().get(0).getSalary());
		// //What if I call a method that does not belong to a given deck?
		// print(career_deck.getDeck().get(0).getSpinBlackPrice());

		Board board = new Board();
		Tree path = board.getPath();
		//Node ref = null;
		// path.findId(path.getRoot(), 19);
		// print(path.getFoundNode().getId());
		//path.printTree();
		new Game();
		
		
	}

	public static void print(Object text) {
		// function overloading
		System.out.printf("\n");
		System.out.print(text);
		System.out.printf("\n");
	}

	
}
