package profile;

import dbService.DBService;

/**
 * Created by dkotenko on 11/22/18.
 */
public class PlayerProfile {
    private String      name;
    private String      pClass;
    private int         level;
    private int         experience;
    private int         attack;
    private int         defense;
    private int         hitPoints;
    private String      weaponName;
    private String      armorName;
    private String      helmName;
    private int         incAttack;
    private int         incDefense;
    private int         incHitPoints;


    private int         moveWith;
    private int         moveHeight;
    private int         border;

    public PlayerProfile(String name, String pClass) {
        this.name = name;
        this.pClass = pClass;
        moveWith = 0;
        moveHeight = 0;
    }

    public boolean moveItHeight(boolean plus) {

        if (plus && (moveHeight + 1) <= border) {
            moveHeight++;
            return true;
        }
        else if (!plus && (moveHeight - 1) >= -border) {
            moveHeight--;
            return true;
        }
        return false;
    }

    public boolean moveItWith(boolean plus) {
        if (plus && (moveWith + 1) <= border) {
            moveWith++;
            return true;
        }
        else if (!plus && (moveWith - 1) >= -border) {
            moveWith--;
            return true;
        }
        return false;
    }

    public int getMoveWith() {
        return moveWith;
    }

    public int getMoveHeight() {
        return moveHeight;
    }

    private void setBorder(int level){
        border = ((level - 1) * 5 + 10-(level % 2) - 1) / 2;
    }

    public int getBorder() {
        return border;
    }

    public String getName() {
        return name;
    }

    public String getpClass() {
        return pClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        setBorder(level);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        if (level != 7 && (level * 1000 + (level - 1) * (level - 1) * 450) <= this.experience) {
            attack = level * 5 + attack;
            defense = level * 2 + defense;
            hitPoints = level * 20 + hitPoints;
            level++;
            setBorder(level);
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public String getHelmName() {
        return helmName;
    }

    public void setHelmName(String helmName) {
        this.helmName = helmName;
    }

    public int getIncAttack() {
        return incAttack;
    }

    public void setIncAttack(int incAttack) {
        this.incAttack = incAttack;
    }

    public int getIncDefense() {
        return incDefense;
    }

    public void setIncDefense(int incDefense) {
        this.incDefense = incDefense;
    }

    public int getIncHitPoints() {
        return incHitPoints;
    }

    public void setIncHitPoints(int incHitPoints) {
        this.incHitPoints = incHitPoints;
    }
}
