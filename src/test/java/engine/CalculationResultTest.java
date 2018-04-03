package engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationResultTest {

    CalcLogic logic = new CalcLogic();
    private CalculationElementsExtractor extractor = new CalculationElementsExtractor();
    private CalculationTranslator translator = new CalculationTranslator();

    @Test
    void shouldCalculateDivision() {

        //given
        String text = "1/2";
        //when
        double result = logic.calculate(translator.translate(extractor.extract(text)));
        //then
        assertEquals(0.5,result);
    }

    @Test
    void shouldCalculateSubstraction() {

        //given
        String text = "25-2";
        //when
        double result = logic.calculate(translator.translate(extractor.extract(text)));
        //then
        assertEquals(23.0,result);
    }
}
