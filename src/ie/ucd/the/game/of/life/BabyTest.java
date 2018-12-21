package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BabyTest {

	@Test
	void babyTest() {
		Turn stopType = new Baby();
		Player player = new Player();
		player.setPawn(new Pawn());
		stopType.action(player, new Deck("career"), new Deck("college_career"), new Deck("house"), new ArrayList<Player>());
	}

}
