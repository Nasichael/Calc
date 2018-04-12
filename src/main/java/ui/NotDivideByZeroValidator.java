package ui;

import ui.validation.Validator;

public class NotDivideByZeroValidator implements Validator {

    public static final String IMPOSSIBLE_TO_DIVIDE_BY_ZERO = "IMPOSSIBLE TO DIVIDE BY ZERO!";

    @Override
    public boolean checkInput(String text) {
        int textLength = text.length();
        if ((text.charAt(textLength-1)=='0')&&(text.charAt(textLength-2)=='/'))
            return false;
        else
            return true;
    }

    @Override
    public String getErrorMessage() {
        return IMPOSSIBLE_TO_DIVIDE_BY_ZERO;
    }
}
