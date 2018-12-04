package model.enemy;

import java.util.ArrayList;

/**
 * Created by dkotenko on 26.11.2018.
 */
public class FabricEnemy {
    private ArrayList<Enemy> enemies;

    public FabricEnemy(){
        enemies = new ArrayList<Enemy>();
    }

    public ArrayList<Enemy> getEnemies(int level) {
        switch (level) {
            case 1:
                for (int i = 0; i < 20; i++) {
                    enemies.add(new Enemy("Bone Soldier"));
                }
                break;
            case 2:
                for (int i = 0; i < 15; i++)
                    enemies.add(new Enemy("Bone Soldier"));
                for (int i = 0; i < 35; i++)
                    enemies.add(new Enemy("Swine Slasher"));
                break;
            case 3:
                for (int i = 0; i < 80; i++)
                    enemies.add(new Enemy("Bone Courtier"));
                break;
            case 4:
                for (int i = 0; i < 60; i++)
                    enemies.add(new Enemy("Bone Courtier"));
                for (int i = 0; i < 100; i++)
                    enemies.add(new Enemy("Bone Defender"));
                break;
            case 5:
                for (int i = 0; i < 160; i++)
                    enemies.add(new Enemy("Ghoul"));
                break;
            case 6:
                for (int i = 0; i < 170; i++)
                    enemies.add(new Enemy("The Collector"));
                break;
            case 7:
                for (int i = 0; i < 250; i++)
                    enemies.add(new Enemy("Unclean Giant"));
                break;

        }
        return enemies;
    }

}
