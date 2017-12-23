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
    @FXML private AnchorPane ap;
    @FXML private Label result;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private RadioButton choixEnseignant;
    @FXML
    public void initialize(){
    }

    @FXML
    protected void seConnecter() {
        // Si le choix est enseignant

        String user = username.getText();
        int pass = -1;
        if(password.getText().equals("")){
            pass = -1;
        }else{
            try{
                pass =Integer.parseInt(password.getText());
            }catch(Exception e){
                e.getMessage();
            }
        }
        if(choixEnseignant.isSelected()){
            // Si l'enseignant existe
            if( Enseignant.connecter(user,pass)){
                EspaceEnsController.user = user;
                EspaceEnsController.pass = pass;

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
                        ens.setMinHeight(730);
                        ens.setMaxHeight(730);
                        ens.setMinWidth(1000);
                        ens.setMaxWidth(1000);
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
            if(Eleve.connecter(user,pass)){
                try{
                    Platform.runLater(()->{
                        Stage ens = new Stage();
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("espaces/espace_eleve.fxml"));
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
            // S'il n'existe pas
            }else{
                result.setText("Vérifier vos données");
            }
        }
    }
}
