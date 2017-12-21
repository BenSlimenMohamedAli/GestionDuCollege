package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    @Override
    public void start(Stage login) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_page.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.setMinHeight(440);
        login.setMaxHeight(440);
        login.setMinWidth(615);
        login.setMaxWidth(615);
        login.setTitle("Login page");
        login.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
