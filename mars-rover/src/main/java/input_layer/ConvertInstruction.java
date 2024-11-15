package input_layer;
import parser.InputParser;
import types.Instruction;

import java.util.ArrayList;
import java.util.InputMismatchException;


public class ConvertInstruction implements Conversion{
    private InputParser parser;
    private ArrayList<Instruction> instruction;

    @Override
    public ArrayList<Instruction> convertData(String userInput){
        userInput = userInput.replaceAll("[^\\w]+ ","");
        instruction = new ArrayList<>();
        if(userInput == null|| userInput.isEmpty()){
            throw new NullPointerException();
        }
        for(int i = 0;i<userInput.length();i++){
            if(!Character.isLetterOrDigit(userInput.charAt(i))){
                throw new InputMismatchException();
            }
            switch (userInput.charAt(i)){
                case 'L' -> {
                    instruction.add(Instruction.L);
                    break;
                }
                case 'R' -> {
                    instruction.add(Instruction.R);
                    break;
                }
                case 'M' -> {
                    instruction.add(Instruction.M);
                    break;
                }
                default -> {
                    System.out.println("Input Invalid");
                }
            }
        }
        return instruction;
    }






}
