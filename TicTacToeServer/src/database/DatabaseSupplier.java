package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;
import com.google.gson.Gson;

public class DatabaseSupplier {

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
            String query = "SELECT username, name, score FROM ROOT.PLAYER WHERE USERNAME = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, username);
            resultSet = pstm.executeQuery();

            // Check if the resultSet has an entry
            if (resultSet.next()) {
                playerDetails.setUserName(resultSet.getString("username"));
                playerDetails.setName(resultSet.getString("name"));
                playerDetails.setScore(resultSet.getInt("score"));
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

}
