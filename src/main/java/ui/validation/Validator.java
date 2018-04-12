package ui.validation;

public interface Validator {


    boolean checkInput(String text);

    String getErrorMessage();
}
