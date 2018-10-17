package ie.ucd.the.game.of.life;

import java.util.ArrayList;

public interface Blocks {
	
	/*public static final ArrayList<String> BLOCK = new ArrayList<String>() {{
	    add("action");
	    add("payday");
	    add("house");
	    add("spin2win");
	    add("babyg");
	    add("babyb");
	    add("baby2");
	    add("holiday");
	    add("stop");
	    add("splitns");
	    add("splitfam");
	    add("house");
	}};*/
	
	public int blockType(ArrayList<String> block);
	public void action(Player player);
	
}
