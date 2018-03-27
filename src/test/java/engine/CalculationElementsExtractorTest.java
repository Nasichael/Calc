package engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationElementsExtractorTest {
    private CalculationElementsExtractor extractor = new CalculationElementsExtractor();

    // 1 a 1 b
    //2

    @Test
    public void shouldExtractValidString()
    {
        //given
        String toCheck="";

        //when
        extractor.extract(toCheck);

        //then

    }
}