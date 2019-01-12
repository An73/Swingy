package views.swing.viewElement;

import controllers.SwingController;
import javafx.scene.control.Cell;
import model.ElementMap;
import model.enemy.Enemy;
import profile.PlayerProfile;
import views.swing.Assets;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dkotenko on 12/10/18.
 */
public class JBattlePanel extends JPanel {



    private ArrayList<ElementMap> maps;
    private PlayerProfile playerProfile;
    private int borderTop;
    private int borderBottom;
    private final int NUMBER_OF_BUTTONS = 1521;
    private SwingController swingController;
    private ElementMap playerElement;

    private Assets assets;

    private JLabelRoll labelName;
    private JLabelRoll labelClass;
    private JLabelRoll labelLevel;
    private JLabelRoll labelExperience;
    private JLabelRoll labelAttack;
    private JLabelRoll labelDefense;
    private JLabelRoll labelHitPoints;

    private JLabelRoll labelNameHelm;
    private JLabelRoll labelDescHelm;
    private JLabelRoll labelNameArmor;
    private JLabelRoll labelDescArmor;
    private JLabelRoll labelNameWeapon;
    private JLabelRoll labelDescWeapon;


    public JBattlePanel(ArrayList<ElementMap> maps, PlayerProfile playerProfile) {
        this.maps = maps;
        this.playerProfile = playerProfile;
        swingController = new SwingController();

        assets = new Assets(playerProfile);

        borderTop = 20 + playerProfile.getBorder();
        borderBottom = 20 - playerProfile.getBorder();

        labelName = new JLabelRoll("Name                  : " + playerProfile.getName(),
                new Color(120, 49, 50), 1150,160, 20);
        labelClass = new JLabelRoll("Class             : " + playerProfile.getpClass(),
                new Color(120, 49, 50), 1150,180, 20);
        labelLevel = new JLabelRoll("Level             : " + playerProfile.getLevel(),
                new Color(120, 49, 50), 1150,200, 20);
        labelExperience = new JLabelRoll("Experience        : " + playerProfile.getExperience(),
                new Color(120, 49, 50), 1150,220, 20);
        labelAttack = new JLabelRoll("Attack          : " + playerProfile.getAttack(),
                new Color(120, 49, 50), 1150,240, 20);
        labelDefense = new JLabelRoll("Defense        : " + playerProfile.getDefense(),
                new Color(120, 49, 50), 1150,260, 20);
        labelHitPoints = new JLabelRoll("Hit Points    : " + playerProfile.getHitPoints(),
                new Color(120, 49, 50), 1150,280, 20);

        labelNameHelm = new JLabelRoll(null,
                new Color(0, 95, 48), 1150,310, 18);
        labelDescHelm = new JLabelRoll(null,
                new Color(0, 87, 72), 1150,332, 16);

        labelNameArmor = new JLabelRoll(null,
                new Color(0, 58, 94), 1150,380, 18);
        labelDescArmor = new JLabelRoll(null,
                new Color(32, 102, 117), 1150,402, 16);

        labelNameWeapon = new JLabelRoll(null,
                new Color(177, 56, 1), 1150,470, 18);
        labelDescWeapon = new JLabelRoll(null,
                new Color(116, 57, 1), 1150,492, 16);

        setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        TexturePaint redTexture = new TexturePaint(assets.getRedSquare(), new Rectangle(0, 0, 25, 25));
        TexturePaint yellowTexture = new TexturePaint(assets.getYellowSquare(), new Rectangle(0, 0, 25, 25));
        int i = 0;
        for (int y = 0; y < 39; y++) {
            for (int x = 0; x < 39; x++) {
                ElementMap elementMap = maps.get(i);
                if (elementMap.isPlayer()) {
                    g2d.setPaint(new TexturePaint(assets.getPlayerSquare(), new Rectangle((x + 1) * 26, (y + 1) * 26, 25, 25)));
                    playerElement = elementMap;
                }
                //else if (elementMap.getEnemy() != null)
                //    g2d.setPaint(new TexturePaint(boneSoldier, new Rectangle((x + 1) * 26, (y + 1) * 26, 25, 25)));
                else if (elementMap.getX() <= borderTop && elementMap.getX() >= borderBottom &&
                        elementMap.getY() >= borderBottom && elementMap.getY() <= borderTop)
                    g2d.setPaint(yellowTexture);
                else
                    g2d.setPaint(redTexture);
                g2d.fillRect((x + 1) * 26,(y + 1) * 26,25,25);
                if (elementMap.getEnemy() != null && !elementMap.isPlayer())
                    g2d.drawImage(assets.getEnemy(elementMap.getEnemy().getName()), (x + 1) * 26,
                            (y + 1) * 26, this);
                i++;
            }

            /*g2d.setPaint(tp);
            g2d.fillRect(i,i,25,25);
            //g2d.drawImage(redSquare, 25,
              //      25, this);
            ElementMap elementMap = maps.get(i);
            if (elementMap.isPlayer())
                g2d.drawImage(redSquare, 25,
                        25, this);*/

        }
        paintRoll(g2d);
        paintLegend(g2d);
        if (playerElement.getEnemy() != null) {
            System.out.println("Enemy!!!");
            setFocusable(false);
            swingController.toDialogChoiceBattle();
        }
    }

