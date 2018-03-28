package engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class caluculateResultTest {

    CalcLogic logic = new CalcLogic();
    private CalculationElementsExtractor extractor = new CalculationElementsExtractor();
    private CalculationTranslator translator = new CalculationTranslator();

    @Test
    void shouldCalculate1() {

        //given
        String text = "1/2";
        //when
        double result = logic.calculate(translator.translate(extractor.extract(text)));
        //then
        assertEquals(0.5,result);
    }

    @Test
    void shouldCalculate2() {

        //given
        String text = "25-2";
        //when
        double result = logic.calculate(translator.translate(extractor.extract(text)));
        //then
        assertEquals(23.0,result);
    }
}
