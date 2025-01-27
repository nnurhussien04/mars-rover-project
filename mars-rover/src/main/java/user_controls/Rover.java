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

    public Rover(Position position) {
        this.position = position;
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
                case N -> position.setY(position.getY()+1);
                case S -> position.setY(position.getY()-1);
                case E -> position.setX(position.getX()+1);
                case W -> position.setX(position.getX()-1);
                default -> throw new Exception();
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
