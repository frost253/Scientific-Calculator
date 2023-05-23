package window;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel {
    static JPanel panel = new JPanel();
    public static JTextField textField;

    public static void init() {
        panel.setBounds(0, 0, 400, 100);
        textField = new JTextField();
        textField.setBounds(0, 0, 400, 100);
        textField.setEditable(false);
        textField.setFont(new Font("arial", Font.BOLD, 25));
        panel.add(textField);
    }

    public static JTextField getTextField() {
        return textField;
    }
}
