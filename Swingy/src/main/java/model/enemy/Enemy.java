package model.enemy;

import java.util.logging.Level;

/**
 * Created by dkotenko on 26.11.2018.
 */
public class Enemy {
    private String  name;
    private int     level;
    private int     attack;
    private int     defense;
    private int     hitPoints;
    private int     experience;


    public Enemy(String name) {
        setEnemy(name);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getExperience() {
        return experience;
    }

    private void setEnemy(String name) {
        switch (name) {
            case "Bone Soldier":
                this.name = name;
                level = 1;
                attack = 17;
                defense = 9;
                hitPoints = 70;
                experience = 130;
                break;
            case "Swine Slasher":
                this.name = name;
                level = 2;
                attack = 22;
                defense = 14;
                hitPoints = 100;
                experience = 180;
                break;
            case "Bone Courtier":
                this.name = name;
                level = 3;
                attack = 30;
                defense = 15;
                hitPoints = 180;
                experience = 230;
                break;
            case "Bone Defender":
                this.name = name;
                level = 4;
                attack = 50;
                defense = 18;
                hitPoints = 220;
                experience = 270;
                break;
            case "Ghoul":
                this.name = name;
                level = 5;
                attack = 80;
                defense = 27;
                hitPoints = 340;
                experience = 350;
                break;
            case "The Collector":
                this.name = name;
                level = 6;
                attack = 130;
                defense = 50;
                hitPoints = 450;
                experience = 500;
                break;
            case "Unclean Giant":
                this.name = name;
                level = 7;
                attack = 150;
                defense = 75;
                hitPoints = 600;
                experience = 0;
                break;
        }
    }
}
