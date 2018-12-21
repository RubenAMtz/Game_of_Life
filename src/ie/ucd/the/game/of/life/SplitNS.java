package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class SplitNS extends Turn {

    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        message("Which path would you like to take:");
        input.strictInputNumber(pathSelection, "Press (0) for Same path or Press (1) for Night School path");
        //stop moving and spin again
        cp = input.getNumber();
        
        //if the player selects nights school
        if (cp == 1) {
            message("$100000 will be taken from your account");
            player.addMoney(-100000);
            //remove career card from players deck, and set it at bottom of the deck
            for(int i = 0; i < player.getCards().size(); i++){
                if (player.getCards().get(i).getType().equals("career")) {
                    career_deck.getDeck().add(player.getCards().get(i));
                    player.getCards().remove(i);
                    message("A Career card has been placed at the bottom of the deck");
                }
                else if (player.getCards().get(i).getType().equals("college_career")){
                    college_career_deck.getDeck().add(player.getCards().get(i));
                    player.getCards().remove(i);
                    message("A College Career card has been placed at the bottom of the deck");
                }
            }
            //take top card from deck
            message("Card picked is: %s", college_career_deck.getDeck().get(0).getName());
            //assign card to player
            player.addCard(college_career_deck.getDeck().get(0));
            //assign name to player's career:
            player.setCareer(college_career_deck.getDeck().get(0).getName());
            player.setSalary(college_career_deck.getDeck().get(0).getSalary());
            player.setBonusNum(college_career_deck.getDeck().get(0).getBonus());
            //remove card from college deck
            college_career_deck.getDeck().remove(0);
        }
    }
}