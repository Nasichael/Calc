package ui.validation;

import org.junit.jupiter.api.Test;
import ui.CorrectMathEquationValidator;
import static org.junit.jupiter.api.Assertions.*;

class CorrectMathEquationValidatorTest {

    @Test
    void shouldCheckMathEquation1() {

        //given
        String testText = "1/0+";
        //when
        CorrectMathEquationValidator mathEquationValidator = new CorrectMathEquationValidator();
        boolean result = mathEquationValidator.checkInput(testText);
        //then
        assertEquals(false, result);
    }

       @Test
    void shouldCheckMathEquation2() {

        //given
        String testText = "2+*9";
        //when
        CorrectMathEquationValidator mathEquationValidator = new CorrectMathEquationValidator();
        boolean result = mathEquationValidator.checkInput(testText);
        //then
        assertEquals(false, result);
    }

    @Test
    void shouldCheckMathEquation3() {

        //given
        String testText = "2+9";
        //when
        CorrectMathEquationValidator mathEquationValidator = new CorrectMathEquationValidator();
        boolean result = mathEquationValidator.checkInput(testText);
        //then
        assertEquals(true, result);
    }
}