package parser;

import input_layer.ConvertInstruction;
import input_layer.ConvertPlateau;
import input_layer.ConvertPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void convertTypeDoesNotAcceptNullValues() {
        var actualResult = assertThrows(NullPointerException.class,() -> new InputParser().convertType(""));
        String expectedResult = null;
        assertEquals(expectedResult,actualResult.getMessage());
    }

    @Test
    @DisplayName("Checking to see if method will output exception on invalid value ")
    public void convertDataDoesNotTakeInvalidValue(){
        var expectedResult = InputMismatchException.class.getName();
        var actualResult = assertThrows(InputMismatchException.class,() -> new InputParser().convertType("X Y")).getClass().getName();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("Checking to see if method will return a conversion value of type Position")
    public void convertDataTakeReturnPosition(){
        var expectedResult = ConvertPosition.class.getName();
        var actualResult = new InputParser().convertType("1 2 N").getClass().getName();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("Checking to see if method will return a conversion value of type Instruction")
    public void convertDataReturnInstruction(){
        var expectedResult = ConvertInstruction.class.getName();
        var actualResult = new InputParser().convertType("LMLMLM").getClass().getName();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("Checking to see if method takes incorrect type")
    void convertPlateuInvalidatesData() {
        var actualResult = assertThrows(InputMismatchException.class,() -> new InputParser().convertPlateu("A B"));
        String expectedResult = null;
        assertEquals(expectedResult,actualResult.getMessage());
    }

    @Test
    void convertPlateuDoesNotAcceptNullValues() {
        var actualResult = assertThrows(NullPointerException.class,() -> new InputParser().convertPlateu(""));
        String expectedResult = null;
        assertEquals(expectedResult,actualResult.getMessage());
    }

    @Test
    @DisplayName("Checking to see if method will return a conversion value of type Position")
    public void convertPlateuReturnPlateu(){
        var expectedResult = ConvertPlateau.class.getName();
        var actualResult = new InputParser().convertPlateu("5 5").getClass().getName();
        assertEquals(expectedResult,actualResult);
    }






}