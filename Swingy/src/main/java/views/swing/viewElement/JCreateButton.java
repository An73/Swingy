package views.swing.viewElement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by dkotenko on 12/6/18.
 */
public class JCreateButton extends JButton {

    public JCreateButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();
        Border thickBorder = new LineBorder(Color.BLACK, 3);

        if (getModel().isPressed()) {
            g2.setColor(Color.BLACK);
            setForeground(Color.GREEN);
        }
        else {
            g2.setPaint(new GradientPaint(
                    new Point(0, 0),
                    Color.ORANGE,
                    new Point(0, getHeight()),
                    Color.GRAY));
            setForeground(Color.BLACK);
        }
        setFont(new Font("Luminari", Font.BOLD, 20));
        setBorder(thickBorder);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();


        super.paintComponent(g);
    }
}
