package main_package;

import java.sql.*;

public class Enseignant {
    private int cin;
    private String nom_ens;

    // Constructor

    public Enseignant(int cin, String nom_ens) {
        this.cin = cin;
        this.nom_ens = nom_ens;
    }

    // Setters et Getters

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom_ens() {
        return nom_ens;
    }

    public void setNom_ens(String nom_ens) {
        this.nom_ens = nom_ens;
    }

    // La connection d'enseignant
    public static boolean connecter(String username,int password){
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/collége?autoReconnect=true&useSSL=false","root","Dali123");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select* from enseignant where cin_ens = '"+password+"' and nom_ens ='"+username+"'");
            int c =0;
            while(resultSet.next()){
                c++;
            }
            if(c != 0) return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;


    }
}
