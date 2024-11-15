package input_layer;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import input_layer.*;
import types.Instruction;

import java.util.InputMismatchException;
import java.util.List;

import types.*;

import static org.junit.jupiter.api.Assertions.*;

class ConvertInstructionTest {

    @Test
    @DisplayName("Checking if method will take empty values")
    public void convertDataTakeEmptyValues(){
        var actualResult = assertThrows(NullPointerException.class,() -> new ConvertInstruction().convertData(""));
        String expectedResult = null;
        assertEquals(expectedResult,actualResult.getMessage());
    }

    @Test
    @DisplayName("Checking to see if method will return exception on invalid values ")
    public void convertDataTakeInvalidValue(){
        var expectedResult = new InputMismatchException().getClass().getName();
        var actualResult = assertThrows(InputMismatchException.class,() -> new ConvertInstruction().convertData("!,-x")).getClass().getName();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("Checking to see if method will return a list after given valid values")
    public void convertDataTakeValidValues(){
        var expectedResult = List.of(Instruction.R,Instruction.M);
        var actualResult = new ConvertInstruction().convertData("RM");
        assertEquals(expectedResult,actualResult);
    }







}