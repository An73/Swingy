package views.swing.viewElement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

/**
 * Created by dkotenko on 12/5/18.
 */
public class JCreateTextArea extends JTextArea {

    public JCreateTextArea() {
        setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();
        Border thickBorder = new LineBorder(Color.BLACK, 3);

        setAutoscrolls(true);
        g2.setPaint(new GradientPaint(
                new Point(0, 0),
                Color.DARK_GRAY,
                new Point(0, getHeight()),
                Color.ORANGE));

        setForeground(Color.BLACK);
        setFont(new Font("Luminari", Font.BOLD, 20));
        setBorder(thickBorder);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();

        super.paintComponent(g);
    }



}
