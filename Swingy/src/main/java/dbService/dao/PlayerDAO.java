package dbService.dao;

import dbService.executor.Executor;
import profile.PlayerProfile;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dkotenko on 11/21/18.
 */
public class PlayerDAO {
    private Executor executor;

    public PlayerDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists players (id bigint auto_increment, " +
                "name varchar(256), class varchar(256), level int, experience int, attack int, defense int, hit_points int, " +
                "weapon_name varchar(256), inc_attack int, " +
                "armor_name varchar(256), inc_defense int, " +
                "helm_name varchar(256), inc_hit_points int)");
    }

    public void cleanup() throws SQLException {
        executor.execUpdate("drop table players");
    }

    public void insertPlayer(PlayerProfile playerProfile) throws SQLException {
        executor.execUpdate("insert into players (name, class, level, attack, defense, hit_points, " +
                "weapon_name, armor_name, helm_name) " +
                "values ('" + playerProfile.getName()
                + "','" + playerProfile.getpClass()
                + "','" + 1
                + "','" + playerProfile.getAttack()
                + "','" + playerProfile.getDefense()
                + "','" + playerProfile.getHitPoints()
                + "','" + ""
                + "','" + ""
                + "','" + "" + "')");
    }

    public PlayerProfile getPlayer(String name) throws SQLException {
        return executor.execQuery("select * from players where name='" + name + "'", result -> {
           if (!result.next())
               return null;
           PlayerProfile playerProfile = new PlayerProfile(result.getString(2), result.getString(3));
           playerProfile.setLevel(result.getInt(4));
           playerProfile.setExperience(result.getInt(5));
           playerProfile.setAttack(result.getInt(6));
           playerProfile.setDefense(result.getInt(7));
           playerProfile.setHitPoints(result.getInt(8));
           playerProfile.setWeaponName(result.getString(9));
           playerProfile.setIncAttack(result.getInt(10));
           playerProfile.setArmorName(result.getString(11));
           playerProfile.setIncDefense(result.getInt(12));
           playerProfile.setHelmName(result.getString(13));
           playerProfile.setIncHitPoints(result.getInt(14));
           return playerProfile;
        });
    }

    public HashMap<Integer, String> getMapPlayers() throws SQLException {
        HashMap<Integer, String> playersMap = new HashMap<Integer, String>();
        return executor.execQuery("select * from players", result -> {
            /*if (!result.next())
                return null;*/
            for(int i = 0; result.next(); i++)
                playersMap.put(i, result.getString(2));
            if (playersMap.isEmpty())
                return null;
            return playersMap;
        });
    }

    public ArrayList<String> getListPlayers() throws SQLException {
        ArrayList<String> playersList = new ArrayList<String>();
        return executor.execQuery("select * from players", result -> {
            /*if (!result.next())
                return null;*/
            for(int i = 0; result.next(); i++)
                playersList.add(result.getString(2));
            if (playersList.isEmpty())
                return null;
            return playersList;
        });
    }

    public void updatePlayerLevel(PlayerProfile playerProfile) throws SQLException {
        executor.execUpdate("update players set level = " + playerProfile.getLevel() +
        ", experience = " + playerProfile.getExperience() +
        ", attack = " + playerProfile.getAttack() +
        ", defense = " + playerProfile.getDefense() +
        ", hit_points = " + playerProfile.getHitPoints() +
        "where name = '" + playerProfile.getName() + "'");
    }

    public void updateWeapon(String namePlayer, String nameWeapon, int incAttack) throws SQLException {
        executor.execUpdate("update players set weapon_name = '" + nameWeapon +
                "', inc_attack = " + incAttack +
                "where name = '" + namePlayer + "'");
    }

    public void updateArmor(String namePlayer, String nameArmor, int incDefense) throws SQLException {
        executor.execUpdate("update players set armor_name = '" + nameArmor +
                "', inc_defense = " + incDefense +
                "where name = '" + namePlayer + "'");
    }

    public void updateHelm(String namePlayer, String nameHelm, int incHitPoints) throws SQLException {
        executor.execUpdate("update players set helm_name = '" + nameHelm +
                "', inc_hit_points = " + incHitPoints +
                "where name = '" + namePlayer + "'");
    }

    public void undressPlayer(String namePlayer) throws SQLException {
        executor.execUpdate("update players set weapon_name = '', armor_name = '', helm_name = '', " +
                "inc_attack = 0, inc_defense = 0, inc_hit_points = 0" +
                "where name = '" + namePlayer + "'");
    }
}
