package listen;

import window.ButtonPanelTwo;
import window.TextPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonListenerTwo extends TextPanel implements ActionListener {

    public JButton[] fb2 = ButtonPanelTwo.getFunButtonsTwo();

    @Override
    public void actionPerformed(ActionEvent e) {
        // previous
        if (e.getSource() == this.fb2[13]) {
            JPanel framePanel = Frame.getInstance().getPanel();
            ((CardLayout) (framePanel.getLayout())).show(framePanel, "panel 1");
        }
    }
}
