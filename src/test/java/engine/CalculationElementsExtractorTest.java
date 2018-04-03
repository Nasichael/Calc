package engine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static engine.Operation.PLUS;
import static org.junit.jupiter.api.Assertions.*;

class CalculationElementsExtractorTest {

    private CalculationElementsExtractor extractor = new CalculationElementsExtractor();

    //should we test a not valid string? If the string is not valid it will
//never reach this method????

    @Test
    public void shouldExtractValidString1() {

        //given
        String toCheck = "1+1";

        //when
        final List<String> result = extractor.extract(toCheck);
        List<String> expectedList = new LinkedList<>(Arrays.asList("1", "+", "1"));

        //then
        assertEquals(expectedList, result);
    }

    @Test
    public void shouldExtractValidString2() {

        //given
        String toCheck = "5*20";

        //when
        final List<String> result = extractor.extract(toCheck);
        final List<String> expectedList = new LinkedList<>(Arrays.asList("5","*","20"));

        //then
        assertEquals(expectedList, result);
    }
}


