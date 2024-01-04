package com.ghulam.component;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledEditorKit;

public class Menus extends JMenuBar {

    public Menus(JFrame frame) {
        final JMenu fileMenu = getFileMenu();
        final JMenu editMenu = getEditMenu();
        final JMenu formatMenu = getFormatMenu();
        final JMenu sizeMenu = getSizeMenu();

        this.add(fileMenu);
        this.add(editMenu);
        this.add(formatMenu);
        this.add(sizeMenu);

        frame.setJMenuBar(this);
    }

    private static JMenu getFileMenu() {
        final JMenu fileMenu = new JMenu("File");

        final JMenuItem newMenuitem = new JMenuItem("New");
        final JMenuItem openMenuitem = new JMenuItem("Open");
        final JMenuItem saveMenuitem = new JMenuItem("Save");
        final JMenuItem printMenuitem = new JMenuItem("Print");
        final JMenuItem exitMenuitem = new JMenuItem("Exit");

        fileMenu.add(newMenuitem);
        fileMenu.add(openMenuitem);
        fileMenu.add(saveMenuitem);
        fileMenu.addSeparator();
        fileMenu.add(printMenuitem);
        fileMenu.add(exitMenuitem);

        return fileMenu;
    }

    private static JMenu getEditMenu() {
        final JMenu editMenu = new JMenu("Edit");

        Action cutAction = new DefaultEditorKit.CutAction();
        cutAction.putValue(Action.NAME, "Cut");

        Action copyAction = new DefaultEditorKit.CopyAction();
        copyAction.putValue(Action.NAME, "Copy");

        Action pasteAction = new DefaultEditorKit.PasteAction();
        pasteAction.putValue(Action.NAME, "Paste");

        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        return editMenu;
    }

    private static JMenu getFormatMenu() {
        JMenu formatMenu = new JMenu("Format");

        Action boldAction = new StyledEditorKit.BoldAction();
        boldAction.putValue(Action.NAME, "Bold");

        Action italicAction = new StyledEditorKit.ItalicAction();
        italicAction.putValue(Action.NAME, "Italic");

        Action underlineAction = new StyledEditorKit.UnderlineAction();
        underlineAction.putValue(Action.NAME, "Underline");

        formatMenu.add(boldAction);
        formatMenu.add(italicAction);
        formatMenu.add(underlineAction);

        return formatMenu;
    }

    private static JMenu getSizeMenu() {
        JMenu sizeMenu = new JMenu("Size");

        Action smallAction = new StyledEditorKit.FontSizeAction("Small", 13);
        smallAction.putValue(Action.ACCELERATOR_KEY, KEY.CTRL_B);

        Action mediumAction = new StyledEditorKit.FontSizeAction("Medium", 18);
        Action largeAction = new StyledEditorKit.FontSizeAction("Large", 22);

        sizeMenu.add(smallAction);
        sizeMenu.add(mediumAction);
        sizeMenu.add(largeAction);

        return sizeMenu;
    }

}
