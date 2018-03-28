package engine;

import java.io.Serializable;

public class Calculation implements Serializable {
    private Operation operation;
    private int number1;
    private int number2;

    public Calculation() {
    }

    public Calculation(Operation operation, int number1, int number2) {
        this.operation = operation;
        this.number1 = number1;
        this.number2 = number2;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }
}