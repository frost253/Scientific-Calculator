package listen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.Calculator;
import org.jetbrains.annotations.NotNull;
import window.*;

public class ButtonListenerOne extends TextPanel implements ActionListener {
    public JButton[] fb1 = ButtonPanelOne.getFunButtonsOne();

    public void actionPerformed(@NotNull ActionEvent e) {
        JButton[] nb = ButtonPanelOne.getNumButtons();
        for(int i = 0; i < nb.length - 1; ++i) {
            if (e.getSource() == nb[i]) {
                TextPanel.setText(TextPanel.getText().concat(String.valueOf(i)));
            }
        }

        // decimal
        if (e.getSource() == nb[10]) {
            if(!(TextPanel.getText().contains(".")))
                TextPanel.setText(TextPanel.getText().concat("."));
        }

        // clear
        if (e.getSource() == this.fb1[0]) {
            TextPanel.setText("");
        }

        // positive / negative
        if (e.getSource() == this.fb1[1]) {
            TextPanel.setText(String.valueOf(-1 * Integer.parseInt(TextPanel.getText())));
        }

        // percent
        if (e.getSource() == this.fb1[2]) {
            TextPanel.setText(String.valueOf(0.01 * Integer.parseInt(TextPanel.getText())));
        }

        // division
        if (e.getSource() == this.fb1[3]) {
            TextPanel.setText(TextPanel.getText().concat(" / "));
        }

        // multiplication
        if (e.getSource() == this.fb1[4]) {
            TextPanel.setText(TextPanel.getText().concat(" * "));
        }

        // subtraction
        if (e.getSource() == this.fb1[5]) {
            TextPanel.setText(TextPanel.getText().concat(" - "));
        }

        // addition
        if (e.getSource() == this.fb1[6]) {
            TextPanel.setText(TextPanel.getText().concat(" + "));
        }

        // equals
        if (e.getSource() == this.fb1[7]) {
            TextPanel.setText(String.valueOf((eval(TextPanel.getText()))));
        }

        // next
        if (e.getSource() == this.fb1[8]) {
//            JPanel framePanel = Frame.getInstance().getPanel();
            JPanel framePanel = Calculator.getButtonPanelContainer();
            ((CardLayout) (framePanel.getLayout())).show(framePanel, "panel 2");
        }
        

    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    x = switch (func) {
                        case "sqrt" -> Math.sqrt(x);
                        case "sin" -> Math.sin(Math.toRadians(x));
                        case "cos" -> Math.cos(Math.toRadians(x));
                        case "tan" -> Math.tan(Math.toRadians(x));
                        default -> throw new RuntimeException("Unknown function: " + func);
                    };
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
