package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.apache.derby.jdbc.ClientDriver;

public class DatabaseSupplier {

    //Connection con;
    PreparedStatement pst;
    ResultSet r;
    Gson gson = new Gson();

    public DatabaseSupplier() {
        registerDriver();
    }

    public void registerDriver() {
        try {
            DriverManager.registerDriver(new ClientDriver());
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int registerPlayer(String json) {
        PlayerDetails playerDetails = gson.fromJson(json, PlayerDetails.class);
        int resultStatement = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("insert into Player (username , password , name ) values (? , ? , ?)");
            pst.setString(1, playerDetails.getUserName());
            pst.setString(2, playerDetails.getPassword());
            pst.setString(3, playerDetails.getName());
            resultStatement = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeStatement(pst);
            closeConnection(con);
        }
        return resultStatement;
    }

    public boolean isUserNameExist(String userName) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("SELECT * FROM Player WHERE username = ?");
            pst.setString(1, userName);
            resultSet = pst.executeQuery();
            return resultSet.next();
        } finally {
            closeResultSet(resultSet);
            closeStatement(pst);
        }
    }

    private String getStoredPassword(String username) throws SQLException {
        Connection con = getConnection();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            con = getConnection();
            String query = "SELECT PASSWORD FROM ROOT.PLAYER WHERE USERNAME = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("PASSWORD");
            } else {
                return null;
            }
        } finally {
            closeResultSet(resultSet);
            closeStatement(pst);
            closeConnection(con);
        }
    }

    public PlayerDetails login(String json) {
        PlayerDetails playerDetails = gson.fromJson(json, PlayerDetails.class);
        PlayerDetails playerObject;
        Connection con = null;
        try {
            con = getConnection();
            if (isUserNameExist(playerDetails.getUserName())) {
                String storedPassword = getStoredPassword(playerDetails.getUserName());
                if (storedPassword != null && playerDetails.getPassword().equals(storedPassword)) {
                    playerObject = getPlayerObject(playerDetails.getUserName());
                    setStatus(true, playerDetails.getUserName());
                    return playerObject;
                } else {
                    System.out.println("error in first else in lging");
                    return null;
                }
            } else {
                System.out.println("error in second else in lging");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("SQL exception from login function");
            ex.printStackTrace();
            return null;
        } finally {
            closeConnection(con);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/GameLogic", "root", "root");
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(PreparedStatement pst) {
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private PlayerDetails getPlayerObject(String username) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        PlayerDetails playerDetails = new PlayerDetails();

        try {
            con = getConnection();
            String query = "SELECT username, name, score, password FROM ROOT.PLAYER WHERE USERNAME = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, username);
            resultSet = pstm.executeQuery();

            // Check if the resultSet has an entry
            if (resultSet.next()) {
                playerDetails.setUserName(resultSet.getString("username"));
                playerDetails.setName(resultSet.getString("name"));
                playerDetails.setScore(resultSet.getInt("score"));
                playerDetails.setPassword(resultSet.getString("password"));
            } else {
                // Handle case where no user is found
                System.out.println("No user found with username: " + username);
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("SQL exception in getPlayerObject");
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            closeResultSet(resultSet);
            closeStatement(pstm);
            closeConnection(con);
        }
        return playerDetails;
    }

    private void setStatus(boolean status, String username) {
        try {
            Connection con = null;
            PreparedStatement pstm = null;
            con = getConnection();
            String query = "Update Player SET STATUS = ? WHERE USERNAME = ? ";
            pstm = con.prepareStatement(query);
            pstm.setBoolean(1, status);
            pstm.setString(2, username);
            int result = pstm.executeUpdate();
            closeStatement(pstm);
            closeConnection(con);
        } catch (SQLException ex) {
            System.out.println("error in setStatus function in database");
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getOnlineCount() {
        try {
            int count;
            Connection con;
            PreparedStatement pstm;
            ResultSet resultSet;
            con = getConnection();
            String query = "SELECT COUNT(*) as ONLINE_PLAYERS FROM players WHERE status = ?";
            pstm = con.prepareStatement(query);
            pstm.setBoolean(1, true);
            resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("ONLINE_PLAYERS");
                closeStatement(pstm);
                closeConnection(con);
                return count;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int getOfflinePlayerCount() {
        try {
            int count;
            Connection con;
            PreparedStatement pstm;
            ResultSet resultSet;
            con = getConnection();
            String query = "SELECT COUNT(*) as OFFLINE_PLAYERS FROM players WHERE status = ?";
            pstm = con.prepareStatement(query);
            pstm.setBoolean(1, false);
            resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("OFFLINE_PLAYERS");
                closeStatement(pstm);
                closeConnection(con);
                return count;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public boolean getPlayerStatus(String str) {
        boolean status = false;
        try {
            PlayerDetails playerDetails = gson.fromJson(str, PlayerDetails.class);
            Connection con;
            PreparedStatement pstm;
            ResultSet resultSet;
            con = getConnection();
            String query = "SELECT STATUS FROM PLAYER WHERE USERNAME = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, playerDetails.getUserName());
            resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                status = resultSet.getBoolean("STATUS");
            }
            closeStatement(pstm);
            closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public ArrayList<PlayerDetails> getOnlineUsers(String username) {
        ArrayList<PlayerDetails> players = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("select * from Player where STATUS = ? AND ISPLAY = ? AND USERNAME<>?");
            pst.setBoolean(1, true);
            pst.setBoolean(2, false);
            pst.setString(3, username);
            ResultSet res = pst.executeQuery();
            while (true) {

                if (!res.next()) {
                    break;
                } else {
                    PlayerDetails player = new PlayerDetails();
                    player.setUserName(res.getString(1));
                    player.setPassword(res.getString(2));
                    player.setScore(res.getInt(4));
                    System.out.println(player.getUserName());
                    System.out.println(player.getPassword());
                    players.add(player);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatement(pst);
            closeConnection(con);
        }
        return players;

    }

    public PlayerDetails getPlayer(String username) {
        PlayerDetails player = new PlayerDetails();
        Connection con = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("select * from Player where USERNAME = ?");
            pst.setString(1, username);

            ResultSet res = pst.executeQuery();
            if (res.next()) {
                player.setUserName(res.getString(1));
                player.setPassword(res.getString(2));
                player.setName(res.getString(3));
                player.setScore(res.getInt(4));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatement(pst);
            closeConnection(con);
        }
        return player;
    }

    public void updateScore(double score, String userName) {
        int Userscore = 10 * (int) score;
        Connection con = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("select Score from PLAYER where USERNAME = ?");
            pst.setString(1, userName);
            ResultSet oldScore = pst.executeQuery();
            oldScore.next();
            Userscore += oldScore.getInt(1);
            pst = con.prepareStatement("update Player set SCORE = ? where USERNAME = ?");
            pst.setInt(1, Userscore);
            pst.setString(2, userName);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatement(pst);
            closeConnection(con);
        }
    }

    public void updateIsPlay(String player1, String player2) {
        Connection con = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("update Player set ISPLAY = ? where USERNAME = ?");
            pst.setBoolean(1, true);
            pst.setString(2, player1);
            pst.executeUpdate();
            pst = con.prepareStatement("update Player set ISPLAY = ? where USERNAME = ?");
            pst.setBoolean(1, true);
            pst.setString(2, player2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatement(pst);
            closeConnection(con);
        }
    }

    public void setIsPlay(String player1, String player2) {
        Connection con = null;
        try {
            con = getConnection();
            pst = con.prepareStatement("update Player set ISPLAY = ? where USERNAME = ?");
            pst.setBoolean(1, false);
            pst.setString(2, player1);
            pst.executeUpdate();
            pst = con.prepareStatement("update Player set ISPLAY = ? where USERNAME = ?");
            pst.setBoolean(1, false);
            pst.setString(2, player2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatement(pst);
            closeConnection(con);
        }
    }
        public boolean logOut(String json) {
        PlayerDetails playerDetails = gson.fromJson(json, PlayerDetails.class);
        Connection con = null;
        try {
            con = getConnection();
            setStatus(false, playerDetails.getUserName());
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public boolean changePass(String json) {
        PlayerDetails playerDetails = gson.fromJson(json, PlayerDetails.class);
        Connection con = null;
        try {
            con = getConnection();
            String query = "UPDATE Player SET PASSWORD = ? WHERE USERNAME = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, playerDetails.getPassword());
            pst.setString(2, playerDetails.getUserName());
            int result = pst.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            closeConnection(con);
        }
        return false;
    }
}
