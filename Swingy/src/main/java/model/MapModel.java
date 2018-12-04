package model;

import model.enemy.Enemy;
import model.enemy.FabricEnemy;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dkotenko on 11/23/18.
 */
public class MapModel {
    private ArrayList<ElementMap> maps;

    public MapModel(){
        maps = new ArrayList<ElementMap>();
        loadMap();
        loadEnemy();
    }

    public ArrayList<ElementMap> getMaps() {
        return maps;
    }

    public ElementMap getElementPlayer(){
        for (ElementMap map : maps) {
            if (map.isPlayer())
                return map;
        }
        return null;
    }

    private void loadMap() {
        for (int y = 1; y < 40; y++){
            for (int x = 1; x < 40; x++) {
                if (x == 20 && y == 20) {
                    ElementMap elementMap = new ElementMap(x, y);
                    elementMap.setPlayer(true);
                    maps.add(elementMap);
                }
                else
                    maps.add(new ElementMap(x, y));
            }
        }
    }
    private ElementMap getElementMap(int x, int y){
        for (ElementMap elementMap : maps) {
            if (elementMap.getX() == x && elementMap.getY() == y)
                return elementMap;
        }
        return null;
    }

    public boolean movePlayer(String  directions){
        ElementMap elementMap = null;
        int x = -1;
        int y = -1;

        for (int i = 0; elementMap == null; i++) {
            if (maps.get(i).isPlayer())
                elementMap = maps.get(i);
        }
        switch (directions){
            case "West":
                x = elementMap.getX() - 1;
                y = elementMap.getY();
                break;
            case "East":
                x = elementMap.getX() + 1;
                y = elementMap.getY();
                break;
            case "South":
                x = elementMap.getX();
                y = elementMap.getY() + 1;
                break;
            case "North":
                x = elementMap.getX();
                y = elementMap.getY() - 1;
                break;
        }
        elementMap.setPlayer(false);
        for (int i = 0; x != -1; i++) {
            if (maps.get(i).getX() == x && maps.get(i).getY() == y) {
                maps.get(i).setPlayer(true);
                if (maps.get(i).getEnemy() != null)
                    return true;
                x = -1;
            }
        }
        return false;
    }

    public void loadEnemy() {
        for (int i = 1; i < 8; i++)
            loadPartEnemy(i);
    }

    private void loadPartEnemy(int level) {
        ElementMap elementMap;
        ArrayList<Enemy> enemies;
        FabricEnemy fabricEnemy = new FabricEnemy();

        int i = 0;
        int originOk = 20 - ((level - 1) * 5 + 10 - (level % 2)) / 2;
        int boundOK = 21 + ((level - 1) * 5 + 10 - (level % 2)) / 2;

        int originFalse = 20 - ((level - 2) * 5 + 10 - ((level - 1) % 2)) / 2;
        int boundFalse = 20 + ((level - 2) * 5 + 10 - ((level - 1) % 2)) / 2;

        if (level == 1) {
            originFalse = 20;
            boundFalse = 20;
        }

        enemies = fabricEnemy.getEnemies(level);
        while (i < enemies.size()) {
            int randomX = ThreadLocalRandom.current().nextInt(originOk, boundOK);
            int randomY = ThreadLocalRandom.current().nextInt(originOk, boundOK);
            if (randomX < originFalse || randomY < originFalse ||
                    randomX > boundFalse || randomY > boundFalse){

                elementMap = getElementMap(randomX, randomY);
                if (elementMap != null && elementMap.getEnemy() == null && !elementMap.isPlayer()) {
                    elementMap.setEnemy(enemies.get(i));
                    i++;
                }

            }
        }
    }
}