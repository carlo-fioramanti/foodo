package com.example.foodo_fx.engineering.dao;

import com.example.foodo_fx.engineering.dao.queries.basicQueries;
import com.example.foodo_fx.engineering.exception.ConnectionDbException;
import com.example.foodo_fx.engineering.exception.NotFoundException;
import com.example.foodo_fx.model.ChefModel;
import com.example.foodo_fx.engineering.connection.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class chefDAO {

    private static final String CUISINE="typeOfCuisine";
    private static final String WORKPLACE="workplace";
    //private static final Integer CHEFTYPE="";



    private chefDAO(){}

    public static ChefModel retrieveChefByUsername(String username) throws NotFoundException {
        Statement stmt;
        ChefModel chefModel=null;
        try{
            stmt=ConnectionDB.getConnection();

            ResultSet resultSet= basicQueries.selectChefByUsername(stmt, username);

            if(!resultSet.first()){
                throw new NotFoundException("No chef find with the username: " + username);
            }

            resultSet.first();
            do {

                chefModel = setChefInfo(username, resultSet);
            }while(resultSet.next());
            resultSet.close();

        }
        catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return chefModel;
    }

    private static ChefModel setChefInfo(String username, ResultSet resultSet){
        ChefModel chefModel=null;
        try{
            //int chefTypeOfUser=resultSet.getInt(CHEFTYPE);
            String typeOfCuisine=resultSet.getString(CUISINE);
            String workplace=resultSet.getString(WORKPLACE);
            chefModel=new ChefModel(username, typeOfCuisine, workplace, 1);

        }
        catch(Exception e){
            e.printStackTrace();
        }        return chefModel;
    }

}
