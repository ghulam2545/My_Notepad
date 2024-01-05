package com.ghulam.component;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class Listener {

    private static JFrame frame;
    private static JTextPane textarea;

    public Listener(JFrame frame, JTextPane textarea) {
        Listener.frame = frame;
        Listener.textarea = textarea;
    }

    public static void newFile() {
        final String message = "Are you sure you want to start a new file (Remove all texts)?";
        int status = JOptionPane.showConfirmDialog(null, message, "New File", JOptionPane.YES_NO_OPTION);

        if (status == JOptionPane.YES_OPTION)
            textarea.setText("");
    }

    public static void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Text File");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Only Text Files (.txt)", "txt"));

        int status = fileChooser.showOpenDialog(frame);

        if (status == JFileChooser.APPROVE_OPTION) {
            File filename = fileChooser.getSelectedFile();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                textarea.read(reader, null);
                reader.close();
            } catch (Exception ex) {
                String message = ex.getMessage();
                String title = "Error Opening File";
                JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Text File");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Only Text Files (.txt)", "txt"));

        int status = fileChooser.showSaveDialog(frame);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getAbsolutePath();

            if (!filename.endsWith(".txt"))
                filename += ".txt";

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                textarea.write(writer);
                writer.close();

                JOptionPane.showMessageDialog(null, "File saved.");
            } catch (Exception exc) {
                // todo
                throw new RuntimeException();
            }
        }
    }

    public static void printFile() {
        try {
            textarea.print();
        } catch (Exception exc) {
            // todo
            throw new RuntimeException();
        }
    }

    public static void closeApp() {
        System.exit(0);
    }

    public static void aboutNotepad() {
        new About(frame);
    }

    public static void sendFeedback() {
        new Feedback(frame);
    }
}
