package engine;

import java.util.function.DoubleBinaryOperator;

public class CalcLogic {


    public double calculate(int a, int b, Operation enumOperation) {

        final double binaryOperator = enumOperation.applyAsDouble(a,b);
        return binaryOperator;

    }
    public double calculate(Calculation calculation) {   //????
        return calculate(calculation.getNumber1(), calculation.getNumber2(), calculation.getOperation());
    }
}
