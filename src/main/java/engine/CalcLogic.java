package engine;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static engine.Operation.*;

public class CalcLogic {


    public static final String THE_SECOND_NUMBER_CAN_NOT_BE_ZERO = "The second number can not be zero";
   private Map<Operation, BiFunction<Integer, Integer, Double>> functionsForOperations = new HashMap<>();

    public CalcLogic() {
        functionsForOperations.put(Operation.PLUS, (number1, number2) -> (double) (number1 + number2));
        functionsForOperations.put(Operation.MINUS, (number1, number2) -> (double) (number1 - number2));
        functionsForOperations.put(Operation.MULTIPLY, (number1, number2) -> (double) (number1 * number2));
        functionsForOperations.put(Operation.DIVIDE, (number1, number2) -> {
            if (number2 != 0) {
                return ((double) number1 / (double) number2);
            } else {
                throw new CalculateException(THE_SECOND_NUMBER_CAN_NOT_BE_ZERO);
            }
        });


    }

    public double calculate(int number1, int number2, Operation operation) {

      /*  if (operation == PLUS) {
            return (number1 + number2);
        } else if (operation == MINUS) {
            return (number1 - number2);
        } else if (operation == MULTIPLY) {
            return (number1 * number2);
        } else if (operation == DIVIDE) {
            if (number2 != 0) {
                return ((double) number1 / (double) number2);
            } else {
                throw new CalculateException(THE_SECOND_NUMBER_CAN_NOT_BE_ZERO);
            }
        }*/
        if(functionsForOperations.containsKey(operation))
        {
            final BiFunction<Integer, Integer, Double> function = functionsForOperations.get(operation);
            final Double result = function.apply(number1, number2);
            return result;
        }
        else{
            throw new IllegalStateException("No such an operation");
        }
    }

    //TODO implement
    public double calculate(Calculation calculation) {
        return calculate(calculation.getNumber1(), calculation.getNumber2(), calculation.getOperation());
    }
}



