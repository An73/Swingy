package views.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by dkotenko on 12/3/18.
 */
public class StartWindow extends JFrame {

    public StartWindow(){
        super("Swingy");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton button = new JButton("Button");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Clicked");
            }
        });
        button.setSize(100, 40);
        button.setLocation(30, 30);
        panel.add(button);
        setContentPane(panel);
        setSize(800, 600);
    }
}
