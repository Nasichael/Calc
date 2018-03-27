package ui;

import engine.Operation;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {
    private static final Pattern CALC_PATTERN = Pattern.compile("(\\d+)|[-*\\+/]");

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


    Calculator() {
        setContentPane(mainPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        clearButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                final String text = displayTextField.getText();
                if (!text.isEmpty()) {
                    displayTextField.setText(text.substring(0, text.length() - 1));
                }
            }
        });

        num0Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 0);
            }
        });

        num1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 1);
            }
        });

        num2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 2);
            }
        });

        num3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 3);
            }
        });

        num4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 4);
            }
        });

        num5Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 5);
            }
        });

        num6Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 6);
            }
        });

        num7Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 7);
            }
        });

        num8Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 8);
            }
        });

        num9Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + 9);
            }
        });

        plusButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + "+");
            }
        });

        minusButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + "-");
            }
        });

        multiplyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + "*");
            }
        });

        divideButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTextField.setText(displayTextField.getText() + "/");
            }
        });

        equalsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (validateActions()) {
                    final double calculateresult = calculateresult();
                    displayTextField.setText(calculateresult + "");
                } else {
                    infoLabel.setText("your expression is not valid");
                }
            }

        });
        setResizable(false);
    }



    private double calculateresult() {

        final String text = displayTextField.getText();
        System.out.println(text);


        List<String> userInput = new LinkedList<>();
        Matcher m = CALC_PATTERN.matcher(text);

        while (m.find()) {
            userInput.add(m.group());
        }
        final Calculation calculation = new Calculation();
        calculation.setNumber1(Integer.parseInt(userInput.get(0)));
        System.out.println(calculation.getNumber1());
        calculation.setNumber2(Integer.parseInt(userInput.get(2)));
        System.out.println(calculation.getNumber2());
        calculation.setOperation(userInput.get(1));
        System.out.println(calculation.getOperation());


        if (calculation.getOperation().equals("/")) {
            Operation op = Operation.DIVIDE;
            System.out.println(op);
        } else if (calculation.getOperation().equals("+")) {
            Operation op = Operation.PLUS;
            System.out.println(op);
        } else if (calculation.getOperation().equals("-")) {
            Operation op = Operation.MINUS;
            System.out.println(op);
        } else if (calculation.getOperation().equals("*")) {
            Operation op = Operation.MULTIPLY;
            System.out.println(op);
        }

        return 440;
    }


    private boolean validateActions() {
        Pattern p = Pattern.compile("(\\d+[-+/*]\\d+)+");
        final String text = displayTextField.getText();
        Matcher m = p.matcher(text);
        return m.matches();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.validateActions();


    }


}
