package user_controls;

import input_layer.Conversion;
import input_layer.ConvertInstruction;
import input_layer.ConvertPosition;
import types.CompassDirection;
import types.Instruction;
import types.PlateauSize;
import types.Position;

import java.util.ArrayList;

import static types.CompassDirection.*;

public class Plateau {
    private PlateauSize plateauSize;
    private Conversion conversion;

    public Plateau() {
        plateauSize = new PlateauSize();
    }

    public Boolean plateuCheck(PlateauSize plateauSize, Position position){
        if(position.getFacing() == CompassDirection.W || position.getFacing() == CompassDirection.E) {
            if (position.getX() > plateauSize.getX() || position.getX() < 0) {
                return false;
            }
        }
        else{
            if (position.getY() > plateauSize.getY() || position.getY() < 0) {
                return false;
            }
        }
        return true;
    }


}
