package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class CareerCard extends Card {

    private Integer bonus;
    private Integer salary;
    private Integer they_pay;

	public CareerCard(String name, Integer bonus, Integer salary, Integer they_pay) {
        super("career", name);
        this.bonus = bonus;
        this.salary = salary;
        //every card in the real deck is set with 20k as "they pay", however, we take control over the parameter to make it flexible
        this.they_pay = they_pay;
    }
    
    public Integer getBonus(){
        return this.bonus;
    }

    public Integer getSalary(){
        return this.salary;
    }

    public Integer getTheyPay(){
        return this.they_pay;
    }

}
