package input_layer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import types.CompassDirection;
import types.Instruction;
import types.Position;

import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertPositionTest {
    @Test
    @DisplayName("Checking if method will take empty values")
    public void convertDataTakeEmptyValues(){
        var actualResult = assertThrows(NullPointerException.class,() -> new ConvertPosition().convertData(""));
        String expectedResult = null;
        assertEquals(expectedResult,actualResult.getMessage());
    }

    @Test
    @DisplayName("Checking to see if method will return exception on invalid value ")
    public void convertDataTakeInvalidValue(){
        var expectedResult = new InputMismatchException().getClass().getName();
        var actualResult = assertThrows(InputMismatchException.class,() -> new ConvertPosition().convertData("1 2 Y")).getClass().getName();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("Checking to see if method will return exception on invalid value ")
    public void convertDataTakeCorrectType(){
        var expectedResult = new InputMismatchException().getClass().getName();
        var actualResult = assertThrows(InputMismatchException.class,() -> new ConvertPosition().convertData("-x,/;a")).getClass().getName();
        assertEquals(expectedResult,actualResult);
    }



    @Test
    @DisplayName("Checking to see if method will return a list after given valid values")
    public void convertDataTakeValidValues(){
        var expectedResult = new Position(1,2, CompassDirection.N).getX();
        var expectedResult2 = new Position(1,2, CompassDirection.N).getY();
        var expectedResult3 = new Position(1,2, CompassDirection.N).getFacing();
        var actualResult = new ConvertPosition().convertData("1 2 N");
        assertAll(
                () -> assertEquals(expectedResult,actualResult.getX()),
                () -> assertEquals(expectedResult2,actualResult.getY()),
                () -> assertEquals(expectedResult3,actualResult.getFacing())
        );
    }


}