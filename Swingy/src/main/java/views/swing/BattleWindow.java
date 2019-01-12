package views.swing;

import model.ElementMap;
import model.MapModel;
import profile.PlayerProfile;
import views.swing.viewElement.JBattleButton;
import views.swing.viewElement.JBattlePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkotenko on 12/7/18.
 */
public class BattleWindow extends JFrame implements KeyListener {
    //private JPanel panel;
    private JBattlePanel panel;
    private List<JBattleButton> buttons;
    private PlayerProfile playerProfile;
    private ArrayList<ElementMap> maps;
    private int borderTop;
    private int borderBottom;
    private MapModel mapModel;
    private BufferedImage buttonIcon = null;
    private final int NUMBER_OF_BUTTONS = 1521;


    public BattleWindow(PlayerProfile playerProfile, MapModel mapModel) {
        super("Swingy");

        this.mapModel = mapModel;
        this.playerProfile = playerProfile;
        borderTop = 20 + playerProfile.getBorder();
        borderBottom = 20 - playerProfile.getBorder();
        maps = mapModel.getMaps();
        initUI();
        //addKeyListener(this);

    }

    private void initUI() {
        buttons = new ArrayList<>();

        /*try {
            switch (playerProfile.getpClass()) {
                case "Warrior":
                    buttonIcon = ImageIO.read(getClass().getResourceAsStream("/warriorClass.png"));
                    break;
                case "Druid":
                    buttonIcon = ImageIO.read(getClass().getResourceAsStream("/druidClass.png"));
                    break;
                case "Hunter":
                    buttonIcon = ImageIO.read(getClass().getResourceAsStream("/hunterClass.png"));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //panel = new JPanel();
        panel = new JBattlePanel(maps, playerProfile);
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        //panel.setLayout(new GridLayout(39,39,0,0));
        panel.setLayout(null);
        //panel.setPreferredSize(new Dimension(1000, 1000));
        /*for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
            JBattleButton button = new JBattleButton(Color.RED);
            ElementMap elementMap = maps.get(i);
            button.putClientProperty("map", maps.get(i));
            if (elementMap.isPlayer()) {
                BufferedImage buttonIcon = null;
                try {
                    switch (playerProfile.getpClass()) {
                        case "Warrior":
                            buttonIcon = ImageIO.read(getClass().getResourceAsStream("/warriorClass.png"));
                            break;
                        case "Druid":
                            buttonIcon = ImageIO.read(getClass().getResourceAsStream("/druidClass.png"));
                            break;
                        case "Hunter":
                            buttonIcon = ImageIO.read(getClass().getResourceAsStream("/hunterClass.png"));
                            break;
                    }
                    button.setIcon(new ImageIcon(buttonIcon));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (elementMap.getX() <= borderTop && elementMap.getX() >= borderBottom &&
                    elementMap.getY() >= borderBottom && elementMap.getY() <= borderTop)
                button.setElementColor(Color.ORANGE);
            panel.add(button);
        }*/
        //updateBattle();


        panel.addKeyListener(this);
        panel.setFocusable(true);
        add(panel);
        setSize(1800,1200);

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void updateBattle() {
        panel.removeAll();
        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
            JBattleButton button = new JBattleButton(Color.RED);
            ElementMap elementMap = maps.get(i);
            //button.putClientProperty("map", maps.get(i));
            if (elementMap.isPlayer())
                button.setIcon(new ImageIcon(buttonIcon));
            else if (elementMap.getX() <= borderTop && elementMap.getX() >= borderBottom &&
                    elementMap.getY() >= borderBottom && elementMap.getY() <= borderTop)
                button.setElementColor(Color.ORANGE);
            panel.add(button);

            panel.validate();
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            //System.out.println("a");
        }

        if (key == KeyEvent.VK_RIGHT) {
            //System.out.println("d");
        }

        if (key == KeyEvent.VK_UP) {
            //System.out.println("w");
        }

        if (key == KeyEvent.VK_DOWN) {
            //System.out.println("s");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && playerProfile.moveItWith(true)) {
            mapModel.movePlayer("West");
            panel.repaint();
        }

        if (key == KeyEvent.VK_RIGHT && playerProfile.moveItWith(false)) {
            mapModel.movePlayer("East");
            panel.repaint();
        }

        if (key == KeyEvent.VK_UP && playerProfile.moveItHeight(true)) {
            mapModel.movePlayer("North");
            panel.repaint();
        }

        if (key == KeyEvent.VK_DOWN && playerProfile.moveItHeight(false)) {
            mapModel.movePlayer("South");
            panel.repaint();
        }
    }

}
