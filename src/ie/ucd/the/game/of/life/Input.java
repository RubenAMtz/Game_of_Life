package ie.ucd.the.game.of.life;

import java.util.InputMismatchException;
import java.util.Scanner;
// import java.lang.Exception;

public class Input {

    private Scanner input;
    private int numResult;
    private String stringResult;
    private boolean inputCheck;

    public Input() {
        this.input = new Scanner(System.in);
        this.numResult = 0;
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