package user_controls;

import parser.InputParser;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private String userData;
    private InputParser parser;
    private static String plateauPosition;


    public UserInput(){
        parser = new InputParser();
    }

    public void generateInput(){
        System.out.println("Enter Plateu position");
        scanner = new Scanner(System.in);
        plateauPosition = scanner.nextLine();
        parser.convertPlateu(plateauPosition);
        while (true){
            System.out.println("Enter Instructions");
            scanner = new Scanner(System.in);
            userData = scanner.nextLine();
            parser.convertType(userData);
        }
    }

    public String getPlateuPosition() {
        return plateauPosition;
    }

    public String getUserData() {
        return userData;
    }


}
