package ie.ucd.the.game.of.life;

public class Board {
	private Tree path;
	//private Block blocks;

	public Board() { 
		this.path = createDefaultBoard();
		//this.blocks = new Block("start");
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
		t.addNode("action", 0);
		t.split_path(3);
		t.addNode("action", 0); //5 tracker, accmain += 1
		t.addNode("action", 1); //6 tracker, accsecondary += accmain + 1
		t.addNode("action", 1);
		t.addNode("action", 2);
		t.join_path();                   //if there is a join_path flag
		t.addNode("action",		0);
		t.addNode("spin2win", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("payday", 	0);
//		t.addNode("action",		0);
//		t.addNode("stop",		0);
//		t.addNode("action",		0);
//		t.addNode("action",		0);
//		t.addNode("holiday",	0);
//		t.addNode("action",		0);
//		t.addNode("action",		0);
//		t.addNode("payday",		0);
//		t.addNode("action",		0);
//		t.addNode("spin2win",	0);
//		t.addNode("action",		0);
//		t.addNode("house",		0);
//		t.addNode("action",		0);
//		t.addNode("splitns",		0);
		t.split_path(2);
//		t.addNode("action",		0);
		t.addNode("action",		0);
//		t.addNode("holiday",	0);
//		t.addNode("action",		0);
//		t.addNode("payday",		0);
//		t.addNode("action",		0);
		t.addNode("action", 1);
		t.addNode("action", 2);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
//		t.addNode("payday", 1);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
		 t.join_path();
//		t.addNode("action",		0);
//		t.addNode("action",		0);
//		t.addNode("house",		0);
//		t.addNode("action",		0);
//		t.addNode("payday",		0);
//		t.addNode("baby_2",		0);//********** 
//		t.addNode("action",		0);
//		t.addNode("spin2win",	0);
//		t.addNode("holiday",	0);
//		t.addNode("action",		0);
//		t.addNode("house",		0);
//		t.addNode("payday",		0);
//		t.addNode("splitfam",		0);
//		t.split_path();
//		t.addNode("action",		0);
//		t.addNode("baby_2",		0);//*****
//		t.addNode("house",		0);
//		t.addNode("baby_g",		0);
//		t.addNode("baby_2",		0);
//		t.addNode("holiday",	0);
//		t.addNode("baby_g",		0);
//		t.addNode("baby_b",		0); //we need to specify if it is baby boy or girl 
//		t.addNode("action",		0);
//		t.addNode("stop",		0);
//		t.addNode("action", 	1);
//		t.addNode("holiday", 	1);
//		t.addNode("action", 	1);
//		t.addNode("action", 	1);
//		t.addNode("action", 	1);
//		t.addNode("payday", 	1);
//		t.addNode("action", 	1);
//		t.join_path();
//		t.addNode("action", 	0);
//		t.addNode("spin2win", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("baby_g", 	0);
//		t.addNode("action", 	0);
//		t.addNode("house", 		0);
//		t.addNode("payday", 	0);
//		t.addNode("baby_b", 	0);
//		t.addNode("stop", 		0);
//		t.addNode("action", 	0);
//		t.addNode("spin2win", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("house", 		0);
//		t.addNode("action", 	0);
//		t.addNode("payday", 	0);
//		t.addNode("action", 	0);
//		t.addNode("stop", 		0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("holiday", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("payday", 	0);
//		t.addNode("action", 	0);
//		t.addNode("spin2win", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("house", 		0);
//		t.addNode("payday", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("action", 	0);
//		t.addNode("spin2win", 	0);
		t.addNode("action", 	0);
		t.addNode("retirement", 0);
		
		return t;
	}

	public Tree getPath(){
		return this.path;
	}
}
