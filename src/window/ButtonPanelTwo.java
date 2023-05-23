package window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import listen.ButtonListenerOne;
import listen.ButtonListenerTwo;

public class ButtonPanelTwo extends JPanel {
    static JButton[] funButtonsTwo;

    JButton cosButton;
    JButton sinButton;
    JButton tanButton;
    JButton inCosButton;
    JButton inSinButton;
    JButton inTanButton;
    JButton logxButton;
    JButton logButton;
    JButton lnButton;
    JButton sqrtButton;
    JButton rootButton;
    JButton oParButton;
    JButton cParButton;
    JButton prevButton;

    public ButtonPanelTwo() {
        super(new GridLayout(5, 4));
        this.setBounds(0, 100, 384, 462);
        funButtonsTwo = new JButton[14];

        this.cosButton = new JButton("cos");
        this.sinButton = new JButton("sin");
        this.tanButton = new JButton("tan");
        this.inCosButton = new JButton("cos -1");
        this.inSinButton = new JButton("sin -1");
        this.inTanButton = new JButton("tan -1");
        this.logxButton = new JButton("logx");
        this.logButton = new JButton("log");
        this.lnButton = new JButton("ln");
        this.sqrtButton = new JButton("√");
        this.rootButton = new JButton("x√");
        this.oParButton = new JButton("(");
        this.cParButton = new JButton(")");
        this.prevButton = new JButton("←");

        funButtonsTwo[0] = this.cosButton;
        funButtonsTwo[1] = this.sinButton;
        funButtonsTwo[2] = this.tanButton;
        funButtonsTwo[3] = this.inCosButton;
        funButtonsTwo[4] = this.inSinButton;
        funButtonsTwo[5] = this.inTanButton;
        funButtonsTwo[6] = this.logxButton;
        funButtonsTwo[7] = this.logButton;
        funButtonsTwo[8] = this.lnButton;
        funButtonsTwo[9] = this.sqrtButton;
        funButtonsTwo[10] = this.rootButton;
        funButtonsTwo[11] = this.oParButton;
        funButtonsTwo[12] = this.cParButton;
        funButtonsTwo[13] = this.prevButton;

        for (JButton i : funButtonsTwo) {
            i = new JButton();
            i.setFont(new Font("arial", Font.BOLD, 25));
            i.setBorder(new LineBorder(Color.BLACK, 1));
            i.addActionListener(new ButtonListenerTwo());
            i.setBackground(new Color(255, 145, 0));
        }

        this.add(cosButton);
        this.add(sinButton);
        this.add(tanButton);
        this.add(inCosButton);
        this.add(inSinButton);
        this.add(inTanButton);
        this.add(logxButton);
        this.add(logButton);
        this.add(lnButton);
        this.add(sqrtButton);
        this.add(rootButton);
        this.add(oParButton);
        this.add(cParButton);
        this.add(prevButton);
    }

    public static JButton[] getFunButtonsTwo() {
        return funButtonsTwo;
    }
}