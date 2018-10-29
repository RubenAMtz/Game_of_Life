package ie.ucd.the.game.of.life;

public class Board {
	private Tree path;

	public Board() { 
		this.path = createDefaultBoard();
	}	

	public Tree createDefaultBoard() {	
		// Pay-day
		// action
		// holiday
		// spin2win
		// baby (number of babies varies)
		// house
		// stop:
			// Graduation stop
			// Get married stop
			// Night school stop
			// Family stop
			// baby stop
			// holiday stop
		
		Tree t = new Tree("start");
		t.split_path();
		t.addNode("action", "main"); //2 tracker, accmain += 1
		t.addNode("payday", "main"); //3 tracker, accmain += 1
		t.addNode("action", "main"); //4 tracker, accmain += 1
		t.addNode("action", "main"); //5 tracker, accmain += 1
		t.addNode("action", "secondary"); //6 tracker, accsecondary += accmain + 1
		t.addNode("action", "secondary"); //7 tracker, accsecondary += accmain + 1
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("stop", 	"secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.join_path();                   //if there is a join_path flag
		t.addNode("action",		"main"); // 8 tracker, accmain = accsecondary;
		t.addNode("payday", 	"main");
		t.addNode("holiday", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("payday", 	"main");
		t.addNode("action",		"main");
		t.addNode("stop",		"main");
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("holiday",	"main");
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("payday",		"main");
		t.addNode("action",		"main");
		t.addNode("spin2win",	"main");
		t.addNode("action",		"main");
		t.addNode("house",		"main");
		t.addNode("action",		"main");
		t.addNode("splitns",		"main");
		t.split_path();
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("holiday",	"main");
		t.addNode("action",		"main");
		t.addNode("payday",		"main");
		t.addNode("action",		"main");
		t.addNode("action", "secondary");
		 t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("payday", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		t.addNode("action", "secondary");
		 t.join_path();
		t.addNode("action",		"main");
		t.addNode("action",		"main");
		t.addNode("house",		"main");
		t.addNode("action",		"main");
		t.addNode("payday",		"main");
		t.addNode("baby_2",		"main");//********** 
		t.addNode("action",		"main");
		t.addNode("spin2win",	"main");
		t.addNode("holiday",	"main");
		t.addNode("action",		"main");
		t.addNode("house",		"main");
		t.addNode("payday",		"main");
		t.addNode("splitfam",		"main");
		t.split_path();
		t.addNode("action",		"main");
		t.addNode("baby_2",		"main");//*****
		t.addNode("house",		"main");
		t.addNode("baby_g",		"main");
		t.addNode("baby_2",		"main");
		t.addNode("holiday",	"main");
		t.addNode("baby_g",		"main");
		t.addNode("baby_b",		"main"); //we need to specify if it is baby boy or girl 
		t.addNode("action",		"main");
		t.addNode("stop",		"main");
		t.addNode("action", 	"secondary");
		t.addNode("holiday", 	"secondary");
		t.addNode("action", 	"secondary");
		t.addNode("action", 	"secondary");
		t.addNode("action", 	"secondary");
		t.addNode("payday", 	"secondary");
		t.addNode("action", 	"secondary");
		t.join_path();
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("baby_g", 	"main");
		t.addNode("action", 	"main");
		t.addNode("house", 		"main");
		t.addNode("payday", 	"main");
		t.addNode("baby_b", 	"main");
		t.addNode("stop", 		"main");
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("house", 		"main");
		t.addNode("action", 	"main");
		t.addNode("payday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("stop", 		"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("holiday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("payday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("house", 		"main");
		t.addNode("payday", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("action", 	"main");
		t.addNode("spin2win", 	"main");
		t.addNode("action", 	"main");
		t.addNode("retirement", "main");
		
		return t;
	}

	public Tree getPath(){
		return this.path;
	}
}
