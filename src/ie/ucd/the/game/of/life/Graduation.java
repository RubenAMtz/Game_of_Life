package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Graduation extends Turn {

    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        /*The current player should take the top 2 College Career cards from the deck. S/he should choose his/her favorite card
        and keep it because that will represent his/her job. The other card should be placed at the bottom of the deck.*/
        message("You have stopped at the Graduation Stop. You now get to select you College Career:");
        message("Card1: %s, SALARY %dK, Bonus Number %d", college_career_deck.getDeck().get(0).getName(), college_career_deck.getDeck().get(0).getSalary()/1000, college_career_deck.getDeck().get(0).getBonus());
        message("Card2: %s, SALARY %dK, Bonus Number %d", college_career_deck.getDeck().get(1).getName(), college_career_deck.getDeck().get(1).getSalary()/1000, college_career_deck.getDeck().get(1).getBonus());
        input.strictInputNumber(cardSelection, "Select Card1 (1) or Card2 (2):");
        //assign card to player
        cp = input.getNumber()-1;
        //remove career card from players deck, and set it at bottom of the deck if they got an action card that gave them career
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
        player.addCard(college_career_deck.getDeck().get(cp));
        //assign name to player's career:
        player.setCareer(college_career_deck.getDeck().get(cp).getName());
        player.setSalary(college_career_deck.getDeck().get(cp).getSalary());
        player.setBonusNum(college_career_deck.getDeck().get(cp).getBonus());
        //remove card from deck, set left card at the bottom of the deck:
        //check if the card is place at the bottom of the deck?
        college_career_deck.getDeck().add(college_career_deck.getDeck().get(cp));
        //index minus 1 to match correct order:
        college_career_deck.getDeck().remove(0);
        college_career_deck.getDeck().remove(0);
        cp = 0; // continue on the same path
        stop = true;
    }
}