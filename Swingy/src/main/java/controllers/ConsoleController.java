package controllers;


import dbService.DBService;
import model.Items;
import model.MapModel;
import model.enemy.Enemy;
import profile.PlayerProfile;
import views.console.BattleMapView;
import views.console.CreateHeroView;
import views.console.ListCreatedHeroView;
import views.console.StartView;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dkotenko on 11/20/18.
 */
public class ConsoleController {

    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private StartView consoleView;
    private DBService dbService;

    public ConsoleController(DBService dbService){
        this.dbService = dbService;
        consoleView = new StartView();
    }


    public void startConsole() {
        Scanner input = new Scanner(System.in);
        consoleView.startWindow();
        if (input.hasNext()) {
            switch (input.next()) {
                case "1":
                    System.out.print("\033\143");
                    createHeroConsole();
                    break;
                case "2":
                    listCreatedHero();
                    break;
                case "3":
                    System.exit(1);
                    break;
                default:
                    startConsole();
                    break;
            }
        }
    }

    private void createHeroConsole() {
        PlayerProfile playerProfile = null;
        String name;
        CreateHeroView createHeroView = new CreateHeroView();
        Scanner input = new Scanner(System.in);


        createHeroView.heroName();
        if (input.hasNext()) {
            name = input.next();
            while (dbService.getPlayer(name) != null) {
                System.out.print("\033\143");
                System.out.println(ANSI_YELLOW + "Name is taken");
                createHeroView.heroName();
                if (input.hasNext())
                    name = input.next();
                else
                    System.exit(1);
            }

            createHeroView.heroClass();
            while (playerProfile == null) {
                if (input.hasNext()) {
                    switch (input.next()) {
                        case "1":
                            playerProfile = dbService.createPlayer(name, 1);
                            break;
                        case "2":
                            playerProfile = dbService.createPlayer(name, 2);
                            break;
                        case "3":
                            playerProfile = dbService.createPlayer(name, 3);
                            break;
                        default:
                            System.out.print("\033\143");
                            System.out.println(ANSI_YELLOW + "Error input");
                            createHeroView.heroClass();
                    }
                }
                else
                    System.exit(1);
            }
            battleRun(playerProfile);
        }
    }

    private void listCreatedHero() {
        HashMap<Integer, String> players = dbService.getMapPlayers();
        ListCreatedHeroView view = new ListCreatedHeroView();
        Scanner input = new Scanner(System.in);
        PlayerProfile player = null;
        int select;

        view.listCreatedHero(players, false);
        while (true) {
            if (input.hasNextInt()) {
                select = input.nextInt();

                String name = players.get(select);
                if (name != null) {
                    player = dbService.getPlayer(name);
                    battleRun(player);
                    break;
                }
                view.listCreatedHero(players, true);
            }
            else if (input.hasNext()) {
                if (input.next().equals("e")) {
                    startConsole();
                    break;
                }
                view.listCreatedHero(players, true);
            }
            else
                System.exit(1);
        }
    }

    private void battleRun(PlayerProfile playerProfile) {
        MapModel mapModel = new MapModel();
        BattleMapView battleMapView = new BattleMapView();
        Scanner input = new Scanner(System.in);
        String inputStr;


        while (true) {
            battleMapView.mapView(mapModel, playerProfile, null);

            if (input.hasNext()) {
                inputStr = input.next();
                switch (inputStr) {
                    case "north":
                    case "w":
                        if (playerProfile.getMoveHeight() == 19)
                            deathOrWin(battleMapView, false);
                        else if (playerProfile.moveItHeight(true) && mapModel.movePlayer("North"))
                            pvm(battleMapView, mapModel, playerProfile);
                        break;
                    case "south":
                    case "s":
                        if (playerProfile.getMoveHeight() == -19)
                            deathOrWin(battleMapView, false);
                        else if (playerProfile.moveItHeight(false) && mapModel.movePlayer("South"))
                            pvm(battleMapView, mapModel, playerProfile);
                        break;
                    case "east":
                    case "d":
                        if (playerProfile.getMoveWith() == -19)
                            deathOrWin(battleMapView, false);
                        else if (playerProfile.moveItWith(false) && mapModel.movePlayer("East"))
                            pvm(battleMapView, mapModel, playerProfile);
                        break;
                    case "west":
                    case "a":
                        if (playerProfile.getMoveWith() == 19)
                            deathOrWin(battleMapView, false);
                        else if (playerProfile.moveItWith(true) && mapModel.movePlayer("West"))
                            pvm(battleMapView, mapModel, playerProfile);
                        break;
                    case "exit":
                        startConsole();
                        break;
                }
            }
            else
                System.exit(1);
        }
    }

