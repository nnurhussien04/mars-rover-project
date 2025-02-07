package parser;

import input_layer.Conversion;

import input_layer.ConvertInstruction;
import input_layer.ConvertPlateau;
import input_layer.ConvertPosition;
import types.CompassDirection;
import types.Instruction;
import types.PlateauSize;
import types.Position;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.stream.Stream;

public class InputParser {
    private Conversion conversion;
    private PlateauSize plateauSize;
    private ArrayList <Instruction> instruction;
    private Position position;

    public InputParser(){
    }

    public Conversion convertType(String data){
        if(data == null || data.isEmpty()){
            //System.out.println("Set Plateu Position");
            throw new NullPointerException();
        }

        int numCounter = (int) data.chars().filter(Character::isDigit).count();
        int positionCounter =  (int) Stream.of(CompassDirection.values()).filter(y -> (data.chars().mapToObj(x -> (char) x).filter(x -> String.valueOf(x).equals(String.valueOf(y))).count() > 0)).count();
        //System.out.println(numCounter + " " + positionCounter);

        if(numCounter == 2 && positionCounter == 1){
            conversion = new ConvertPosition();
            position = (Position) conversion.convertData(data);
            return conversion;
        }
        else if(numCounter == 0){
            conversion = new ConvertInstruction();
            instruction = (ArrayList<Instruction>) conversion.convertData(data);
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
            plateauSize = (PlateauSize) conversion.convertData(plateu);
            return conversion;
        }  else{
            throw new InputMismatchException();
        }
    }

    public String getPlateauCoordinates() {
        return plateauSize.getX() + " " + plateauSize.getY();
    }

    public PlateauSize getPlateauSize(){
        return plateauSize;
    }

    public ArrayList <Instruction> getInstruction() {
        return instruction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPlateauSize(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
