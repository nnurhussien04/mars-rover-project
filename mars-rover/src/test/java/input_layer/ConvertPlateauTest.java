package input_layer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import types.Instruction;
import types.PlateauSize;

import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertPlateauTest {

    @Test
@DisplayName("Checking if method will take empty values")
public void convertDataTakeEmptyValues(){
    var actualResult = assertThrows(NullPointerException.class,() -> new ConvertPlateau().convertData(""));
    String expectedResult = null;
    assertEquals(expectedResult,actualResult.getMessage());
    }

    @Test
    @DisplayName("Checking to see if method will return a list after given valid values")
    public void convertDataTakeValidValues(){
        var expectedResult = new PlateauSize(1,2);
        var actualResult = new ConvertPlateau().convertData("1,2");
        assertAll(
                () -> assertEquals(expectedResult.getX(),actualResult.getX()),
                () -> assertEquals(expectedResult.getY(),actualResult.getY())
        );
    }

    @Test
    @DisplayName("Checking to see if method will take the wrong type")
    public void convertDataTakesCorrectType(){
        var expectedResult = new InputMismatchException().getClass().getName();
        var actualResult = assertThrows(InputMismatchException.class,() -> new ConvertPlateau().convertData("!,-x")).getClass().getName();
        assertEquals(expectedResult,actualResult);
    }

}