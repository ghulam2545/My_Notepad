package dialogs;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FeedbackDialog extends JFrame {
    public FeedbackDialog(JFrame parent) {
        JLabel aboutLabel = new JLabel("This is feedback dialog box. I\'ll refacter it.");
        aboutLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(aboutLabel);

        setTitle("Feedback - My Notepad");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
