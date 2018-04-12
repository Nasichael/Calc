package ui;


import engine.CalcLogic;
import engine.Calculation;
import engine.CalculationElementsExtractor;
import engine.CalculationTranslator;
import ui.validation.Validator;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {

    private JButton num9Button;
    private JButton num7Button;
    private JButton num3Button;
    private JButton num1Button;
    private JButton num2Button;
    private JButton num8Button;
    private JButton num4Button;
    private JButton num5Button;
    private JButton num6Button;
    private JTextField displayTextField;
    private JButton equalsButton;
    private JPanel mainPanel;
    private JButton num0Button;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton commaButton;
    private JButton clearButton;
    private JLabel infoLabel;

    private Map<JButton, String> buttonTexts = new HashMap<>();

    private void initButtonText() {
        buttonTexts.put(plusButton, "+");
        buttonTexts.put(minusButton, "-");
        buttonTexts.put(multiplyButton, "*");
        buttonTexts.put(divideButton, "/");
        buttonTexts.put(num1Button, "1");
        buttonTexts.put(num2Button, "2");
        buttonTexts.put(num3Button, "3");
        buttonTexts.put(num4Button, "4");
        buttonTexts.put(num5Button, "5");
        buttonTexts.put(num6Button, "6");
        buttonTexts.put(num7Button, "7");
        buttonTexts.put(num8Button, "8");
        buttonTexts.put(num9Button, "9");
        buttonTexts.put(num0Button, "0");
    }

    private CalculationElementsExtractor extractor = new CalculationElementsExtractor();
    private CalculationTranslator translator = new CalculationTranslator();
    CalcLogic logic = new CalcLogic();

    public Calculator() {
        setContentPane(mainPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.initButtonText();

        final BiConsumer<JButton, String> jButtonStringBiConsumer = (button, text) -> {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    displayTextField.setText(displayTextField.getText() + text);
                    infoLabel.setText("");
                }
            });
        };

        buttonTexts.forEach(jButtonStringBiConsumer);

        clearButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {//bindowanie
                final String text = displayTextField.getText();
                if (!text.isEmpty()) {
                    displayTextField.setText(text.substring(0, text.length() - 1));
                }
            }
        });

        equalsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (validateActions()) {
                    final double calculateresult = calculateResult();
                    displayTextField.setText(calculateresult + "");
                } else {
                    infoLabel.setText("your expression is not valid");
                }
            }

        });
        setResizable(false);
    }

    Set<Validator> validadorSet = new HashSet<>();

    private final Validator notDivideByZeroValidator = new NotDivideByZeroValidator();

    private final Validator correctMathEquationValidator = new CorrectMathEquationValidator();

    {
        validadorSet.add(notDivideByZeroValidator);
        validadorSet.add(correctMathEquationValidator);
    }
    private double calculateResult() {

        final String text = displayTextField.getText();
        List<String> userInput = extractor.extract(text);
        final Calculation calculation = translator.translate(userInput);
        return logic.calculate(calculation);
    }

    private boolean validateActions() {
        final String text = displayTextField.getText();


        for (Validator validator : validadorSet) {
            if (!validator.checkInput(text)) {
                infoLabel.setText(validator.getErrorMessage());
            }
        }

        Pattern p = Pattern.compile("(\\d+[-+/*]\\d+)+");
        Matcher m = p.matcher(text);
        return m.matches();
    }

    public static void main(String[] args) {
        new Calculator();

    }
}
