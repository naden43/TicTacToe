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
}
