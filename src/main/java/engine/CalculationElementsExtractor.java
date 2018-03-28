package engine;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationElementsExtractor {

    private static final Pattern CALC_PATTERN = Pattern.compile("(\\d+)|[-*\\+/]");

    public static List<String> extract(String text) {
        List<String> userInput = new LinkedList<>();
        Matcher m = CALC_PATTERN.matcher(text);

        while (m.find()) {
            userInput.add(m.group());
        }
        return userInput;
    }

}
