package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public class Start extends Turn {

    @Override
    public void action(Player player, Deck career_deck, Deck college_career_deck, Deck house_deck, ArrayList<Player> players) {
        // all split cases here
        message("Which path would you like to take:");
        input.strictInputNumber(pathSelection, "Press (0) for Career path or Press (1) for College Career path");
        //player takes college career path:
        cp = input.getNumber();
        if (cp == 1) {
            player.addMoney(-100000);
        }
        else if (cp == 0) {
            message("Card1: %s, SALARY %dK, Bonus Number %d", career_deck.getDeck().get(0).getName(), career_deck.getDeck().get(0).getSalary()/1000, career_deck.getDeck().get(0).getBonus());
            message("Card2: %s, SALARY %dK, Bonus Number %d", career_deck.getDeck().get(1).getName(), career_deck.getDeck().get(1).getSalary()/1000, career_deck.getDeck().get(1).getBonus());
            input.strictInputNumber(cardSelection, "Select Card1 (1) or Card2 (2):");
            //assign card to player
            cardIndex = input.getNumber()-1;
            player.addCard(career_deck.getDeck().get(cardIndex));
            //assign name to player's career:
            player.setCareer(career_deck.getDeck().get(cardIndex).getName());
            player.setSalary(career_deck.getDeck().get(cardIndex).getSalary());
            player.setBonusNum(career_deck.getDeck().get(cardIndex).getBonus());
            //remove cards from deck, set left card at the bottom of the deck:
            //check if the card is place at the bottom of the deck?
            career_deck.getDeck().add(career_deck.getDeck().get(cardIndex));
            //index minus 1 to match correct order:
            career_deck.getDeck().remove(0);
            career_deck.getDeck().remove(0);
        }
        stop = false;
    }
}