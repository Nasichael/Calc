package engine;

import java.util.function.DoubleBinaryOperator;

import engine.*;

public enum Operation {

    PLUS(Double::sum),
    MINUS((number1, number2) -> number1 - number2),
    MULTIPLY((number1, number2) -> number1 * number2),
    DIVIDE((number1, number2) -> {
        if (number2 != 0) {
            return (number1 / number2);
        } else {
            throw new CalculateException(Constants.THE_SECOND_NUMBER_CAN_NOT_BE_ZERO);
        }
    });

    private final DoubleBinaryOperator binaryOperator;

    Operation(final DoubleBinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    public double applyAsDouble(final double left, final double right) {
        return binaryOperator.applyAsDouble(left, right);
    }

    public static class Constants {
        public static final String THE_SECOND_NUMBER_CAN_NOT_BE_ZERO = "THE_SECOND_NUMBER_CAN_NOT_BE_ZERO";
    }//czy powinno byc w tym miejscu?
}


