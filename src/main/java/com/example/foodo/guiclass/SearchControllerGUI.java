package com.example.foodo.guiclass;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchControllerGUI {

    @FXML
    public void showLogin(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneLogin.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }
    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/mainSceneLogin.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
    @FXML
    public void showPantry(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneMyPantry.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }
}