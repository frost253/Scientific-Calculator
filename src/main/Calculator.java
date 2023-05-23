package main;

import listen.ButtonListenerOne;
import window.ButtonPanelOne;
import window.ButtonPanelTwo;
import window.TextPanel;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    private final String title = "Calculator";
    private final int width = 400;
    private final int height = 600;
    private final JFrame frame;
    private final JPanel buttonPanelContainer;
    private final TextPanel textPanel;

    private static Calculator instance;

    Calculator() {
        instance = this;

        buttonPanelContainer = new JPanel();
        buttonPanelContainer.setBounds(0, 100, 400, 500);
        buttonPanelContainer.setLayout(new CardLayout());
        buttonPanelContainer.add(new ButtonPanelOne(), "panel 1");
        buttonPanelContainer.add(new ButtonPanelTwo(), "panel 2");

        textPanel = new TextPanel();

        new ButtonListenerOne();

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        frame.add(textPanel.getTextField());
        frame.add(buttonPanelContainer, BorderLayout.CENTER);
        frame.setVisible(true);

        showPanelOne();
    }

    public static JPanel getButtonPanelContainer() {
        return instance.buttonPanelContainer;
    }

    public Calculator getInstance() {
        return instance;
    }

    public void showPanelOne() {
        ((CardLayout) buttonPanelContainer.getLayout()).show(buttonPanelContainer, "panel 1");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
