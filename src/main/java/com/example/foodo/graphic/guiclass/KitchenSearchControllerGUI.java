package com.example.foodo.graphic.guiclass;

import com.example.foodo.controllerappl.SearchRecipeController;
import com.example.foodo.engineering.exception.RecipeNotFoundException;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.SearchRecipeBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KitchenSearchControllerGUI {
    @FXML
    private Button searchButton;

    @FXML
    private GridPane grid1;
    private MyListener myListener;

    @FXML
    private TextField searchTextField;





    @FXML
    void showGenerateRecipe(ActionEvent event) throws IOException {
        Parent scene = FXMLLoader.load(getClass().getResource("/guiclass/myKitchen.fxml"));
        Scene sceneMainView = new Scene(scene);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    @FXML
    void backHome(ActionEvent event) throws IOException {
        Parent scene;
        if(Session.getCurrentSession().getChefBean() == null){
            scene = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        }else{
            scene = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        }
        Scene sceneMainView = new Scene(scene);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void searchRecipe() throws RecipeNotFoundException {
        SearchRecipeBean searchRecipeBean= new SearchRecipeBean();
        searchRecipeBean.setRecipeName(searchTextField.getText());
        List<RecipeBean> recipeBeans= new ArrayList<>();


        SearchRecipeController searchRecipeController= new SearchRecipeController();
        recipeBeans=searchRecipeController.searchRecipe(searchRecipeBean);

        int column = 0;
        int row = 1;
        try {
            for (RecipeBean recipeBean : recipeBeans) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/guiclass/recipeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemControllerGUI item = fxmlLoader.getController();
                item.setData(recipeBean, myListener, recipeBean.getRecipeName(), recipeBean.getChefName());
                item.setInterfaceName("kitchenSearch");

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid1.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid1.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
