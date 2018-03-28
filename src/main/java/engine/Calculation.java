package engine;

import java.io.Serializable;

public class Calculation implements Serializable {
    private Operation operation;
    private int number1;
    private int number2;

    public Calculation() {
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "operation=" + operation +
                ", number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculation that = (Calculation) o;

        if (getNumber1() != that.getNumber1()) return false;
        if (getNumber2() != that.getNumber2()) return false;
        return getOperation() == that.getOperation();
    }

    @Override
    public int hashCode() {
        int result = getOperation() != null ? getOperation().hashCode() : 0;
        result = 31 * result + getNumber1();
        result = 31 * result + getNumber2();
        return result;
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