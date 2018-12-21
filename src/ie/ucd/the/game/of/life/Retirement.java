package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Retirement extends Turn {

    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        ArrayList<Card> playerCards;
		int playerKids;
        message("You have reached retirement, time to enjoy life");
        //test variable:
        player.setRetired(true);
        int retiredPlayers = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isRetired()) {
                retiredPlayers++;
            }
        }
        int poolPrize = 500000 - retiredPlayers * 100000;
        player.addMoney(poolPrize);
        player.addMoney(player.getLoan() * -60000);
        message("Retired players: %d", retiredPlayers);
        message("Num of players: %d", players.size());
        //all players are retired:
        if (retiredPlayers == players.size()) {
            retirement = true;
        }

        playerCards = player.getCards();
        playerKids = player.getPawn().getChildren();
        player.addMoney(playerKids * 50000);
        for(int cardIndex = 0; cardIndex < playerCards.size(); cardIndex++) {
            if (playerCards.get(cardIndex).getType().equals("action")) {
                player.addMoney(100000);
            }
            //houses to sell
            else if (playerCards.get(cardIndex).getType().equals("house")) {
                player = Game.sellHouseCard(player, cardIndex, this.input, house_deck, spinner);
            }
        }
    }
}