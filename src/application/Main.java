package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    @Override
    public void start(Stage splash) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("splash.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        splash.setScene(scene);
        splash.setMinHeight(640);
        splash.setMaxHeight(640);
        splash.setMinWidth(600);
        splash.setMaxWidth(600);
        splash.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
