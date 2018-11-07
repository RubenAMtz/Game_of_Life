package ie.ucd.the.game.of.life;

public class Block {
	
	private String type;
	private Block blockAction;
	private boolean draw_action_card;
	private boolean draw_house_card;
	private boolean draw_collegecarrer_card;
	private boolean pays_bank;
	private boolean update_pawn;
	private boolean marriage;
	private boolean stop;
	private String type_of_stop;
	private boolean payday;
	private boolean spin2win;
	private String baby;
	private boolean split;
	private boolean playerSpin;
	private boolean retirement;

	public Block(String type) {
		setType(type);

		this.draw_action_card = false;
		this.draw_house_card = false;
		this.draw_collegecarrer_card = false;
		this.pays_bank = false;
		this.update_pawn = false;
		this.marriage = false;
		this.stop = false;
		this.type_of_stop = null;
		this.payday = false;
		this.spin2win = false;
		this.baby = null;
		this.split = false;
		this.playerSpin = false;
		this.retirement = false;

		constructBlock(type);
	}
	
	public void constructBlock(String type) {
		if (type == "splitns") {
			// Split night school
			this.stop = true;
			this.type_of_stop = "Night School";
			this.split = true;
			this.playerSpin = true;
		}
		else if (type == "splitfam") {
			// Split family path
			this.stop = true;
			this.type_of_stop = "Family Path";
			this.split = true;
		}
		else if (type == "graduationstop") {
			this.stop = true;
			this.draw_collegecarrer_card = true;
		}
		else if (type == "marriagestop") {
			this.stop = true;
			this.marriage = true;
			this.playerSpin = true;
		}
		else if (type == "babystop") {
			this.stop = true;

		}
		else if (type == "holidaystop") {
			// Player has to stop and do nothing
			this.stop = true;
		}
		else if (type == "payday") {
			System.out.println("\nHit a PAYDAY block\n");
			// Collect money on card if passed
			// Collect additional 100k if landed on
			this.payday = true;
		}
		else if (type == "action") {
			this.draw_action_card = true;
			// player keeps this action card
		}
		else if (type == "holiday") {
			// Do nothing special
		}
		else if (type == "spin2win") {
			// Player who land on block chooses 2 numbers
			// Others players choose 1 number each
			// Current player spins until one number comes
			// The player who selected the number get 200k from bank
			this.spin2win = true;
		}
		else if (type == "baby_g") {
			// Update pawn with baby_girl + 1
			this.baby = "Baby girl";
		}
		else if (type == "baby_b") {
			// Update pawn with baby_boy + 1
			this.baby = "Baby boy";
		}
		else if (type == "baby_2") {
			// Update pawn with two random children gender
			this.baby = "2 random babies";
		}
		else if (type == "house") {
			this.draw_house_card = true;
			/* Select whether to buy or sell house first:
			if BUY:
				picking up the top 2 house cards
				Player selects favorite and pays bank amount on card
			else SELL:
				Player spins spinner
				Depend on number - sell house to banker
				Return card to deck								
				*/		
		}
		else if (type == "retirement") {
			this.stop = true;
		}
		else {
			// This should throw an error
			System.out.println("Not possible");
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
