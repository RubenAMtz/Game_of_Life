package ie.ucd.the.game.of.life;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Input {

    private Scanner input;
    private int numResult;
    private String stringResult;
    private boolean inputCheck;

    public Input() {
        this.input = new Scanner(System.in);
        this.numResult = -1;
        this.stringResult = null;
        this.inputCheck = true;
    }

    public void inputNumber() {
        do {
            try {
                setNumber(input.nextInt());
                this.inputCheck = false;
            } catch (InputMismatchException e){
                System.out.println("Oops :O invalid number! Please try again. . .");
                this.input.nextLine();
            }
        } while (this.inputCheck);
        this.inputCheck = true;
        this.input.nextLine();           // Avoids buffer issue with nextInt E.g 21\n...eliminates the \n used for next int
    }

    public void inputString() {
        setString(input.nextLine());
    }

    // List1
    public void strictInputNumber(int[] inputs, String message) {
        do {
            System.out.println(message);
            inputNumber();
        } while (useList1(inputs, getNumber()));
    }

    public static boolean useList1(int[] arr, int targetValue) {
        return !Arrays.stream(arr).anyMatch(i -> i == targetValue);
    }
    
    // List2
    public void strictInputString(String[] inputs) {
        do {
            inputString();
        } while (useList2(inputs, getString()));
    }

    public static boolean useList2(String[] arr, String targetValue) {
        return !Arrays.asList(arr).contains(targetValue);
    }

    // List3
    public void strictArrInputString(ArrayList<String> inputs) {
        do {
            inputString();
        } while (useList3(inputs, getString()));
    }

    public static boolean useList3(ArrayList<String> arr, String targetValue) {
        return !arr.contains(targetValue);
    }

    public void inputClose() {
        input.close();
    }

    // Getters
    public int getNumber() {
        return this.numResult;
    }

    public String getString() {
        return this.stringResult;
    }

    // Setters
    public void setNumber(int numResult) {
        this.numResult = numResult;
    }

    public void setString(String stringResult) {
        this.stringResult = stringResult;
    }
}