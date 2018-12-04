package ie.ucd.the.game.of.life;

//import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Collections;

//import org.omg.IOP.CodeSets;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<>();
	private int size;
	private String type;
	private ActionCard action_card = null;
	
	public Deck(String type) {
		this.type = type;
		//size needs to take the size of the elements in the array, not a given parameter.
		create();
		this.size = cards.size();
		shuffle();
	}	
	// steps:
	// create cards
	// shuffle cards
	
	//this method should not be callable by the instance, the constructor calls for it.
	public void create(){
		if (this.type == "action"){
			// 5 career change cards
			add("career_change",5, 0);
			// 10 Players pay cards
			add("players_pay",10, 20000);
			// 20 Pay the bank cards
			add("pay_the_bank",4, 10000);
			add("pay_the_bank",4, 20000);
			add("pay_the_bank",4, 30000);
			add("pay_the_bank",4, 40000);
			add("pay_the_bank",4, 50000);
			// 20 Get Cash from the Bank cards
			add("bank_pays_you",4, 10000);
			add("bank_pays_you",4, 20000);
			add("bank_pays_you",4, 30000);
			add("bank_pays_you",4, 40000);
			add("bank_pays_you",4, 50000);
		}
		else if (this.type == "house"){
			//14 cards total
			//define type of property
			//define purchase price,
			//define sell prices (selected by spinning the wheel)
			cards.add(new HouseCard("ranch", 600000, 600000, 750000));
			cards.add(new HouseCard("city_penthouse", 600000, 650000, 700000));
			cards.add(new HouseCard("island_holiday_home", 600000, 550000, 800000));
			cards.add(new HouseCard("dream_villa", 300000, 250000, 380000));
			cards.add(new HouseCard("farmhouse", 300000, 250000, 380000));
			cards.add(new HouseCard("windmill", 350000, 300000, 500000));
			cards.add(new HouseCard("family_house", 250000, 200000, 300000));
			cards.add(new HouseCard("luxury_flat", 250000, 200000, 300000));
			cards.add(new HouseCard("eco_house", 200000, 180000, 300000));
			cards.add(new HouseCard("estudio_flat", 100000, 80000, 150000));
			cards.add(new HouseCard("houseboat", 200000, 180000, 300000));
			cards.add(new HouseCard("teepee", 100000, 80000, 150000));
			cards.add(new HouseCard("cozy_cottage", 150000, 120000, 200000));
			cards.add(new HouseCard("beach_hut", 100000, 80000, 150000));
		}
		else if (this.type == "career"){
			//8 cards total
			//Define career name
			//Define bonus number(acts as an ID that refers to the player)
			//Define ammount.
			cards.add(new CareerCard("actor", 5, 100000, 20000));
			cards.add(new CareerCard("inventor", 4, 80000, 20000));
			cards.add(new CareerCard("singer", 3, 70000, 20000));
			cards.add(new CareerCard("race_car_driver", 2, 60000, 20000));
			cards.add(new CareerCard("athlete", 1, 50000, 20000));
			cards.add(new CareerCard("police_officer", 4, 50000, 20000));
			cards.add(new CareerCard("chef", 3, 50000, 20000));
			cards.add(new CareerCard("dancer", 2, 50000, 20000));
		}
		else if (this.type == "college_career"){
			//12 cards total
			//Define career name
			//Define bonus number (acts as an ID that refers to the player)
			//Define ammount
			cards.add(new CollegeCareerCard("doctor", 130000, 10, 20000));
			cards.add(new CollegeCareerCard("lawyer", 120000, 9, 20000));
			cards.add(new CollegeCareerCard("video_game_designer", 110000, 8, 20000));
			cards.add(new CollegeCareerCard("vet", 100000, 7, 20000));
			cards.add(new CollegeCareerCard("teacher", 100000, 6, 20000));
			cards.add(new CollegeCareerCard("scientist", 100000, 9, 20000));
			cards.add(new CollegeCareerCard("secret_agent", 100000, 8, 20000));
			cards.add(new CollegeCareerCard("fashion_designer", 80000, 7, 20000));
		}
	}

	public void shuffle(){
		Collections.shuffle(this.cards);
	}

	public void add(String name, Integer size, Integer amount){
		if (this.type == "action"){
			for (int i=0; i<size; i++){
				cards.add(action_card = new ActionCard(name, amount));
			}
		}
	}

	public ArrayList<Card> getDeck(){
		return this.cards;
	}
	
	public String deckToString() {
		String deck = "";
		for (Card card : this.cards) {
			deck += " | " + card.getName();
		}
		deck += " | ";
		return deck;
	}
}