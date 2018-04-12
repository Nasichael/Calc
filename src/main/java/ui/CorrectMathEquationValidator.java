package ui;

import ui.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectMathEquationValidator implements Validator {

    public static final String INVALID_EQUATION = "INVALID FORMAT EQUATION!";

    @Override
    public boolean checkInput(String text) {
        Pattern p = Pattern.compile("(\\d+[-+/*]\\d+)+");
        Matcher m = p.matcher(text);
        return m.matches();
    }

    @Override
    public String getErrorMessage() {
        return INVALID_EQUATION;
    }
}
