package window;

import listen.ButtonListenerOne;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    private final JPanel panel = new JPanel();
    private static Frame instance;
    public Frame() {
        super("Calculator");
        instance = this;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        panel.setBounds(0,100,400,500);
        panel.setLayout(new CardLayout());
        this.add(panel, BorderLayout.CENTER);

        panel.add(new ButtonPanelOne(), "panel 1");
        panel.add(new ButtonPanelTwo(), "panel 2");
        new ButtonListenerOne();


        TextPanel.init();
        this.add(TextPanel.getTextField());
        this.setVisible(true);
    }
    public JPanel getPanel() {
        return panel;
    }

    public void showPanelOne() {
        ((CardLayout)panel.getLayout()).show(panel, "panel 1");
    }

    public static Frame getInstance() {
        return instance;
    }
}
