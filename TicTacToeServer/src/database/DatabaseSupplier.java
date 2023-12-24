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
import java.util.ArrayList;

public class DatabaseSupplier {

    Connection con;
    PreparedStatement pst;
    ResultSet r;
    Gson gson = new Gson();

    public DatabaseSupplier() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/GameLogic", "root", "root");
            pst = con.prepareStatement("select * from  PLAYER ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            r = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isUserNameExist(String userName) throws SQLException {
        r.beforeFirst();
        while (r.next()) {
            if (r.getString("userName").equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public int registerPlayer(String json) {

        try {
            PlayerDetails playerDetails = gson.fromJson(json, PlayerDetails.class);
            if (isUserNameExist(playerDetails.getUserName())) {
                return 0;
            }
            pst = con.prepareStatement("insert into Player (username , password , name ) values (? , ? , ?)");
            pst.setString(1, playerDetails.getUserName());
            pst.setString(2, playerDetails.getPassword());
            pst.setString(3, playerDetails.getName());
            pst.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
   public int loginPlayer(String str){
      try {
            PlayerDetails playerDetails = gson.fromJson(str, PlayerDetails.class);
          
            pst = con.prepareStatement("select * from Player where USERNAME = ? AND PASSWORD = ?");
            pst.setString(1, playerDetails.getUserName());
            pst.setString(2, playerDetails.getPassword());
            
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                 pst = con.prepareStatement("update Player set STATUS = ? where USERNAME = ? ");
                 pst.setBoolean(1, true);
                 pst.setString(2, playerDetails.getUserName());
                 pst.executeUpdate();
                return 1;
            }
            else
            {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } 
       
   }
   
   public ArrayList<PlayerDetails> getOnlineUsers(String username)
   {
        ArrayList<PlayerDetails> players = new ArrayList<>();
        try {
            pst = con.prepareStatement("select * from Player where STATUS = ? AND ISPLAY = ? AND USERNAME<>?");
            pst.setBoolean(1, true);
            pst.setBoolean(2, false);
            pst.setString(3,username);
            ResultSet res = pst.executeQuery();
            while(true)
            {
                
                if(!res.next())
                {
                    break;
                }
                else
                {
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
        }
            
       
       
       return players;
       
   }
   
   public PlayerDetails getPlayer(String username)
   {
       PlayerDetails player = new PlayerDetails();
        try {
            pst = con.prepareStatement("select * from Player where USERNAME = ?");
            pst.setString(1,username);

            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                player.setUserName(res.getString(1));
                player.setPassword(res.getString(2));
                player.setName(res.getString(3));
                player.setScore(res.getInt(4));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player ;
   }
}
