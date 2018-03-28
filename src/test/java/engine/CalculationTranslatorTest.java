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
        Calculation expectedCalculation = new Calculation(PLUS, 5, 2);
        Calculation testCalculation = translator.translate(toTranslate);

        //then
        assertEquals(expectedCalculation, testCalculation);
    }

    @Test
    void shouldTranslateString2() {

        //given
        List<String> toTranslate = new LinkedList<>(Arrays.asList("7", "*", "3"));

        //when
        Calculation expectedCalculation = new Calculation(MULTIPLY, 7, 3);
        Calculation testCalculation = translator.translate(toTranslate);

        //then
        assertEquals(expectedCalculation, testCalculation);
    }
}
