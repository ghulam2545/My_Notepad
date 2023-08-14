package dialogs;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutDialog extends JFrame {
    public AboutDialog(JFrame parent) {
        JLabel aboutLabel = new JLabel("This is about dialog box. I\'ll refacter it.");
        aboutLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(aboutLabel);

        setTitle("About - My Notepad");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
