package input_layer;

import types.PlateauSize;

import java.util.InputMismatchException;

public class ConvertPlateau implements Conversion <PlateauSize> {
    private PlateauSize size;

    @Override
    public PlateauSize convertData(String userInput) {
        if(userInput == null|| userInput.isEmpty()){
            throw new NullPointerException();
        }
        if(userInput.chars().filter(Character::isLetter).count() > 0){
            throw new InputMismatchException();
        }
        userInput = userInput.replaceAll("[^\\d]+","");
        size = new PlateauSize(Integer.parseInt(String.valueOf(userInput.charAt(0))),Integer.parseInt(String.valueOf(userInput.charAt(1))));
        return size;
    }

    @Override
    public PlateauSize getData() {
        return size;
    }

    @Override
    public void setData(PlateauSize userData) {
        size = userData;
    }
}
