package window;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel {
    private final int width = 400;
    private final int height = 100;

    private JPanel panel;
    private static JTextField textField;

    public TextPanel() {
        textField = new JTextField();
        textField.setBounds(0, 0, width, height);
        textField.setEditable(false);
        textField.setFont(new Font("arial", Font.BOLD, 25));

        panel = new JPanel();
        panel.setBounds(0, 0, 400, 100);
        panel.add(textField);
    }

    public static void setText(String text) {
        textField.setText(text);
    }

    public static String getText() {
        return textField.getText();
    }

    public JTextField getTextField() {
        return textField;
    }
}
