package views.swing.viewElement;

import controllers.ConsoleController;
import controllers.SwingController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dkotenko on 12/6/18.
 */
public class JListPanel extends JPanel {
    private BufferedImage   background;
    private JCreateButton   startButton;
    private JCreateButton   backButton;
    private JList<String>   listPlayers;
    private JFrame          listFrame;
    private SwingController swingController;

    public JListPanel(JList<String> listPlayers, JFrame listFrame) {
        this.listPlayers = listPlayers;
        this.listFrame = listFrame;
        swingController = new SwingController();
        setLayout(new BorderLayout());
        try {
            background = ImageIO.read(getClass().getResourceAsStream("/backCreate.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        startButton = new JCreateButton("Start");
        startButton.setSize(160,40);
        startButton.setLocation(90,400);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //System.out.println(listPlayers.getSelectedValue());
                swingController.toBattleWindow(listFrame, listPlayers.getSelectedValue());
            }
        });
        backButton = new JCreateButton("Back");
        backButton.setSize(160,40);
        backButton.setLocation(350,400);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                swingController.toMainWindow(listFrame);
            }
        });
        add(startButton);
        add(backButton);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            int x = getWidth() - background.getWidth();
            int y = getHeight() - background.getHeight();
            g2d.drawImage(background, x, y, this);
            g2d.dispose();
        }
    }
}
