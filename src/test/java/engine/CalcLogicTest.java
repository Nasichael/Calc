package engine;

import org.junit.jupiter.api.Test;
import engine.Operation;
import static engine.CalcLogic.THE_SECOND_NUMBER_CAN_NOT_BE_ZERO;
import static org.junit.jupiter.api.Assertions.*;

class CalcLogicTest {

    CalcLogic calcLogic = new CalcLogic();


    @Test
    void shouldDivideTwoNumbers() {

        //given
        int num1 = 4;
        int num2 = 8;
        Operation operation1 = Operation.DIVIDE;

        //when
        final double result = calcLogic.calculate(num1, num2, operation1);

        //then
        assertEquals(0.5, result);
    }

    @Test
    void shouldPreventDividingByZero() {

        //given
        int num1 = 2;
        int num2 = 0;
        Operation operation5 = Operation.DIVIDE;

        //when
        try {
            final double result1 = calcLogic.calculate(num1, num2, operation5);
            fail("Exeption should be thrown");
        } catch (CalculateException e){
            //then
            assertEquals(THE_SECOND_NUMBER_CAN_NOT_BE_ZERO, e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void shouldAddTwoNumbers() {

        //given

        int num1 = 4;
        int num2 = 8;
        Operation operation2 = Operation.PLUS;

        //when

        final double result2 = calcLogic.calculate(num1, num2, operation2);

        //then
        assertEquals(12.0, result2);
    }

    @Test
    void shouldMultiplyTwoNumbers() {

        //given

        int num1 = 2;
        int num2 = 8;
        Operation operation3 = Operation.MULTIPLY;

        //when

        final double result3 = calcLogic.calculate(num1, num2, operation3);

        //then
        assertEquals(16.0, result3);
    }

    @Test
    void shouldSoubstractTwoNumbers() {

        //given
        int num1 = 4;
        int num2 = 8;
        Operation operation4 = Operation.MINUS;

        //when
        final double result4 = calcLogic.calculate(num1, num2, operation4);

        //then
        assertEquals(-4.0, result4);
    }

}