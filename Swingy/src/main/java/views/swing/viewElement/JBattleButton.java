package views.swing.viewElement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by dkotenko on 12/7/18.
 */
public class JBattleButton extends JButton {

    private Border thickBorder;
    private Color elementColor;

    public JBattleButton(Color color) {
        super();
        elementColor = color;
        setContentAreaFilled(false);
        thickBorder = new LineBorder(Color.BLACK,1);
        initUI();
    }

    public void setElementColor(Color color) {
        elementColor = color;
    }

    private void initUI() {

       /* addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });*/
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();


        if (getModel().isPressed()) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(elementColor);
        }
        setBorder(thickBorder);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();

        super.paintComponent(g);
    }

}
