package controllers;

import dbService.DBService;
import views.swing.StartWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dkotenko on 12/3/18.
 */
public class SwingController {
    private DBService dbService;

    public SwingController(DBService dbService) {
        this.dbService = dbService;
    }

    public void startGUI() {
        JFrame startWindow = new StartWindow();
        startWindow.setVisible(true);
    }
}
