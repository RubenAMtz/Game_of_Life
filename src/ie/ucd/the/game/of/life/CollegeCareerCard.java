package ie.ucd.the.game.of.life;

public class CollegeCareerCard extends Card {

    private Integer salary;
    private Integer bonus;
    private Integer they_pay;

	public CollegeCareerCard(String name, Integer salary, Integer bonus, Integer they_pay) {
		super("college_career", name);
        this.bonus = bonus;
        this.salary = salary;
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