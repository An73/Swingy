package views.swing;

import profile.PlayerProfile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dkotenko on 12/12/18.
 */
public class Assets {

    private BufferedImage redSquare;
    private BufferedImage yellowSquare;
    private BufferedImage playerSquare;

    private BufferedImage boneSoldier;
    private BufferedImage swineSlasher;
    private BufferedImage boneCourtier;
    private BufferedImage boneDefender;
    private BufferedImage ghoul;
    private BufferedImage collector;
    private BufferedImage uncleanGiant;

    private BufferedImage roll;
    private BufferedImage woodenPlank;

    private BufferedImage jawboneCap;
    private BufferedImage casque;
    private BufferedImage corona;
    private BufferedImage deathMask;
    private BufferedImage demonHead;
    private BufferedImage fullHelm;
    private BufferedImage skullCap;

    private BufferedImage shortSword;
    private BufferedImage longSword;
    private BufferedImage mace;
    private BufferedImage doubleAxe;
    private BufferedImage gothicAxe;
    private BufferedImage devilStar;
    private BufferedImage thunderMaul;

    private BufferedImage leatherArmor;
    private BufferedImage hardLeatherArmor;
    private BufferedImage ringMail;
    private BufferedImage scaleMail;
    private BufferedImage gothicPlate;
    private BufferedImage chaosArmor;
    private BufferedImage ornatePlate;



    public Assets(PlayerProfile playerProfile) {
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

            jawboneCap = ImageIO.read(getClass().getResourceAsStream("/items/JawboneCap.png"));
            casque = ImageIO.read(getClass().getResourceAsStream("/items/Casque.png"));
            corona = ImageIO.read(getClass().getResourceAsStream("/items/Corona.png"));
            deathMask = ImageIO.read(getClass().getResourceAsStream("/items/DeathMask.png"));
            demonHead = ImageIO.read(getClass().getResourceAsStream("/items/DemonHead.png"));
            fullHelm = ImageIO.read(getClass().getResourceAsStream("/items/FullHelm.png"));
            skullCap = ImageIO.read(getClass().getResourceAsStream("/items/SkullCap.png"));

            shortSword = ImageIO.read(getClass().getResourceAsStream("/items/ShortSword.png"));
            longSword = ImageIO.read(getClass().getResourceAsStream("/items/LongSword.png"));
            mace = ImageIO.read(getClass().getResourceAsStream("/items/Mace.png"));
            doubleAxe = ImageIO.read(getClass().getResourceAsStream("/items/DoubleAxe.png"));
            gothicAxe = ImageIO.read(getClass().getResourceAsStream("/items/GothicAxe.png"));
            devilStar = ImageIO.read(getClass().getResourceAsStream("/items/DevilStar.png"));
            thunderMaul = ImageIO.read(getClass().getResourceAsStream("/items/ThunderMaul.png"));

            leatherArmor = ImageIO.read(getClass().getResourceAsStream("/items/LeatherArmor.png"));
            hardLeatherArmor = ImageIO.read(getClass().getResourceAsStream("/items/HardLeatherArmor.png"));
            ringMail = ImageIO.read(getClass().getResourceAsStream("/items/RingMail.png"));
            scaleMail = ImageIO.read(getClass().getResourceAsStream("/items/ScaleMail.png"));
            gothicPlate = ImageIO.read(getClass().getResourceAsStream("/items/GothicPlate.png"));
            chaosArmor = ImageIO.read(getClass().getResourceAsStream("/items/ChaosArmor.png"));
            ornatePlate = ImageIO.read(getClass().getResourceAsStream("/items/OrnatePlate.png"));

            woodenPlank = ImageIO.read(getClass().getResourceAsStream("/WoodenPlank.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getRedSquare() {
        return redSquare;
    }

    public BufferedImage getYellowSquare() {
        return yellowSquare;
    }

    public BufferedImage getPlayerSquare() {
        return playerSquare;
    }

    public BufferedImage getRoll() {
        return roll;
    }

    public BufferedImage getWoodenPlank() {
        return woodenPlank;
    }

    public BufferedImage getEnemy(String enemyName) {
        switch (enemyName) {
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
    }

    public BufferedImage getHelm(String nameHelm) {
        switch (nameHelm) {
            case "Jawbone Cap":
                return jawboneCap;
            case "Skull Cap":
                return skullCap;
            case "Casque":
                return casque;
            case "Full Helm":
                return fullHelm;
            case "Death Mask":
                return deathMask;
            case "Demon Head":
                return demonHead;
            case "Corona":
                return corona;
        }
        return null;
    }

    public BufferedImage getArmor(String nameArmor) {
        switch (nameArmor) {
            case "Leather Armor":
                return leatherArmor;
            case "Hard Leather Armor":
                return hardLeatherArmor;
            case "Ring Mail":
                return ringMail;
            case "Scale Mail":
                return scaleMail;
            case "Gothic Plate":
                return gothicPlate;
            case "Chaos Armor":
                return chaosArmor;
            case "Ornate Plate":
                return ornatePlate;
        }
        return null;
    }

    public BufferedImage getWeapon(String nameWeapon) {
        switch (nameWeapon) {
            case "Short Sword":
                return shortSword;
            case "Long Sword":
                return longSword;
            case "Mace":
                return mace;
            case "Double Axe":
                return doubleAxe;
            case "Gothic Axe":
                return gothicAxe;
            case "Devil Star":
                return devilStar;
            case "Thunder Maul":
                return thunderMaul;
        }
        return null;
    }
}
