package model;

import dbService.DBService;
import profile.PlayerProfile;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dkotenko on 11/29/18.
 */
public class Items {
    private String      name;
    private String      type;
    private String      description;

    private int         incAttack;
    private int         incDefense;
    private int         incHitPoints;

    private DBService   dbService;

    public Items(int level) {
        dbService = new DBService();
        int random = ThreadLocalRandom.current().nextInt(1,4);
        switch (random) {
            case 1:
                weaponSet(level);
                break;
            case 2:
                armorSet(level);
                break;
            case 3:
                helmSet(level);
                break;
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setPlayerItems(PlayerProfile playerProfile) {
        switch (type) {
            case "Weapon":
                playerProfile.setIncAttack(incAttack);
                playerProfile.setWeaponName(name);
                break;
            case "Armor":
                playerProfile.setIncDefense(incDefense);
                playerProfile.setArmorName(name);
                break;
            case "Helm":
                playerProfile.setIncHitPoints(incHitPoints);
                playerProfile.setHelmName(name);
                break;
        }
        dbService.updateItem(playerProfile.getName(), this);
    }

    public int getIncAttack() {
        return incAttack;
    }

    public int getIncDefense() {
        return incDefense;
    }

    public int getIncHitPoints() {
        return incHitPoints;
    }

    private void weaponSet(int level) {
        type = "Weapon";
        switch (level){
            case 1:
                name = "Short Sword";
                description = "Increases attack by 2";
                incAttack = 2;
                break;
            case 2:
                name = "Long Sword";
                description = "Increases attack by 5";
                incAttack = 5;
                break;
            case 3:
                name = "Mace";
                description = "Increases attack by 8";
                incAttack = 8;
                break;
            case 4:
                name = "Double Axe";
                description = "Increases attack by 15";
                incAttack = 15;
                break;
            case 5:
                name = "Gothic Axe";
                description = "Increases attack by 20";
                incAttack = 20;
                break;
            case 6:
                name = "Devil Star";
                description = "Increases attack by 30";
                incAttack = 30;
                break;
            case 7:
                name = "Thunder Maul";
                description = "Increases attack by 45";
                incAttack = 45;
                break;
        }

    }

    private void armorSet(int level) {
        type = "Armor";
        switch (level){
            case 1:
                name = "Leather Armor";
                description = "Increases defense by 1";
                incDefense = 1;
                break;
            case 2:
                name = "Hard Leather Armor";
                description = "Increases defense by 2";
                incDefense = 2;
                break;
            case 3:
                name = "Ring Mail";
                description = "Increases defense by 4";
                incDefense = 4;
                break;
            case 4:
                name = "Scale Mail";
                description = "Increases defense by 7";
                incDefense = 7;
                break;
            case 5:
                name = "Gothic Plate";
                description = "Increases defense by 12";
                incDefense = 12;
                break;
            case 6:
                name = "Chaos Armor";
                description = "Increases defense by 20";
                incDefense = 20;
                break;
            case 7:
                name = "Ornate Plate";
                description = "Increases defense by 30";
                incDefense = 30;
                break;
        }
    }

    private void helmSet(int level) {
        type = "Helm";
        switch (level){
            case 1:
                name = "Jawbone Cap";
                description = "Increases hit points by 10";
                incHitPoints = 10;
                break;
            case 2:
                name = "Skull Cap";
                description = "Increases hit points by 12";
                incHitPoints = 12;
                break;
            case 3:
                name = "Casque";
                description = "Increases hit points by 15";
                incHitPoints = 15;
                break;
            case 4:
                name = "Full Helm";
                description = "Increases hit points by 20";
                incHitPoints = 20;
                break;
            case 5:
                name = "Death Mask";
                description = "Increases hit points by 40";
                incHitPoints = 40;
                break;
            case 6:
                name = "Demon Head";
                description = "Increases hit points by 60";
                incHitPoints = 60;
                break;
            case 7:
                name = "Corona";
                description = "Increases hit points by 80";
                incHitPoints = 80;
                break;
        }
    }



}
