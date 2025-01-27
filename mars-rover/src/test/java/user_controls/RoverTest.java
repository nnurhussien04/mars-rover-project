package user_controls;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.InputParser;
import types.CompassDirection;
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
        var actualResult = new Rover(new Position(1,1,W)).rotate(L);
        assertAll(
            () -> assertEquals(expectedResult.getX(),actualResult.getX()),
            () -> assertEquals(expectedResult.getY(),actualResult.getY()),
            () -> assertEquals(expectedResult.getFacing(),actualResult.getFacing())
        );
    }


}