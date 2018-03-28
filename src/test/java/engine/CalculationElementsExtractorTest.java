package engine;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static engine.Operation.PLUS;
import static org.junit.jupiter.api.Assertions.*;

class CalculationElementsExtractorTest {
    private CalculationElementsExtractor extractor = new CalculationElementsExtractor();

    // 1 a 1 b
    //2

    @Test
    public void shouldExtractValidString1() {

        //given
        String toCheck = "1+1";

        //when
        final List<String> result = extractor.extract(toCheck);

        //then
        List<String> expectedList = new LinkedList<>();
        expectedList.add("1");
        expectedList.add("+");
        expectedList.add("1");

        assertEquals(expectedList, result);

    }

    @Test
    public void shouldExtractValidString2() {


        //given
        String toCheck = "5*20";

        //when
        final List<String> result = extractor.extract(toCheck);

        //then
        List<String> expectedList = new LinkedList<>();
        expectedList.add("5");
        expectedList.add("*");
        expectedList.add("20");

        assertEquals(expectedList, result);

    }
}

//should we test a not valid string? If the string is not valid it will
//never reach this method????
