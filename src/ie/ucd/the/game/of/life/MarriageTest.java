package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class MarriageTest {

	@Test
	void marriageTest() {
		Turn stopType = new Marriage();
		ArrayList<Player> marriage = new ArrayList<Player>();
		marriage.add(new Player());
		marriage.get(0).setPawn(new Pawn());
		marriage.add(new Player());
		marriage.add(new Player());
		marriage.add(new Player());
		stopType.action(marriage.get(0), new Deck("career"), new Deck("college_career"), new Deck("house"), marriage);
	}

}
