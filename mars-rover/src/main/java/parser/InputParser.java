package parser;

import input_layer.Conversion;

import input_layer.ConvertInstruction;
import input_layer.ConvertPlateau;
import input_layer.ConvertPosition;
import types.CompassDirection;
import user_controls.UserInput;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.stream.Stream;

public class InputParser {
    private Conversion conversion;
    private UserInput userInput;

    public InputParser(){
        userInput = new UserInput();
    }

    public Conversion convertType(String data){
        if(data == null || data.isEmpty()){
            //System.out.println("Set Plateu Position");
            throw new NullPointerException();
        }


        int numCounter = (int) data.chars().filter(Character::isDigit).count();
        int positionCounter =  (int) Stream.of(CompassDirection.values()).filter(y -> (data.chars().mapToObj(x -> (char) x).filter(x -> String.valueOf(x).equals(String.valueOf(y))).count() > 0)).count();
        System.out.println(numCounter + " " + positionCounter);

        if(numCounter == 2 && positionCounter == 1){
            conversion = new ConvertPosition();
            conversion.convertData(data);
            return conversion;
        }
        else if(numCounter == 0){
            conversion = new ConvertInstruction();
            conversion.convertData(data);
            return conversion;
        }
        else{
            throw new InputMismatchException();
        }

    }

    public Conversion convertPlateu(String plateu){
        if(plateu == null || plateu.isEmpty()){
            //System.out.println("Set Plateu Position");
            throw new NullPointerException();
        }

        int numCounter = (int) plateu.chars().filter(Character::isDigit).count();

        if(numCounter == 2){
            conversion = new ConvertPlateau();
            conversion.convertData(plateu);
            return conversion;
        }  else{
            throw new InputMismatchException();
        }
    }

}
