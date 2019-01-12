package views.swing;

import controllers.SwingController;
import views.swing.viewElement.JMainButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dkotenko on 12/3/18.
 */


public class StartWindow extends JFrame {
    private JFrame frame;
    public StartWindow(){
        super("Swingy");
        frame = this;
        SwingController swingController = new SwingController();
        ClassLoader classLoader = getClass().getClassLoader();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ////JPanel panel = new JPanel();
        ////panel.setLayout(null);
        JButton button1 = new JMainButton("Create a HERO");
        JButton button2 = new JMainButton("Select a previously created HERO");
        JButton button3 = new JMainButton("Exit");
        //JButton button = new JButton("Select a previously created HERO");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                swingController.toCreateWindow(frame);
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                swingController.toListWindow(frame);
            }
        });

        /*try {
            BufferedImage bf = ImageIO.read(new File("/Users/dkotenko/IdeaProjects/Swingy/src/main/resources/backMain.jpg"));
            setContentPane(new backImage(bf));
            setBackground(Color.BLACK);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            JLabel background = new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/backMain.jpg"))));
            setContentPane(background);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Image background = Toolkit.getDefaultToolkit().createImage("backImage.png");
        //panel.drawImage(background, 0, 0, null);


        button1.setSize(250, 60);
        button1.setLocation(40, 80);
        button2.setSize(250, 60);
        button2.setLocation(40, 210);
        button3.setSize(250,60);
        button3.setLocation(40, 340);

        add(button1);
        add(button2);
        add(button3);

        ////panel.add(button1);
        ////panel.add(button2);
        ////panel.add(button3);
        ////setContentPane(panel);
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
