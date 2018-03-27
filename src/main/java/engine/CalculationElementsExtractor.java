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

    public void translate(List<String> userInput) {
        final Calculation calculation = new Calculation();
        calculation.setNumber1(Integer.parseInt(userInput.get(0)));
        System.out.println(calculation.getNumber1());
        calculation.setNumber2(Integer.parseInt(userInput.get(2)));
        System.out.println(calculation.getNumber2());
        calculation.setOperation(userInput.get(1));
        System.out.println(calculation.getOperation());


        if (calculation.getOperation().equals("/")) {
            Operation op = Operation.DIVIDE;
            System.out.println(op);
        } else if (calculation.getOperation().equals("+")) {
            Operation op = Operation.PLUS;
            System.out.println(op);
        } else if (calculation.getOperation().equals("-")) {
            Operation op = Operation.MINUS;
            System.out.println(op);
        } else if (calculation.getOperation().equals("*")) {
            Operation op = Operation.MULTIPLY;
            System.out.println(op);
        }
    }
}
