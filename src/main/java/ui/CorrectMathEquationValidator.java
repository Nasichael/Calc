package ui;

import ui.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectMathEquationValidator implements Validator {
    @Override
    public boolean checkInput(String text) {
       return false;

    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
