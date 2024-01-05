package com.ghulam.component;

import javax.swing.*;
import java.util.Objects;

public class Runner {
    public void run() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

            System.out.println("Something went wrong.");
            throw new RuntimeException(ex);
        }

        JFrame frame = new JFrame();
        frame.setTitle("Notepad");
        frame.setResizable(true);
        frame.setSize(600, 500);
        frame.setLocation(200, 160);
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/icon.png"))).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextPane textarea = new JTextPane();
        textarea.setFont(FontStyle.get());
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(textarea);

        // ************************
        new Menus(frame, textarea);
        new Listener(frame, textarea);

        frame.add(pane);
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
}
