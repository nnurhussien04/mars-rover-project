package user_controls;

import input_layer.Conversion;
import parser.InputParser;
import types.Instruction;
import types.PlateauSize;
import types.Position;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private String userData;
    private InputParser parser;
    private static String plateauPosition;
    private static Conversion conversion;
    private static Rover rover;


    public UserInput(){
        parser = new InputParser();
    }

    public void generateInput(){
        System.out.println("Enter Plateu position");
        scanner = new Scanner(System.in);
        plateauPosition = scanner.nextLine();
        parser.convertPlateu(plateauPosition);
        System.out.println("This is the plateu size: " + parser.getPlateauCoordinates());
        while (true){
            System.out.println("Enter Instructions");
            scanner = new Scanner(System.in);
            userData = scanner.nextLine();
            parser.convertType(userData);
            if(parser.getPosition() != null){
                rover = new Rover(parser.getPosition(),parser.getPlateauSize());
                System.out.println("This is rover new position: " + rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getPosition().getFacing());
                parser.setPosition(null);
            }
            else if(parser.getInstruction() != null){
                parser.getInstruction().stream().filter(x -> x.equals(Instruction.M)).forEach(x -> {
                    try {
                        rover.move(x);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                parser.getInstruction().stream().filter(x -> x.equals(Instruction.L) || x.equals(Instruction.R)).forEach(x -> {
                    try {
                        rover.rotate(x);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                System.out.println("This is rover current position: " + rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getPosition().getFacing());


            }


            //System.out.println(conversion);
        }
    }

    public String getPlateuPosition() {
        return plateauPosition;
    }

    public String getUserData() {
        return userData;
    }


}
