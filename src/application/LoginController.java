package application;

import application.espaces.EspaceEnsController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main_package.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import application.espaces.*;


public class LoginController {
    @FXML
    private AnchorPane ap;
    @FXML
    private Label result;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private RadioButton choixEnseignant;
    @FXML
    public void initialize(){
    }

    @FXML
    protected void seConnecter(){
        // Si le choix est enseignant
        if(choixEnseignant.isSelected()){
            // Si l'enseignant existe
            if( Enseignant.connecter(username.getText(),password.getText().equals("")? 0:Integer.parseInt(password.getText())) ){
                try{
                    Platform.runLater(()->{
                        Stage ens = new Stage();
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("espaces/espace_ens.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(EspaceEnsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Scene scene = new Scene(root);
                        ens.setScene(scene);
                        ens.show();
                        ens.setMinHeight(600);
                        ens.setMaxHeight(600);
                        ens.setMinWidth(800);
                        ens.setMaxWidth(800);
                        ens.setTitle(String.valueOf(username.getText()));
                        ap.getScene().getWindow().hide();
                    });
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            // Si l'enseignant n'existe pas
            else{
                result.setText("Vérifier vos données");
            }
        // Si le choix est eleve
        }else{
            // Si léleve est existe
            if(Eleve.connecter(username.getText(),password.getText().equals("")? 0:Integer.parseInt(password.getText()))){
                result.setText("Vous étes connecté");
            // S'il n'existe pas
            }else{
                result.setText("Vérifier vos données");
            }
        }
    }
}