    private void paintRoll(Graphics2D g2d) {
        String helmName = playerProfile.getHelmName();
        String armorName = playerProfile.getArmorName();
        String weaponName = playerProfile.getWeaponName();
        labelName.setText("Name           : " + playerProfile.getName());
        labelClass.setText("Class             : " + playerProfile.getpClass());
        labelLevel.setText("Level             : " + playerProfile.getLevel());
        labelExperience.setText("Experience : " + playerProfile.getExperience());
        labelAttack.setText("Attack          : " + playerProfile.getAttack());
        labelDefense.setText("Defense        : " + playerProfile.getDefense());
        labelHitPoints.setText("Hit Points   : " + playerProfile.getHitPoints());

        g2d.drawImage(assets.getRoll(), 1050,10,this);
        //g2d.drawImage(assets.getJawboneCap(), 1300,315,this);
        if (helmName != null && !helmName.isEmpty()) {
            g2d.drawImage(assets.getHelm(helmName), 1358,282,this);

            labelNameHelm.setText(playerProfile.getHelmName());
            labelDescHelm.setText("Increases hit points by " + playerProfile.getIncHitPoints());
            add(labelNameHelm);
            add(labelDescHelm);
        }

        if (armorName != null && !armorName.isEmpty()) {
            g2d.drawImage(assets.getArmor(armorName), 1350,345,this);

            labelNameArmor.setText(playerProfile.getArmorName());
            labelDescArmor.setText("Increases defense by " + playerProfile.getIncDefense());
            add(labelNameArmor);
            add(labelDescArmor);
        }

        if (weaponName != null && !weaponName.isEmpty()) {
            g2d.drawImage(assets.getWeapon(weaponName), 1360,450,this);

            labelNameWeapon.setText(playerProfile.getWeaponName());
            labelDescWeapon.setText("Increases attack by " + playerProfile.getIncAttack());
            add(labelNameWeapon);
            add(labelDescWeapon);
        }

        add(labelName);
        add(labelClass);
        add(labelLevel);
        add(labelExperience);
        add(labelAttack);
        add(labelDefense);
        add(labelHitPoints);
    }

    private void paintLegend(Graphics2D g2d) {
        g2d.drawImage(assets.getWoodenPlank(), 1035,550,this);
    }

    ////
    /*private BufferedImage paintEnemy(Enemy enemy) {
        switch (enemy.getName()) {
            case "Bone Soldier":
                return boneSoldier;
            case "Swine Slasher":
                return swineSlasher;
            case "Bone Courtier":
                return boneCourtier;
            case "Bone Defender":
                return boneDefender;
            case "Ghoul":
                return ghoul;
            case "The Collector":
                return collector;
            case "Unclean Giant":
                return uncleanGiant;
        }
        return null;
    }*/

    /*private void loadImage() {
        try {
            switch (playerProfile.getpClass()) {
                case "Warrior":
                    playerSquare = ImageIO.read(getClass().getResourceAsStream("/warriorClass.png"));
                    break;
                case "Druid":
                    playerSquare = ImageIO.read(getClass().getResourceAsStream("/druidClass.png"));
                    break;
                case "Hunter":
                    playerSquare = ImageIO.read(getClass().getResourceAsStream("/hunterClass.png"));
                    break;
            }
            redSquare = ImageIO.read(getClass().getResourceAsStream("/redSquare.jpg"));
            yellowSquare = ImageIO.read(getClass().getResourceAsStream("/yellowSquare.jpg"));
            boneSoldier = ImageIO.read(getClass().getResourceAsStream("/BoneSoldier.png"));
            swineSlasher = ImageIO.read(getClass().getResourceAsStream("/SwineSlasher.png"));
            boneCourtier = ImageIO.read(getClass().getResourceAsStream("/BoneCourtier.png"));
            boneDefender = ImageIO.read(getClass().getResourceAsStream("/BoneDefender.png"));
            ghoul = ImageIO.read(getClass().getResourceAsStream("/Ghoul.png"));
            collector = ImageIO.read(getClass().getResourceAsStream("/Collector.png"));
            uncleanGiant = ImageIO.read(getClass().getResourceAsStream("/UncleanGiant.png"));
            roll = ImageIO.read(getClass().getResourceAsStream("/Roll.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /////

    /*ElementMap elementMap = maps.get(i);
            //button.putClientProperty("map", maps.get(i));
            if (elementMap.isPlayer())
                button.setIcon(new ImageIcon(buttonIcon));
            else if (elementMap.getX() <= borderTop && elementMap.getX() >= borderBottom &&
                    elementMap.getY() >= borderBottom && elementMap.getY() <= borderTop)
                button.setElementColor(Color.ORANGE);*/
}
