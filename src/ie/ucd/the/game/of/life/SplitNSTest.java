package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SplitNSTest {

	@Test
	void nightSchoolTest() {
		Turn stopType = new SplitNS();
		stopType.action(new Player(), new Deck("career"), new Deck("college_career"), new Deck("house"), new ArrayList<Player>());
	}

}