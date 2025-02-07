package user_controls;

import types.Instruction;
import types.PlateauSize;
import types.Position;

import static types.CompassDirection.*;
import static types.Instruction.*;

public class Rover {
    private Instruction instruction;
    private Position position;
    private Plateau plateau;
    private PlateauSize plateauSize;

    public Rover(Position position,PlateauSize size) {
        this.position = position;
        this.plateau = new Plateau();
        this.plateauSize = size;
    }

    public Position rotate(Instruction instruction) throws Exception {
        if(instruction.equals(L)){
            switch (position.getFacing()){
                case N -> position.setFacing(W);
                case W -> position.setFacing(S);
                case S -> position.setFacing(E);
                case E -> position.setFacing(N);
                default -> throw new Exception();
            }
        }

        else if(instruction.equals(R)){
            switch (position.getFacing()){
                case N -> position.setFacing(E);
                case W -> position.setFacing(N);
                case S -> position.setFacing(W);
                case E -> position.setFacing(S);
                default -> throw new Exception();
            }
        }
        else{
            throw new EnumConstantNotPresentException(Instruction.class,"Display Only L,R or M");
        }
        return position;
    }

    public Position move(Instruction instruction) throws Exception{
        if(instruction.equals(M)){
            switch (position.getFacing()){
                case N:
                    if(position.getY()+1 <= plateauSize.getY()){
                        position.setY(position.getY() + 1);
                    }
                    else{
                        throw new Exception("Outside the range of plateu");
                    }
                    break;
                case S:
                    if(position.getY()-1 >= 0){
                        position.setY(position.getY()-1);
                    }
                    else{
                        throw new Exception("Outside the range of plateu");
                    }
                    break;

                case E:
                    if(position.getX()+1 <= plateauSize.getX()){
                        position.setX(position.getX() + 1);
                    }
                    else{
                        throw new Exception("Outside the range of plateu");
                    }
                    break;
                case W:
                    if(position.getX()-1 >= 0){
                        position.setX(position.getX()-1);
                    }
                    else{
                        throw new Exception("Outside the range of plateu");
                    }
                    break;
                default :
                    throw new Exception();
            }
        }
        else{
            throw new EnumConstantNotPresentException(Instruction.class,"Display Only L,R or M");
        }
        return position;
    }


    public Position getPosition() {
        return position;
    }
}
