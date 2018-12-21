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
		t.split_path(2);
		t.addNode("action", 0);
		t.addNode("action", 0); //2 tracker, accmain += 1
		t.addNode("payday", 0); //3 tracker, accmain += 1
		t.addNode("action", 0); //4 tracker, accmain += 1
		t.addNode("action", 0); //5 tracker, accmain += 1
		t.addNode("action", 1); //6 tracker, accsecondary += accmain + 1
		t.addNode("action", 1); //7 tracker, accsecondary += accmain + 1
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("graduationstop", 	1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.join_path();
		t.addNode("action",		0);
		t.addNode("payday", 	0);
		t.addNode("holiday",		0);
		t.addNode("spin2win", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("payday", 	0);
		t.addNode("action",		0);
		t.addNode("marriagestop",		0);
		t.addNode("action",		0);
		t.addNode("action",		0);
		t.addNode("holiday",	0);
		t.addNode("action",		0);
		t.addNode("action",		0);
		t.addNode("payday",		0);
		t.addNode("action",		0);
		t.addNode("spin2win",	0);
		t.addNode("action",		0);
		t.addNode("house",		0);
		t.addNode("action",		0);
		t.addNode("splitns",		0);
		t.split_path(2);
		t.addNode("action",		0);
		t.addNode("action",		0);
		t.addNode("holiday",	0);
		t.addNode("action",		0);
		t.addNode("payday",		0);
		t.addNode("action",		0);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("payday", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.addNode("action", 1);
		t.join_path();
		t.addNode("action",		0);
		t.addNode("action",		0);
		t.addNode("house",		0);
		t.addNode("action",		0);
		t.addNode("payday",		0);
		t.addNode("baby_2",		0);
		t.addNode("action",		0);
		t.addNode("spin2win",	0);
		t.addNode("holiday",	0);
		t.addNode("action",		0);
		t.addNode("house",		0);
		t.addNode("payday",		0);
		t.addNode("splitfam",		0);
		t.split_path(2);
		t.addNode("action",		0);
		t.addNode("baby_2",		0);
		t.addNode("house",		0);
		t.addNode("baby_g",		0);//we need to specify if it is baby boy or girl 
		t.addNode("baby_2",		0);
		t.addNode("holiday",	0);
		t.addNode("baby_g",		0);
		t.addNode("baby_b",		0);
		t.addNode("action",		0);
		t.addNode("babystop",		0);
		t.addNode("action", 	1);
		t.addNode("holiday", 	1);
		t.addNode("action", 	1);
		t.addNode("action", 	1);
		t.addNode("action", 	1);
		t.addNode("payday", 	1);
		t.addNode("action", 	1);
		t.join_path();
		t.addNode("action", 	0);
		t.addNode("spin2win", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("baby_g", 	0);
		t.addNode("action", 	0);
		t.addNode("house", 		0);
		t.addNode("payday", 	0);
		t.addNode("baby_b", 	0);
		t.addNode("holidaystop", 		0);
		t.addNode("action", 	0);
		t.addNode("spin2win", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("house", 		0);
		t.addNode("action", 	0);
		t.addNode("payday", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("holiday", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("payday", 	0);
		t.addNode("action", 	0);
		t.addNode("spin2win", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("house", 		0);
		t.addNode("payday", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("action", 	0);
		t.addNode("spin2win", 	0);
		t.addNode("action", 	0);
		t.addNode("retirement", 0);
		
		return t;
	}

	public Tree getPath(){
		return this.path;
	}
}