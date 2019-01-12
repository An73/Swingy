package views.swing;

import controllers.SwingController;
import dbService.DBService;
import views.swing.viewElement.JListPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dkotenko on 12/6/18.
 */
public class ListWindow extends JFrame {
    private JFrame thisFrame;
    private JList<String> listPlayers;
    private DBService dbService;
    private SwingController swingController;

    public ListWindow(){
        super("Swing");
        thisFrame = this;
        dbService = new DBService();
        swingController = new SwingController();
        listPlayers = getListPlayers(dbService.getListPlayers());
        add(createMainPanel());
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JPanel createMainPanel() {
        JPanel panel = new JListPanel(listPlayers, thisFrame);
        panel.setBorder(new EmptyBorder(50, 50, 100, 50));
        // create list book and set to scrollpane and add to panel
        JScrollPane scrollPane = new JScrollPane(listPlayers);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);
        return panel;
    }

    private JList<String> getListPlayers(ArrayList<String> list) {
        JList<String> listPlayers;
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : list)
            model.addElement(s);
        listPlayers = new JList<String>(model);
        listPlayers.setOpaque(false);
        listPlayers.setBackground(new Color(0, 0, 0, 0));
        listPlayers.setForeground(Color.ORANGE);
        listPlayers.setFont(new Font("Luminari", Font.BOLD, 20));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer)listPlayers.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        return listPlayers;

    }
}
