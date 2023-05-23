package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.dao.IngredientDAO;
import com.example.foodo.engineering.dao.RecipeDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.IngredientModel;
import com.example.foodo.model.ProductModel;
import com.example.foodo.model.RecipeModel;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class RecipeController {

    private int recipeId;

    public void saveRecipe(RecipeBean recipeBean) throws SQLException, FileNotFoundException, ConnectionDbException {
        RecipeDAO recipeDAO=new RecipeDAO();
        RecipeModel recipeModel= new RecipeModel(recipeBean.getRecipeName(), recipeBean.getDescription(), recipeBean.getChefName(), recipeBean.getPath());
        recipeDAO.AddRecipe(recipeModel);
        recipeId=recipeDAO.TakeRecipeId(recipeModel);

    }

    public void saveIngredients(List<IngredientBean> ingredientBeans) {
        IngredientDAO ingredientDAO=new IngredientDAO();
        List<IngredientModel> ingredients= new ArrayList<>();
        int i = 0;
        int lenght = ingredientBeans.size();
        do{
            IngredientBean ingredientBean=ingredientBeans.get(i);
            i++;
            IngredientModel ingredientModel = new IngredientModel(ingredientBean.getName(), ingredientBean.getQuantity());
            ingredients.add(ingredientModel);
        }while(i != lenght);
        ingredientDAO.addIngredient(ingredients, recipeId);
    }
}