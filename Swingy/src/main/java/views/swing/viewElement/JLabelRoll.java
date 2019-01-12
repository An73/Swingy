package views.swing.viewElement;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dkotenko on 12/13/18.
 */
public class JLabelRoll extends JLabel {

    public JLabelRoll(String text, Color color, int x, int y, int size) {
        super(text);
        setSize(400,25);
        setLocation(x,y);
        setFont(new Font("Luminari", Font.BOLD, size));
        setForeground(color);
    }
}
