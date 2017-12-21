package main_package;

import com.sun.javaws.progress.PreloaderPostEventListener;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/collége?autoReconnect=true&useSSL=false","root","Dali123");
            statement = connect.createStatement();
            connect.prepareStatement("DELETE FROM cours WHERE type_cours = 'français'").executeUpdate();
            resultSet = statement.executeQuery("select * from cours");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
