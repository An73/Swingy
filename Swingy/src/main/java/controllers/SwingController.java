package controllers;

import dbService.DBService;
import model.MapModel;
import profile.PlayerProfile;
import views.swing.*;

import javax.swing.*;

/**
 * Created by dkotenko on 12/3/18.
 */
public class SwingController {
    private DBService dbService;
    private PlayerProfile playerProfile;
    private MapModel mapModel;

    public SwingController() {
        dbService = new DBService();
        mapModel = new MapModel();
    }

    public void toMainWindow(JFrame frame) {
        JFrame startWindow = new StartWindow();
        if (frame != null)
            frame.setVisible(false);
        startWindow.setVisible(true);
    }

    public void toCreateWindow(JFrame frame) {
        JFrame createWindow = new CreateWindow();
        if (frame != null)
            frame.setVisible(false);
        createWindow.setVisible(true);
    }

    public void toListWindow(JFrame frame) {
        JFrame listWindow = new ListWindow();
        if (frame != null)
            frame.setVisible(false);
        listWindow.setVisible(true);
    }

    public void toBattleWindow(JFrame frame, String name) {
        playerProfile = dbService.getPlayer(name);
        if (playerProfile != null) {
            JFrame battleWindow = new BattleWindow(playerProfile, mapModel);
            if (frame != null)
                frame.setVisible(false);
            battleWindow.setVisible(true);
        }
    }

    public void createHero(String name, int pClass){
        if (!name.isEmpty() && dbService.getPlayer(name) == null)
            playerProfile = dbService.createPlayer(name, pClass);
        else
            JOptionPane.showMessageDialog(null, "Name is taken or empty.");
    }

    public void toDialogChoiceBattle() {
        JFrame dialogChoiceBattle = new DialogChoiceBattle();
        dialogChoiceBattle.setVisible(true);
    }
}
