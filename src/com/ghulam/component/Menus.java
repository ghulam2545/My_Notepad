package com.ghulam.component;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledEditorKit;
import static com.ghulam.component.Listener.*;

public class Menus extends JMenuBar {

    public Menus(JFrame frame, JTextPane textarea) {
        final JMenu fileMenu = getFileMenu();
        final JMenu editMenu = getEditMenu(textarea);
        final JMenu formatMenu = getFormatMenu();
        final JMenu sizeMenu = getSizeMenu();
        final JMenu aboutMenu = getAboutMenu();

        fileMenu.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        editMenu.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        formatMenu.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        sizeMenu.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        aboutMenu.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

        this.add(fileMenu);
        this.add(editMenu);
        this.add(formatMenu);
        this.add(sizeMenu);
        this.add(aboutMenu);

        frame.setJMenuBar(this);
    }

    private static JMenu getFileMenu() {
        final JMenu fileMenu = new JMenu("File");

        final JMenuItem newMenuitem = new JMenuItem("New");
        final JMenuItem openMenuitem = new JMenuItem("Open");
        final JMenuItem saveMenuitem = new JMenuItem("Save");
        final JMenuItem printMenuitem = new JMenuItem("Print");
        final JMenuItem exitMenuitem = new JMenuItem("Exit");

        newMenuitem.setAccelerator(KEY.CTRL_N);
        openMenuitem.setAccelerator(KEY.CTRL_O);
        saveMenuitem.setAccelerator(KEY.CTRL_S);
        printMenuitem.setAccelerator(KEY.CTRL_P);
        exitMenuitem.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 40));

        fileMenu.add(newMenuitem);
        fileMenu.add(openMenuitem);
        fileMenu.add(saveMenuitem);
        fileMenu.addSeparator();
        fileMenu.add(printMenuitem);
        fileMenu.add(exitMenuitem);

        // add listeners
        newMenuitem.addActionListener(e -> newFile());
        openMenuitem.addActionListener(e -> openFile());
        saveMenuitem.addActionListener(e -> saveFile());
        printMenuitem.addActionListener(e -> printFile());
        exitMenuitem.addActionListener(e -> closeApp());

        return fileMenu;
    }

    private static JMenu getEditMenu(JTextPane textarea) {
        final JMenu editMenu = new JMenu("Edit");

        Action cutAction = new DefaultEditorKit.CutAction();
        cutAction.putValue(Action.NAME, "Cut");
        cutAction.putValue(Action.ACCELERATOR_KEY, KEY.CTRL_X);

        Action copyAction = new DefaultEditorKit.CopyAction();
        copyAction.putValue(Action.NAME, "Copy");
        copyAction.putValue(Action.ACCELERATOR_KEY, KEY.CTRL_C);

        Action pasteAction = new DefaultEditorKit.PasteAction();
        pasteAction.putValue(Action.NAME, "Paste");
        pasteAction.putValue(Action.ACCELERATOR_KEY, KEY.CTRL_V);

        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.addActionListener(e -> textarea.selectAll());
        selectAll.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 40));

        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        editMenu.add(selectAll);

        return editMenu;
    }

    private static JMenu getFormatMenu() {
        JMenu formatMenu = new JMenu("Format");

        Action boldAction = new StyledEditorKit.BoldAction();
        boldAction.putValue(Action.NAME, "Bold");
        boldAction.putValue(Action.ACCELERATOR_KEY, KEY.CTRL_B);

        Action italicAction = new StyledEditorKit.ItalicAction();
        italicAction.putValue(Action.NAME, "Italic");
        italicAction.putValue(Action.ACCELERATOR_KEY, KEY.CTRL_I);

        Action underlineAction = new StyledEditorKit.UnderlineAction();
        underlineAction.putValue(Action.NAME, "Underline");
        underlineAction.putValue(Action.ACCELERATOR_KEY, KEY.CTRL_U);

        formatMenu.add(boldAction);
        formatMenu.add(italicAction);
        formatMenu.add(underlineAction);

        return formatMenu;
    }

    private static JMenu getSizeMenu() {
        JMenu sizeMenu = new JMenu("Size");

        Action smallAction = new StyledEditorKit.FontSizeAction("Small", 13);
        Action mediumAction = new StyledEditorKit.FontSizeAction("Medium", 18);
        Action largeAction = new StyledEditorKit.FontSizeAction("Large", 22);

        sizeMenu.add(smallAction);
        sizeMenu.add(mediumAction);
        sizeMenu.add(largeAction);

        return sizeMenu;
    }

    private static JMenu getAboutMenu() {
        JMenu helpMenu = new JMenu("Help");
        JMenuItem feedbackMenuitem = new JMenuItem("Send Feedback");
        JMenuItem aboutMenuitem = new JMenuItem("About Notepad");

        aboutMenuitem.addActionListener(e -> aboutNotepad());
        feedbackMenuitem.addActionListener(e -> sendFeedback());

        helpMenu.add(feedbackMenuitem);
        helpMenu.add(aboutMenuitem);
        return helpMenu;
    }

}
