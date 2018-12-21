package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StartTest {

	@Test
	void startTest() {
		Turn stopType = new Start();
		stopType.action(new Player(), new Deck("career"), new Deck("college_career"), new Deck("house"), new ArrayList<Player>());
	}

}
