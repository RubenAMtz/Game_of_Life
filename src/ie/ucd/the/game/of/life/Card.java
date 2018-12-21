package ie.ucd.the.game.of.life;

import java.security.InvalidParameterException;


public class Card {

    private String type;
    private String name;

    public Card(String type, String name){
        // base/shareable properties of Card class
        this.type = validateType(type);
        this.name = name;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }
    
    public String validateType(String type) {
    	if (type.equals("action")) {
    		return type;
    	}
    	else if (type.equals("career")) {
    		return type;
    	}
    	else if (type.equals("college_career")) {
    		return type;
    	}
    	else if (type.equals("house")) {
    		return type;
    	}
    	else {
    		throw new InvalidParameterException("Card type invalid");
    	}
    	
    }
    
    //this methods is overwritten by child methods
    //if the decks call for a method that do not exist in them, -1 will be returned
    //for actioncard
    public Integer getAmount(){
		return -1;
    }

    //for housecard
    public Integer getPurchase(){
		return -1;
	}

	public Integer getSpinRedPrice(){
		return -1;
	}
	
	public Integer getSpinBlackPrice(){
		return -1;
    }
    
    //for careercard
    public Integer getBonus(){
        return -1;
    }

    public Integer getSalary(){
        return -1;
    }

    public Integer getTheyPay(){
        return -1;
    }

    //for CollegeCard the methods already exist (getAmount and getBonus)

}
// Action Card:
// _________________________
// |
// | type (String)
// | name (String)
// | amount (Int)
// | 
// |
// |________________________

// House card:
// _________________________
// |
// | type (String)
// | name (String)
// | purchase_price (Int)
// | spin_red (int)
// | spind_black (int)
// |________________________
