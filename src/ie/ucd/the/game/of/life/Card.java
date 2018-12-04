package ie.ucd.the.game.of.life;

public class Card {

    private String type;
    private String name;
    //private Integer amount;

    public Card(String type, String name){
        // base/shareable properties of Card class
        this.type = type;
        this.name = name;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    //this methods is overwritten by child methods
    //if the deks call for a method that do not exist in them, -1 will be returned
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

    //for collegecard the methods already exist (getAmount and getBonus)

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
