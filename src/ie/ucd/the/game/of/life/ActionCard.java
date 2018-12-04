package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class ActionCard extends Card {

	private Integer amount;

	public ActionCard(String name, Integer amount) {
		super("action", name);
		this.amount = amount;
	}
	
	public Integer getAmount(){
        return this.amount;
    }
}