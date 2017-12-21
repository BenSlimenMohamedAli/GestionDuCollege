package main_package;

import java.sql.*;

public class Eleve {
    private int num_inscri;
    private String nom;
    private String prenom;
    private int num_classe;
    private int num_niveau;

    // Constructor

    public Eleve(String nom, String prenom, int num_classe, int num_niveau) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_classe = num_classe;
        this.num_niveau = num_niveau;
    }

    // Setters et getters

    public int getNum_inscri() {
        return num_inscri;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNum_classe() {
        return num_classe;
    }

    public void setNum_classe(int num_classe) {
        this.num_classe = num_classe;
    }

    public int getNum_niveau() {
        return num_niveau;
    }

    public void setNum_niveau(int num_niveau) {
        this.num_niveau = num_niveau;
    }

    //La méthode connecter

    public static boolean connecter(String username,int password){
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/collége?autoReconnect=true&useSSL=false","root","Dali123");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select* from eleve where num_inscri = '"+password+"' and nom ='"+username+"'");
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
