package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class SplitFam extends Turn {

    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        message("Which path would you like to take:");
		input.strictInputNumber(pathSelection, "Press (0) for Family path or Press (1) for No Family path");
        cp = input.getNumber();
        repeat = false;
    }
}