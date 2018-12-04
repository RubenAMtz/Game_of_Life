package ie.ucd.the.game.of.life;

import java.util.Comparator;

public class Sort implements Comparator<Player> {
    @Override
	public int compare(Player p1, Player p2) {
        int comparison = p2.getTurn() - p1.getTurn();   // descending order-(high to low)
        return comparison;
	}
}