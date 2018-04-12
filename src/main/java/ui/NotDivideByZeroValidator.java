package ui;

import ui.validation.Validator;

public class NotDivideByZeroValidator implements Validator {
    @Override
    public boolean checkInput(String text) {
        return false;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
