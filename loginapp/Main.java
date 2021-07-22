package loginapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static dbUtil.dbConnection.getConnection;


public class Main {


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        LoginModel loginModel = new LoginModel();


        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        try {
            if(loginModel.isLogin(username,password)){
                Integer id= getId(username);
                System.out.println("Do you want to add, edit or delete event");
                String typeEvent = scanner.nextLine();
                System.out.println("Enter date");
                String date = scanner.nextLine();
                System.out.println("Enter time");
                String time = scanner.nextLine();

                if(typeEvent.equals("add")){
                    System.out.println("Enter title/description");
                    String title = scanner.nextLine();
                    System.out.println("Enter location");
                    String location = scanner.nextLine();

                    String sqlText = String.format("INSERT INTO events  VALUES (NULL,'%s', '%s', '%s','%s',%d);",date,time,title,location,id);
                    addUpdateDeleteElement(sqlText);
                }else if(typeEvent.equals("edit")){
                    System.out.println("Enter the new title/description");
                    String title = scanner.nextLine();
                    System.out.println("Enter the new location");
                    String location = scanner.nextLine();

                    String sqlText = String.format("UPDATE events SET title='%s',location='%s' WHERE  users_id=%d and dateOfEvent='%s' and timeOfEvent='%s';",title,location,id,date,time);
                    addUpdateDeleteElement(sqlText);
                }
                else if(typeEvent.equals("delete")){
                    String sqlText = String.format("DELETE FROM events WHERE dateOfEvent='%s' and timeOfEvent='%s' and users_id=%d;",date,time,id);
                    addUpdateDeleteElement(sqlText);
                }
                else {
                    System.out.println("Invalid input");
                }
            }else {
                System.out.println("You don't have an account. You need to sign up.");
                System.out.println("Enter username");
                String new_username = scanner.nextLine();
                System.out.println("Enter password");
                String new_password = scanner.nextLine();
                System.out.println("Enter first name");
                String firstName= scanner.nextLine();
                System.out.println("Enter last name");
                String lastName = scanner.nextLine();
                System.out.println("Enter the city you live in");
                String city = scanner.nextLine();
                System.out.println("Enter your birthday");
                String dateOfBirth = scanner.nextLine();

                String sqlText = String.format("INSERT INTO users_cale VALUES (NULL,'%s','%s','%s','%s','%s','%s');",new_username,new_password,firstName,lastName,city,dateOfBirth);
                addUpdateDeleteElement(sqlText);

                System.out.println("Go back to login");
            }
        }catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public static void addUpdateDeleteElement(String sqlText) throws SQLException{
        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            myStmt.executeUpdate(sqlText);

        } catch (SQLException e) {
            System.out.println("SQLException found in the codee");
        }
    }

    public static int getId(String username) throws SQLException{
        Integer result=-1;
        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            String sql = String.format("SELECT * FROM users_cale WHERE username='%s'",username);

            ResultSet rs = myStmt.executeQuery(sql);
            while (rs.next()) {
                result = rs.getInt("id");
            }
            return result;
        } catch (SQLException e) {
            System.out.println("SQL Exception found in the code, we did not got role");
        }
        return result;
    }
}
