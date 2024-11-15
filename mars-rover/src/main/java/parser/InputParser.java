package parser;

import input_layer.Conversion;

import input_layer.ConvertInstruction;
import input_layer.ConvertPosition;
import user_controls.UserInput;

import java.util.stream.Stream;

public class InputParser {
    public Conversion conversion;
    public UserInput userInput;

    public InputParser(){
        userInput = new UserInput();
    }
    public void convertType(String data){
        if(userInput.getPlateuPosition() == null){
            System.out.println("Set Plateu Position");
            return;
        }

        int numCounter = 0;
        for(int i =0;i<data.length();i++){
            if(Character.isDigit(data.charAt(i))){
                numCounter++;
            }
        }

        if(numCounter == 2){
            conversion = new ConvertPosition();
            conversion.convertData(data);
        }
        else if(numCounter == 0){
            conversion = new ConvertInstruction();
            conversion.convertData(data);
        }
        else{
            System.out.println("Input Error");
            return;
        }

    }
}
