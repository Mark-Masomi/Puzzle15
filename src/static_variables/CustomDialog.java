package static_variables;

import javax.swing.*;
import java.awt.*;

public class CustomDialog extends JDialog {
    public CustomDialog() {
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Congratulations! You've won this round!");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> System.exit(0));
        add(okButton, BorderLayout.EAST);
    }
}
