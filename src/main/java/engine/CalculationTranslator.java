package engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculationTranslator {

    Map<String, Operation> symbolToOperation = new HashMap<>();

    void initSymbolToOperation() {
        symbolToOperation.put("/", Operation.DIVIDE);
        symbolToOperation.put("*", Operation.MULTIPLY);
        symbolToOperation.put("+", Operation.PLUS);
        symbolToOperation.put("-", Operation.MINUS);
    }

   public CalculationTranslator() {
        initSymbolToOperation();
    }

    public Calculation translate(List<String> userInput) {

        final int number1 = Integer.parseInt(userInput.get(0));
        final int number2 = Integer.parseInt(userInput.get(2));
        final String operationString = userInput.get(1);

        final Operation operation = symbolToOperation.get(operationString);
        final Calculation calculation = new Calculation(operation, number1, number2);
        return calculation;
    }
}
