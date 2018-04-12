package ui.validation;

import org.junit.jupiter.api.Test;
import ui.NotDivideByZeroValidator;

import static org.junit.jupiter.api.Assertions.*;

class NotDivideByZeroValidatorTest {
    @Test
    void shouldPreventDividingByZero1() {

        //given
        String testText = "12/0";
        //when
        NotDivideByZeroValidator notDivideByZeroValidator = new NotDivideByZeroValidator();
        boolean result = notDivideByZeroValidator.checkInput(testText);
        //then
        assertEquals(false, result);
    }


    @Test
    void shouldPreventDividingByZero2() {
        //given
        String testText = "12/3";
        //when
        NotDivideByZeroValidator notDivideByZeroValidator = new NotDivideByZeroValidator();
        boolean result = notDivideByZeroValidator.checkInput(testText);
        //then
        assertEquals(true, result);
    }
}

