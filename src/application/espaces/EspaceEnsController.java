package application.espaces;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main_package.Enseignement;
import main_package.Séance;
import sun.plugin.javascript.navig.Anchor;

import java.sql.*;
import java.util.ArrayList;


public class EspaceEnsController {
    @FXML private AnchorPane ap;
    @FXML private Text aCin,aNom,aProf;

    public static String user;
    public static int pass;

    Connection connect = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null , resultSet1 = null;

    ArrayList<Enseignement> enseignements = new ArrayList<>(); // La liste des matiéres qu'il enseigne
    ArrayList<Séance> séances = new ArrayList<>(); // La liste des séances assurée par l'enseignant
    String ens= "";

    public void initialize() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/collége?autoReconnect=true&useSSL=false","root","Dali123");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * FROM enseignement where cin_ens = '"+pass+"'");
            while(resultSet.next()){
                enseignements.add(new Enseignement(resultSet.getInt("cin_ens"),resultSet.getString("type_cours").toString()));
                ens += resultSet.getString("type_cours")+", ";
            }
            aNom.setText(user);
            aCin.setText(pass+"");
            aProf.setText(ens);

            resultSet1 = statement.executeQuery("SELECT * from séance where cin_ens = '"+pass+"'");
            while(resultSet1.next()){
                séances.add(new Séance(resultSet1.getInt("num_séance"),resultSet1.getTime("heure_séance"),resultSet1.getString("jour_séance"),resultSet1.getInt("num_niveau"),resultSet1.getInt("num_classe"),resultSet1.getInt("cin_ens"),resultSet1.getString("type_cours"),resultSet1.getInt("num_salle")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
