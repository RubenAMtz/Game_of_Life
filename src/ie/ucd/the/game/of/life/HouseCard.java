package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class HouseCard extends Card {

	private Integer purchase;
	private Integer spin_red_price;
	private Integer spin_black_price;

	public HouseCard(String name, Integer purchase, Integer spin_red_price, Integer spin_black_price) {
		super("house", name);
		this.purchase = purchase;
		this.spin_red_price = spin_red_price;
		this.spin_black_price = spin_black_price;
	}

	public Integer getPurchase(){
		return this.purchase;
	}

	public Integer getSpinRedPrice(){
		return this.spin_red_price;
	}
	
	public Integer getSpinBlackPrice(){
		return this.spin_black_price;
	}
}