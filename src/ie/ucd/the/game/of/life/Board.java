package ie.ucd.the.game.of.life;

public class Board {
	private Tree path;
	//private Block blocks;

	public Board() { 
		this.path = createDefaultBoard();
		//this.blocks = new Block("start");
	}	

	//we are still considering ideas for the logic on how add nodes:
	// basis of logic, an intuitive way as described below, but for as many branches as they come:

	/*possible way of defining the tree?
		t.addNodes("n1")
		t.addNodes("n1","n2","n3")
		t.addNodes("ny",) <- maybe n1 and n2 connect to ny.
		t.addNodes("nx")  <- nx connects to ny and n3 ? how can we make this intuitively ?
		*/

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
		t.addNode("test", 0);
		t.split_path(3);
		t.addNode("action", 0); //5 tracker, accmain += 1
		t.addNode("action", 1); //6 tracker, accsecondary += accmain + 1
		t.addNode("action", 1);
		t.addNode("action", 2);
		t.join_path();                   //if there is a join_path flag
		t.addNode("action",		0);
//		t.addNode("spin2win", 	0);
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
//		t.split_path();
//		t.addNode("action",		0);
//		t.addNode("action",		0);
//		t.addNode("holiday",	0);
//		t.addNode("action",		0);
//		t.addNode("payday",		0);
//		t.addNode("action",		0);
//		t.addNode("action", 1);
//		 t.addNode("action", 1);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
//		t.addNode("payday", 1);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
//		t.addNode("action", 1);
//		 t.join_path();
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
//		t.addNode("action", 	0);
//		t.addNode("retirement", 0);
		
		// *******************OLD***********************
		/*Tree t = new Tree("start");
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
		t.addNode("retirement", "main");*/
		
		return t;
	}

	public Tree getPath(){
		return this.path;
	}
}
