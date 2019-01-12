package dbService;

import dbService.dao.PlayerDAO;
import model.Items;
import org.h2.jdbcx.JdbcDataSource;
import profile.PlayerProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dkotenko on 11/20/18.
 */
public class DBService {
    private final Connection connection;

    public DBService(){
        this.connection = getH2Connection();
    }

    public void create(){
        try {
            new PlayerDAO(connection).createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PlayerProfile createPlayer(String name, int pClass) {
        PlayerProfile playerProfile;

        try {
            connection.setAutoCommit(false);
            PlayerDAO playerDAO = new PlayerDAO(connection);
            switch (pClass){
                case 1:
                    playerProfile = new PlayerProfile(name, "Warrior");
                    playerProfile.setAttack(20);
                    playerProfile.setDefense(5);
                    playerProfile.setHitPoints(90);
                    playerProfile.setLevel(1);
                    playerDAO.insertPlayer(playerProfile);
                    break;
                case 2:
                    playerProfile = new PlayerProfile(name, "Druid");
                    playerProfile.setAttack(12);
                    playerProfile.setDefense(15);
                    playerProfile.setHitPoints(110);
                    playerProfile.setLevel(1);
                    playerDAO.insertPlayer(playerProfile);
                    break;
                case 3:
                    playerProfile = new PlayerProfile(name, "Hunter");
                    playerProfile.setAttack(15);
                    playerProfile.setDefense(10);
                    playerProfile.setHitPoints(100);
                    playerProfile.setLevel(1);
                    playerDAO.insertPlayer(playerProfile);
                    break;
            }
            connection.commit();
            return playerDAO.getPlayer(name);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public PlayerProfile getPlayer(String name) {
        PlayerDAO playerDAO = new PlayerDAO(connection);
        try {
            return playerDAO.getPlayer(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<Integer, String> getMapPlayers() {
        PlayerDAO playerDAO = new PlayerDAO(connection);

        try {
            return playerDAO.getMapPlayers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getListPlayers() {
        PlayerDAO playerDAO = new PlayerDAO(connection);

        try {
            return playerDAO.getListPlayers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updatePlayerLevel(PlayerProfile playerProfile){
        PlayerDAO playerDAO = new PlayerDAO(connection);

        try {
            playerDAO.updatePlayerLevel(playerProfile);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(String namePlayer, Items item) {
        PlayerDAO playerDAO = new PlayerDAO(connection);

        try {
            switch (item.getType()){
                case "Weapon":
                    playerDAO.updateWeapon(namePlayer, item.getName(), item.getIncAttack());
                    break;
                case "Armor":
                    playerDAO.updateArmor(namePlayer, item.getName(), item.getIncDefense());
                    break;
                case "Helm":
                    playerDAO.updateHelm(namePlayer, item.getName(), item.getIncHitPoints());
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void undressPlayer(String namePlayer) {
        PlayerDAO playerDAO = new PlayerDAO(connection);

        try {
            playerDAO.undressPlayer(namePlayer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getH2Connection() {
        try {
            String url = "jdbc:h2:./h2db";
            String name = "dkotenko";
            String pass = "dkotenko";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
