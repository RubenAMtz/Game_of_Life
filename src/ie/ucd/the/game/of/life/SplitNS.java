//package ie.ucd.the.game.of.life;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class SplitNS implements Blocks {
//
//	@Override
//	public int blockType(ArrayList<String> block) {
//		
//		return Collections.frequency(block, "splitns"); // return 1 if string present within list
//	}
//
//	@Override
//	public void action(Player player) {
//		
//		Scanner input = new Scanner(System.in);
//		System.out.printf("Choose a path: (y/n)\n");
//		String i = input.next();
//		input.close();
//		Node nextNode = null;
//		
//		if (i == "n" || i == "N"){
//			nextNode = player.getPosition().getFirst();												
//		}
//		else if (i == "y" || i == "Y") {
//			nextNode = player.getPosition().getSecond();
//		}
//		
//		player.setPosition(nextNode);
//	}
//}
