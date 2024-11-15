package input_layer;
import types.*;

import java.util.InputMismatchException;

public class ConvertPosition implements Conversion {
    public Position position;

    @Override
    public Position convertData(String userInput) {
        if(userInput == null|| userInput.isEmpty()){
            throw new NullPointerException();
        }
        userInput = userInput.replaceAll("[^\\w\\d]+","");
        if(userInput.chars().filter(Character::isLetterOrDigit).count() != 3){
            throw new InputMismatchException();
        }
        CompassDirection direction = null;
        switch (userInput.charAt(2)){
            case 'N':
                direction = CompassDirection.N;
                break;
            case 'E':
                direction = CompassDirection.E;
                break;
            case 'W':
                direction = CompassDirection.W;
                break;
            case 'S':
                direction = CompassDirection.S;
                break;
            default:
                throw new InputMismatchException();
        }

        position = new Position(Integer.parseInt(String.valueOf(userInput.charAt(0))),Integer.parseInt(String.valueOf(userInput.charAt(1))),direction);
        return position;
    }

}
