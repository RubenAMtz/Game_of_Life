package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Baby extends Turn {

    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        message("You arrived at the Baby Stop!");
        message("Spin for Babies");
        message("1-3 for 0 Babies");
        message("4-6 for 1 Baby");
        message("7-8 for Twins");
        message("9-10 for Triplets");
        message("Press ENTER to Spin:");
        input.inputString();
        spinner.spin();
        message("Player%d spins: %d", player.getpNum(), spinner.getValue());
        if (spinner.getValue() < 4) {
            message("You had no Babies");
        }
        else if (spinner.getValue() >= 4 && spinner.getValue() <= 6) {
            player.getPawn().setChildren(player.getPawn().getChildren() + 1);
            message("You had 1 Baby");
        }
        else if (spinner.getValue() == 7 || spinner.getValue() == 8){
            player.getPawn().setChildren(player.getPawn().getChildren() + 2);
            message("You had Twins");
        }
        else {
            player.getPawn().setChildren(player.getPawn().getChildren() + 3);
            message("You had Triplets");
        }
        cp = 0;
    }
}