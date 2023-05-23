package window;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import listen.ButtonListenerOne;

public class ButtonPanelOne extends JPanel {
    static JButton[] numButtons;
    static JButton[] funButtonsOne;
    JButton clrButton;
    JButton pnButton;
    JButton pctButton;
    JButton divButton;
    JButton multButton;
    JButton subButton;
    JButton plusButton;
    JButton equButton;
    JButton nxtButton;

    public ButtonPanelOne() {
        super(new GridLayout(5, 4));
        this.setBounds(0, 100, 384, 462);
        numButtons = new JButton[11];
        funButtonsOne = new JButton[9];
        int index = 0;
        this.clrButton = new JButton("C");
        this.pnButton = new JButton("+/-");
        this.pctButton = new JButton("%");
        this.divButton = new JButton("÷");
        this.multButton = new JButton("×");
        this.subButton = new JButton("-");
        this.plusButton = new JButton("+");
        this.equButton = new JButton("=");
        this.nxtButton = new JButton("→");

        funButtonsOne[0] = this.clrButton;
        funButtonsOne[1] = this.pnButton;
        funButtonsOne[2] = this.pctButton;
        funButtonsOne[3] = this.divButton;
        funButtonsOne[4] = this.multButton;
        funButtonsOne[5] = this.subButton;
        funButtonsOne[6] = this.plusButton;
        funButtonsOne[7] = this.equButton;
        funButtonsOne[8] = this.nxtButton;

        for(int i = 0; i < numButtons.length - 1; ++i) {
            numButtons[i] = new JButton(Integer.toString(i));
        }

        numButtons[10] = new JButton(".");
        JButton[] var6 = numButtons;
        int var3 = var6.length;

        int var4;
        JButton i;
        for(var4 = 0; var4 < var3; ++var4) {
            i = var6[var4];
            i.setFont(new Font("arial", Font.BOLD, 25));
            i.setBackground(new Color(199, 196, 196));
            i.setBorder(new LineBorder(Color.BLACK, 1));
            i.addActionListener(new ButtonListenerOne());
        }

        var6 = funButtonsOne;
        var3 = var6.length;

        for(var4 = 0; var4 < var3; ++var4) {
            i = var6[var4];
            i.setFont(new Font("arial", Font.BOLD, 25));
            i.setBorder(new LineBorder(Color.BLACK, 1));
            i.addActionListener(new ButtonListenerOne());
            if (index > 2) {
                i.setBackground(new Color(255, 145, 0));
            } else {
                i.setBackground(new Color(134, 134, 134));
            }
            ++index;
        }

        this.add(clrButton);
        this.add(pnButton);
        this.add(pctButton);
        this.add(divButton);
        this.add(numButtons[7]);
        this.add(numButtons[8]);
        this.add(numButtons[9]);
        this.add(multButton);
        this.add(numButtons[4]);
        this.add(numButtons[5]);
        this.add(numButtons[6]);
        this.add(subButton);
        this.add(numButtons[1]);
        this.add(numButtons[2]);
        this.add(numButtons[3]);
        this.add(plusButton);
        this.add(numButtons[0]);
        this.add(numButtons[10]);
        this.add(equButton);
        this.add(nxtButton);
    }

    public static JButton[] getNumButtons() {
        return numButtons;
    }

    public static JButton[] getFunButtonsOne() {
        return funButtonsOne;
    }
}
