package loginapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dbUtil.dbConnection.getConnection;

public class LoginModel {
    Connection connection;

    public LoginModel() throws SQLException {
        try {
            this.connection = getConnection();
        }catch (SQLException e){
            System.out.println("SQL Exception found in the code");
        }
    }

    public boolean isDatabaseConnected(){
        return this.connection != null;
    }

    public boolean isLogin(String user, String password) throws SQLException{
        String result="";
        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            String sql = String.format("SELECT * FROM users_cale WHERE username ='%s'",user);
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next()) {
                result = rs.getString("password");
                if(result.equals(password))
                    return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }


}
