package model;

import model.enemy.Enemy;

/**
 * Created by dkotenko on 11/23/18.
 */
public class ElementMap {
    private int x;
    private int y;
    private boolean player;
    private Enemy enemy;

    public ElementMap(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isPlayer() {
        return player;
    }


    public void setPlayer(boolean player) {
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