    private void pvm(BattleMapView battleMapView, MapModel mapModel, PlayerProfile playerProfile) {
        String inputStr;
        Enemy enemy = mapModel.getElementPlayer().getEnemy();
        Scanner input = new Scanner(System.in);
        String event =
                        ANSI_YELLOW + "To Battle    -> 'y'\n" +
                        ANSI_YELLOW + "To Run (50%) -> 'n'\n" +
                        ANSI_RED + "Enemy info\n" +
                        ANSI_RED + "Name        : " + enemy.getName() + "\n" +
                        ANSI_RED + "Level       : " + enemy.getLevel() + "\n" +
                        ANSI_RED + "Attack      : " + enemy.getAttack() + "\n" +
                        ANSI_RED + "Defense     : " + enemy.getDefense() + "\n" +
                        ANSI_RED + "Hit Points  : " + enemy.getHitPoints();

        while (true) {
            battleMapView.mapView(mapModel, playerProfile, event);
            if (input.hasNext()) {
                inputStr = input.next();
                if (inputStr.equals("y")) {
                    pvmBattle(playerProfile, mapModel.getElementPlayer().getEnemy(),
                            battleMapView, mapModel);
                    break;
                } else if (inputStr.equals("n")) {
                    try {
                        Random random = new Random();
                        if (random.nextBoolean()) {
                            battleMapView.mapView(mapModel, playerProfile, ANSI_GREEN + "Escape was a success");
                            Thread.sleep(1000);
                        } else {
                            battleMapView.mapView(mapModel, playerProfile, ANSI_RED + "Escape failed");
                            Thread.sleep(1000);
                            pvmBattle(playerProfile, mapModel.getElementPlayer().getEnemy(),
                                    battleMapView, mapModel);
                        }
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else
                System.exit(1);

        }
    }

    private void pvmBattle(PlayerProfile playerProfile, Enemy enemy,
                           BattleMapView battleMapView, MapModel mapModel) {
        String battleInfo;
        boolean movePlayer = true;
        double random;


        int attackPlayer = playerProfile.getAttack() + playerProfile.getIncAttack();
        int defensePlayer = playerProfile.getDefense() + playerProfile.getIncDefense();
        int hitPointsPlayer = playerProfile.getHitPoints() + playerProfile.getIncHitPoints();

        int attackEnemy = enemy.getAttack();
        int defenseEnemy = enemy.getDefense();
        int hitPointsEnemy = enemy.getHitPoints();

        int damage;

        while (hitPointsEnemy > 0) {
            random = ThreadLocalRandom.current().nextDouble(-0.5, 0.6);
            if (movePlayer) {
                damage = attackPlayer + (int) (attackPlayer * random) - defenseEnemy;
                if (damage < 0)
                    damage = 0;
                hitPointsEnemy = hitPointsEnemy - damage;
            }
            else {
                damage = attackEnemy + (int) (attackEnemy * random) - defensePlayer;
                if (damage < 0)
                    damage = 0;
                hitPointsPlayer = hitPointsPlayer - damage;
            }

            if (hitPointsEnemy <= 0) {
                battleInfo = ANSI_YELLOW + "BATTLE\n\n" +
                        ANSI_GREEN + "The Enemy is down\n" +
                        ANSI_GREEN + "Hit Points Player: " + hitPointsPlayer + "\n" +
                        ANSI_RED + "Hit Points Enemy: 0\n" +
                        ANSI_GREEN + "Experience +" + enemy.getExperience();
                mapModel.getElementPlayer().setEnemy(null);
                if (playerProfile.getLevel() != 7)
                    playerProfile.setExperience(playerProfile.getExperience() + enemy.getExperience());
                dbService.updatePlayerLevel(playerProfile);
                chanceItem(enemy.getLevel(), battleMapView, mapModel, playerProfile);
            }
            else if (hitPointsPlayer <= 0) {
                dbService.undressPlayer(playerProfile.getName());
                deathOrWin(battleMapView, true);
                break;
            }
            else if (movePlayer) {
                battleInfo = ANSI_YELLOW + "BATTLE\n\n" +
                        ANSI_GREEN + "Player deals damage " + damage + "\n" +
                        ANSI_GREEN + "Hit Points Player: " + hitPointsPlayer + "\n" +
                        ANSI_RED + "Hit Points Enemy: " + hitPointsEnemy;
                movePlayer = false;
            }
            else {
                battleInfo = ANSI_YELLOW + "BATTLE\n\n" +
                        ANSI_RED + "Enemy deals damage " + damage + "\n" +
                        ANSI_GREEN + "Hit Points Player: " + hitPointsPlayer + "\n" +
                        ANSI_RED + "Hit Points Enemy: " + hitPointsEnemy;
                movePlayer = true;
            }

            battleMapView.mapView(mapModel, playerProfile, battleInfo);

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void chanceItem(int level, BattleMapView battleMapView, MapModel mapModel, PlayerProfile playerProfile) {
        int random = ThreadLocalRandom.current().nextInt(0,10);
        Items items = new Items(level);

        String event = ANSI_YELLOW + "LOOT\n" +
                ANSI_YELLOW + "Name        : " + items.getName() + "\n" +
                ANSI_YELLOW + "Type        : " + items.getType() + "\n" +
                ANSI_YELLOW + "Description : " + items.getDescription() + "\n\n" +
                ANSI_YELLOW + "Apply to the hero?\n" +
                ANSI_YELLOW + "Yes    -> 'y'\n" +
                ANSI_YELLOW + "No     -> 'n'";

        String inputStr;
        Scanner input = new Scanner(System.in);

        if (random <= 3) {
            while (true) {
                battleMapView.mapView(mapModel, playerProfile, event);
                if (input.hasNext()) {
                    inputStr = input.next();
                    if (inputStr.equals("y")) {
                        items.setPlayerItems(playerProfile);
                        break;
                    } else if (inputStr.equals("n"))
                        break;
                }
                else
                    System.exit(1);
            }
        }
    }

    private void deathOrWin(BattleMapView battleMapView, boolean death) {
        Scanner input = new Scanner(System.in);
        String inputStr;

        while (true) {
            if (death)
                battleMapView.death();
            else
                battleMapView.win();
            if (input.hasNext()) {
                inputStr = input.next();
                if (inputStr.equals("e")) {
                    startConsole();
                    break;
                }
            }
            else
                System.exit(1);
        }
    }
}
