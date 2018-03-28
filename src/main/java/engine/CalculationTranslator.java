package engine;

import java.util.List;

public class CalculationTranslator {

    public Calculation translate(List<String> userInput) {

        final int number1 = Integer.parseInt(userInput.get(0));
        final int number2 = Integer.parseInt(userInput.get(2));
        final String operationString = userInput.get(1);

        Operation op = null;

        if (operationString.equals("/")) {
            op = Operation.DIVIDE;
        } else if (operationString.equals("+")) {
            op = Operation.PLUS;
        } else if (operationString.equals("-")) {
            op = Operation.MINUS;
        } else if (operationString.equals("*")) {
            op = Operation.MULTIPLY;
        }

        // calculation.setOperation(op);
        final Calculation calculation = new Calculation(op, number1, number2);
        return calculation;
    }
}
