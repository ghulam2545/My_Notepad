package com.ghulam.component;

import javax.swing.*;

public class About extends JFrame {

    public About(JFrame parent) {

        final String str = "<html><body style='width: 300px; text-align: center;'>" +
                "<p>Welcome to Notepad!</p>" +
                "<p>This simple text editor allows you to create, edit, and save text documents with ease.</p>" +
                "<p>Developed by Ghulam Mustafa, it comes with a clean interface and essential features for your text editing needs.</p>" +
                "<p>Feel free to explore and enjoy using Notepad!</p>" +
                "</body></html>";

        JLabel label = new JLabel(str);
        label.setFont(FontStyle.get());
        add(label);

        setTitle("About Notepad");
        setSize(400, 260);
        setResizable(false);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

}
