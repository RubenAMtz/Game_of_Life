package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Marriage extends Turn {

    /*The status of the car pawn should be updated to indicate that the player has a spouse. Each of the other players should spin 
    the spinner. If the spinner ends up on an odd number, the player spinning the spinner has to give the married player 100K, 50K 
    otherwise. Finally the married player should spin the spinner to move again.*/
    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        message("You have stopped and are getting married");
        player.getPawn().setSpouse(true);
        message("All other players will now spin to determine how much money they will give to the Player: (red) = 100k or (black) = 50k");
        for(int index = 0; index < players.size(); index++) {
            if (players.get(index).getpNum() != player.getpNum()) {
                message("Player%d: Press ENTER to Spin: ", players.get(index).getpNum());
                input.inputString();
                spinner.spin();
                message("Player%d spins: %d", players.get(index).getpNum(), spinner.getValue());
                if (spinner.getColor().equals("red")) {
                    players.get(index).paysMoneyTo(player, 100000);
                    message("Player%d pays 100000 to Player%d",players.get(index).getpNum(), player.getpNum());
                }
                else {
                    players.get(index).paysMoneyTo(player, 50000);
                    message("Player%d pays 50000 to Player%d",players.get(index).getpNum(), player.getpNum());
                }
            }
        }
        cp = 0;
        stop = true;
        repeat = true;
    }
}