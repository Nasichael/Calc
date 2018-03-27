package engine;

import java.util.List;

public class CalculationTranslator {

    public Calculation translate(List<String> userInput) {

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

        return calculation;
    }
}
