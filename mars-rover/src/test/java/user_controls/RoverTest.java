package user_controls;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.InputParser;
import types.CompassDirection;
import types.PlateauSize;
import types.Position;

import java.util.InputMismatchException;


import static org.junit.jupiter.api.Assertions.*;
import static types.CompassDirection.*;
import static types.Instruction.*;

class RoverTest {

    @Test
    @DisplayName("Check if method returns correct position")
    void testIfRotateReturnsRoverPosition() throws Exception {
        var expectedResult = new Position(1,1,S);
        var actualResult = new Rover(new Position(1,1,W),new PlateauSize(5,5)).rotate(L);
        assertAll(
            () -> assertEquals(expectedResult.getX(),actualResult.getX()),
            () -> assertEquals(expectedResult.getY(),actualResult.getY()),
            () -> assertEquals(expectedResult.getFacing(),actualResult.getFacing())
        );
    }

    @Test
    @DisplayName("Check if method handles value outside the type")
    void testIfRotateAllowValuesOutsideType() throws Exception {
        var expectedResult = new Position(1,1,S);
        var actualResult = new Rover(new Position(1,1,W),new PlateauSize(2,2));
        assertThrows(Exception.class,() -> actualResult.rotate(M));
    }

    @Test
    @DisplayName("Check if method handles value outside the type")
    void testIfRotateAllowNullValues() throws Exception {
        var expectedResult = new Position(1,1,S);
        var actualResult = new Rover(new Position(1,1,W),new PlateauSize(2,2));
        assertThrows(Exception.class,() -> actualResult.rotate(null));
    }

    @Test
    @DisplayName("Testing to see if rover moves spaces and return new position")
    void testIfMoveReturnsRoverNewPositon() throws Exception{
        var expectedResult = new Position(1,2,W);
        var actualResult = new Rover(new Position(2,2,W),new PlateauSize(3,3)).move(M);
        assertAll(
                () -> assertEquals(expectedResult.getX(),actualResult.getX()),
                () -> assertEquals(expectedResult.getY(),actualResult.getY()),
                () -> assertEquals(expectedResult.getFacing(),expectedResult.getFacing())
        );
    }

    @Test
    @DisplayName("Testing to see if rover allow null values")
    void testIfMoveAllowsNullValue() throws Exception{
        var expectedResult = Exception.class;
        var actualResult = new Rover(new Position(2,2,W),new PlateauSize(3,3));
        assertThrows(expectedResult,() -> actualResult.move(null));
    }






}