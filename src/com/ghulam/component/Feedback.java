package com.ghulam.component;

import javax.swing.*;

public class Feedback extends JFrame {

    public Feedback(JFrame parent) {

        String str = "<html><body style='width: 300px; text-align: center;'>" +
                "<p>We appreciate your feedback!</p>" +
                "<p>Help us improve Notepad by sharing your thoughts, suggestions, or reporting issues.</p>" +
                "<p>Your feedback is valuable and contributes to making Notepad a better text editing experience.</p>" +
                "<p>Thank you for using Notepad and for taking the time to provide feedback!</p>" +
                "<p>Write us at - <code>ghulam2545@gmail.com</code> </p>" +
                "</body></html>";

        JLabel label = new JLabel(str);
        label.setFont(FontStyle.get());
        add(label);

        setTitle("Send Feedback");
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

}
