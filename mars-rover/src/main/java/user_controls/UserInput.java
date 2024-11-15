package user_controls;

import parser.InputParser;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private String userData;
    private InputParser parser;
    private static String plateauPosition;


    public UserInput(){

    }

    public void generateInput(){
        System.out.println("Enter Plateu position");
        scanner = new Scanner(System.in);
        plateauPosition = scanner.nextLine();
    }

    public String getPlateuPosition() {
        return plateauPosition;
    }


}
