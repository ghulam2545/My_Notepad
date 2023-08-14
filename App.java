import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import components.MenuBar;
import components.TextArea;
import dialogs.AboutDialog;
import dialogs.FeedbackDialog;
import fonts.FontStyle;

public class App extends JFrame implements ActionListener {
    private MenuBar menuBar;
    private TextArea textArea;

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Only Text Files (.txt)", "txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(fileFilter);

        int status = fileChooser.showOpenDialog(this);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedReader bReader = new BufferedReader(new FileReader(selectedFile));
                textArea.read(bReader, null);
                bReader.close();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Only Text Files (.txt)", "txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(fileFilter);

        int status = fileChooser.showSaveDialog(this);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getAbsolutePath();

            if (!filename.endsWith(".txt"))
                filename += ".txt";

            try {
                BufferedWriter bWriter = new BufferedWriter(new FileWriter(filename));
                textArea.write(bWriter);
                bWriter.close();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    private void printFile() {
        try {
            textArea.print();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void showAboutDialog() {
        new AboutDialog(this);
    }

    private void showFeedbackDialog() {
        new FeedbackDialog(this);
    }

    public App() {
        this.setTitle("My Notepad");
        this.setBounds(100, 100, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("assets/icon.png");
        this.setIconImage(icon.getImage());

        menuBar = new MenuBar(this);
        setJMenuBar(menuBar);

        textArea = new TextArea(FontStyle.getFont());

        JScrollPane scrollpane = new JScrollPane(textArea);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollpane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String command = ev.getActionCommand();
        if (command != null) {
            switch (command) {
                case "New": {
                    textArea.setText(null);
                    break;
                }
                case "Open...": {
                    openFile();
                    break;
                }
                case "Save": {
                    saveFile();
                    break;
                }
                case "Print": {
                    printFile();
                    break;
                }
                case "Exit": {
                    System.exit(0);
                    break;
                }
                case "Cut": {
                    textArea.cut();
                    break;
                }
                case "Copy": {
                    textArea.copy();
                    break;
                }
                case "Paste": {
                    textArea.paste();
                    break;
                }
                case "Select All": {
                    textArea.selectAll();
                    break;
                }
                case "About": {
                    showAboutDialog();
                    break;
                }
                case "Send Feedback": {
                    showFeedbackDialog();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new App();
        });
    }
}