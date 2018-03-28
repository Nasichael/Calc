package engine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static engine.Operation.PLUS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTranslatorTest {

    private CalculationTranslator translator = new CalculationTranslator();

    @Test
    void shouldTranslateString() {
        //given
        List<String> toTranslate = new LinkedList<String>(Arrays.asList("5", "+", "2"));

        //when
        Calculation expectedCalculation = new Calculation(PLUS, 5, 2);
        Calculation testCalculation = translator.translate(toTranslate);

        //then
        assertEquals(expectedCalculation, testCalculation);
    }

}
