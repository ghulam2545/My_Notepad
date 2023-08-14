package components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {
    private JMenu file = new JMenu("File");
    private JMenu edit = new JMenu("Edit");
    private JMenu help = new JMenu("Help");

    private JMenuItem new_item = new JMenuItem("New");
    private JMenuItem open_item = new JMenuItem("Open...");
    private JMenuItem save_item = new JMenuItem("Save");
    private JMenuItem print_item = new JMenuItem("Print");
    private JMenuItem exit_item = new JMenuItem("Exit");

    private JMenuItem cut_item = new JMenuItem("Cut");
    private JMenuItem copy_item = new JMenuItem("Copy");
    private JMenuItem paste_item = new JMenuItem("Paste");
    private JMenuItem select_item = new JMenuItem("Select All");

    private JMenuItem about_item = new JMenuItem("About");
    private JMenuItem feedback_item = new JMenuItem("Send Feedback");

    public MenuBar(ActionListener listener) {
        file.add(new_item);
        file.add(open_item);
        file.add(save_item);
        file.add(print_item);
        file.add(exit_item);

        edit.add(cut_item);
        edit.add(copy_item);
        edit.add(paste_item);
        edit.add(select_item);

        help.add(about_item);
        help.add(feedback_item);

        add(file);
        add(edit);
        add(help);

        new_item.addActionListener(listener);
        open_item.addActionListener(listener);
        save_item.addActionListener(listener);
        print_item.addActionListener(listener);
        exit_item.addActionListener(listener);
        cut_item.addActionListener(listener);
        copy_item.addActionListener(listener);
        paste_item.addActionListener(listener);
        select_item.addActionListener(listener);
        about_item.addActionListener(listener);
        feedback_item.addActionListener(listener);

        new_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        open_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        save_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        print_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));

    }
}
