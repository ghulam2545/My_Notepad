package components;

import java.awt.Font;
import javax.swing.JTextArea;

public class TextArea extends JTextArea {
    public TextArea(Font font) {
        setFont(font);
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}
