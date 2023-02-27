package neu.edu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import neu.edu.data.UserRegistration;
import neu.edu.data.UserSession;
import neu.edu.database.DBConnector;
public class RegistrationDAO {
    private Connection connection;
    public boolean register(String username,String password, String firstName, String lastName, String email, String role){
        PreparedStatement pst = null;
        boolean status=false;
        try {
            connection = DBConnector.getInstance().getConnection();
            pst = connection.prepareStatement("INSERT INTO user (username, password,firstName,lastName,email,role) VALUES (?, MD5(?),?,?,?,?)");
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, firstName);
            pst.setString(4, lastName);
            pst.setString(5, email);
            pst.setString(6, role);
            int rowsInserted = pst.executeUpdate();
            System.out.println(rowsInserted);
            if (rowsInserted > 0) {
                status=true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }
    
    public UserSession user_exists(String username, String password) {
    	
        Connection connection = DBConnector.getInstance().getConnection();
        try {

            PreparedStatement pst = null;
            pst = connection.prepareStatement("SELECT * FROM user where password = md5(?)");
            pst.setString(1, password);
            ResultSet rs = pst.executeQuery();
            System.out.println("result set" + rs);
            while(rs.next()){
            	String username_db = rs.getString("username");
                String email_db = rs.getString("email");
                if(username_db.equals(username) || email_db.equals(username)) {
                	String role = rs.getString("role");
                	UserSession userSession = new UserSession(username_db, email_db, role, "dashboard");
                	return userSession;
                }
             }
            	return null;
          } catch(SQLException se) {
             se.printStackTrace();
          }
		return null;
    }
}