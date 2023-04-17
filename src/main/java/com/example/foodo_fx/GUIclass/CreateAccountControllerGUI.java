package com.example.foodo_fx.GUIclass;


import com.example.foodo_fx.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.w3c.dom.Text;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
public class CreateAccountControllerGUI {


    @FXML
    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/mainSceneLogin.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    @FXML
    public void showPantry(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneMyPantry.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    @FXML
    public void showSearch(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneSearchProduct.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    @FXML
    public void showLogin(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneLogin.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private PasswordField setPasswordField;
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField favoriteFoodTextField;

    @FXML
    private TextField typeOfDietTextField;





    public void confirmButtonAction(ActionEvent event) throws IOException{

        Connection myConnection = DBConnection.getDBConnection();


        String username = usernameTextField.getText();
        String favoritefood= favoriteFoodTextField.getText();
        String typeOfdiet= typeOfDietTextField.getText();
        String password = setPasswordField.getText();
        String insertFields = "INSERT INTO  user_account(username, favoritefood, typeOfdiet, password) VALUES ('";
        String insertValues = username + "','" + favoritefood + "','" + typeOfdiet + "','" + password + "')";
        String insertToRegister= insertFields + insertValues;

        try {
            Statement statement = myConnection.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationMessageLabel.setText("User has been registered succesfully!");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void showMainLogScene(ActionEvent event) throws IOException{
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/mainSceneLogin.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }
}
