package com.example.foodo.engineering.dao;


import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.RecipeModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RecipeDAO {
    public static void AddRecipe(RecipeModel recipe) throws SQLException {
        Statement stmt;
        PreparedStatement preparedStatement;
        try{
            stmt = ConnectionDB.getConnection();
            preparedStatement= ConnectionDB.addRecipe();
            preparedStatement.setString(1, recipe.getRecipeName());
            preparedStatement.setString(2, recipe.getDescription());
            preparedStatement.setString(3, recipe.getChefName());

            preparedStatement.executeUpdate();
        }catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }

    }
}
