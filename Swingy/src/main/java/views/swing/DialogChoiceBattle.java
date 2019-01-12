package views.swing;

import views.swing.viewElement.JMainButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

/**
 * Created by dkotenko on 12/19/18.
 */
public class DialogChoiceBattle extends JFrame {


    public DialogChoiceBattle() {
        super("Choice");

        JButton buttonYes = new JMainButton("Yes");
        JButton buttonNo = new JMainButton("No");
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            JLabel background = new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/choiceBackground.jpg"))));
            setContentPane(background);
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonYes.setSize(100,35);
        buttonYes.setLocation(240,300);
        buttonNo.setSize(100,35);
        buttonNo.setLocation(60,300);

        add(buttonYes);
        add(buttonNo);

        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
