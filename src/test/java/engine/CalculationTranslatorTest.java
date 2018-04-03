package engine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static engine.Operation.MULTIPLY;
import static engine.Operation.PLUS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTranslatorTest {

    private CalculationTranslator translator = new CalculationTranslator();

    @Test
    void shouldTranslateString1() {
        //given
        List<String> toTranslate = new LinkedList<>(Arrays.asList("5", "+", "2"));

        //when
        Calculation testCalculation = translator.translate(toTranslate);

        //then
        Calculation expectedCalculation = new Calculation(PLUS, 5, 2);
        assertEquals(expectedCalculation, testCalculation);
    }

    @Test
    void shouldTranslateString2() {

        //given
        List<String> toTranslate = new LinkedList<>(Arrays.asList("7", "*", "3"));

        //when
        Calculation testCalculation = translator.translate(toTranslate);

        //then
        Calculation expectedCalculation = new Calculation(MULTIPLY, 7, 3);
        assertEquals(expectedCalculation, testCalculation);
    }
}
