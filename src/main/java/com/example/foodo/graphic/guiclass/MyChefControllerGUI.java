package com.example.foodo.graphic.guiclass;

import com.example.foodo.controllerappl.MyChefController;
import com.example.foodo.engineering.utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.geometry.Insets;

public class MyChefControllerGUI implements Initializable{

    @FXML
    public GridPane gridPane;
    @FXML
    public ScrollPane scroll;

    private MyListener myListener;
    private List<RecipeBean> recipeBeans1 = new ArrayList<>();



    private List<RecipeBean> getData() throws SQLException, ConnectionDbException {
        List<RecipeBean> recipeBeans = new ArrayList<>();
        //bisogna ottenere il numero di ricette che saranno presenti nella schermata
        //attraverso controller appl. ottengo le info delle sole ricette di chef seguiti dal utente
        //correntemente loggato
        MyChefController myChefController = new MyChefController();
        recipeBeans = myChefController.retriveItem();

        return recipeBeans;
    }
    public void backHome(ActionEvent event) throws IOException {
        Parent scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneHomeUser.fxml")));
        Scene sceneMainView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void initialize(URL location, ResourceBundle resources){

        try {
            recipeBeans1.addAll(getData());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionDbException e) {
            e.printStackTrace();
        }

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < recipeBeans1.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/guiclass/recipeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemControllerGUI itemControllerGUI = fxmlLoader.getController();
                itemControllerGUI.setData(recipeBeans1.get(i),myListener, recipeBeans1.get(i).getRecipeName(), recipeBeans1.get(i).getChefName());
                itemControllerGUI.setInterfaceName("myChef");

                if (column == 2) {
                    row++;
                    column = 0;
                }

                gridPane.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
