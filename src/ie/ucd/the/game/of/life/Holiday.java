package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Holiday extends Turn {

    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        message("You had to stop on a holiday block");
        cp = 0;
    }
}