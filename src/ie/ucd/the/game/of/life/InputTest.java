package ie.ucd.the.game.of.life;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class InputTest {

	@Test
	void testConstructor() {
		Input input = new Input();
		assertTrue(input.getNumber() < 0, "Value not -1");
		assertNull(input.getString(), "String value not null");
	}
	
	@Test
	void testIntInput() {
		Input input = new Input();
		System.out.println("integer Test: ");
		input.inputNumber();
		assertTrue(input.getNumber() >= 0 || input.getNumber() < 0, "Value not integer");
	}
	
	@Test
	void testLimitedInputs() {
		Input input = new Input();
		int[] inputs = {-1, 0, 1, 2, 4};
		input.strictInputNumber(inputs, "message to notify to one of the following: {-1, 0, 1, 2, 4}");
		assertTrue(input.getNumber() == -1 || input.getNumber() == 0 || input.getNumber() == 1 || input.getNumber() == 2 || input.getNumber() == 4, "Value not as specified");
	}
	
	@Test
	void testLimitedStrings() {
		Input input = new Input();
		String[] inputs = {"test1", "test2"};
		System.out.println("message to notify to one of the following: {test1, test2}");
		input.strictInputString(inputs);
		assertTrue(input.getString().equals("test1") || input.getString().equals("test2"), "Value not as specified");
	}
	
	@Test
	void testLimitedArrStrings() {
		Input input = new Input();
		ArrayList<String> inputs = new ArrayList<String>();
		inputs.add("test1");
		inputs.add("test2");
		System.out.println("message to notify to one of the following: {test1, test2}");
		input.strictArrInputString(inputs);
		assertTrue(input.getString().equals("test1") || input.getString().equals("test2"), "Value not as specified");
	}

}
