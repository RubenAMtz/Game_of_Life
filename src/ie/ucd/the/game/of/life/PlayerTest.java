package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testLoan() {
		Player player1 = new Player();
		player1.setMoney(200000);
		player1.setLoan(0);
		assertEquals(player1.getLoan(), 0);
		player1.addMoney(-220000);
		assertEquals(player1.getLoan(), 1);
		assertEquals(player1.getMoney(), 30000);
		player1.addMoney(-100000);
		assertEquals(player1.getLoan(), 3);
		Player player2 = new Player();
		player2.setMoney(200000);
		player2.setLoan(0);
		player1.paysMoneyTo(player2, 100);
		assertEquals(player1.getMoney(), 29900);
		assertEquals(player2.getMoney(), 200100);
	}

}
