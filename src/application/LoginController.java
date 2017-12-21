package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import main_package.*;


public class LoginController {
    @FXML
    Label result;
    @FXML
    private Button connecter;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ToggleGroup choix;
    @FXML
    private RadioButton choixEleve;
    @FXML
    private RadioButton choixEnseignant;
    @FXML
    public void initialize(){
    }

    @FXML
    protected void seConnecter(){
        if(choixEnseignant.isSelected()){
            if( Enseignant.connecter(username.getText(),password.getText().equals("")? 0:Integer.parseInt(password.getText())) )
                result.setText("Vous étes connecté"); // TODO
            else
                result.setText("Vérifier vos données");
        }else{
            if(Eleve.connecter(username.getText(),password.getText().equals("")? 0:Integer.parseInt(password.getText()))){
                result.setText("Vous étes connecté");
            }else{
                result.setText("Verifier vos données");
            }
        }
    }
}
