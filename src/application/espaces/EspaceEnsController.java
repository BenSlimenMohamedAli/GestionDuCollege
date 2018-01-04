package application.espaces;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import main_package.Enseignement;
import main_package.Séance;
import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;


public class EspaceEnsController {
    @FXML private AnchorPane ap;
    @FXML private Text aCin,aNom,aProf;
    @FXML private ListView<String> listséance;

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

        ObservableList<String> items = listséance.getItems();
        ArrayList<Séance> séances = new ArrayList<>();
        séances = Séance.getListSeances(pass);
        for (int i =0;i<séances.size();i++){
            items.add(séances.get(i).toString());
        }

        // Si en click sur un élément de la liste
        listséance.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {


                });




    }


}
