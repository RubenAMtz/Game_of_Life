package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public abstract class Turn {

    Input input = new Input();
    Spinner spinner = new Spinner();
	public static int[] pathSelection = {0, 1};
    public static int[] cardSelection = {1, 2};
    protected static int chosenPath = 0;
    protected static boolean stop = true;
    protected static boolean repeat = false;
    protected int cp;
    protected static boolean retirement = false;
    public int cardIndex;

    public abstract void action(Player p, Deck c, Deck cc, Deck hd, ArrayList<Player> ps);

    public static void message(Object text, Object ... args) {
		String convertedToString = String.valueOf(text);
		System.out.printf(convertedToString + "\n", args);
    }
    public int getChosenPath() {
        return cp;
    }
    public boolean isRetirement() {
        return retirement;
    }
    public boolean isStop() {
        return stop;
    }
    public boolean isRepeat() {
        return repeat;
    }

}