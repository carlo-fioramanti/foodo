package com.example.foodo.graphic.viewcli;

import com.example.foodo.controllerappl.RecipeController;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.controllercli.AddRecipeCLIController;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AddRecipeViewCLI {

    List<IngredientBean> ingredients=new ArrayList<>();
    public final AddRecipeCLIController addRecipeCLIController;
    public AddRecipeViewCLI(AddRecipeCLIController addRecipeCLIController) {
        this.addRecipeCLIController = addRecipeCLIController;
    }


    public void run() throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException {
        Printer.printMessage("\n-------------------------------------------- ADD NEW RECIPE --------------------------------------------");
        Scanner scanner= new Scanner(System.in);
        ArrayList<String> product = new ArrayList<String>();
        ArrayList<String> quantity = new ArrayList<String>();
        String inputLine;
        Printer.printMessage("\n Insert name of recipe:");
        inputLine= scanner.nextLine();
        String nameR=inputLine;
        Printer.printMessage("\n Insert name of ingredients:");
        inputLine= scanner.nextLine();
        product.add(inputLine);
        Printer.printMessage("\n Insert quantity:");
        inputLine= scanner.nextLine();
        quantity.add(inputLine);
        Printer.printMessage("Want to add another ingredient? y/n");
        if(!Objects.equals(scanner.nextLine(), "n")){
            do{
                Printer.printMessage("\n Insert name of ingredients:");
                inputLine= scanner.nextLine();
                product.add(inputLine);
                Printer.printMessage("\n Insert quantity:");
                inputLine= scanner.nextLine();
                quantity.add(inputLine);
                Printer.printMessage("Want to add another ingredient? y/n");
            }while(!Objects.equals(scanner.nextLine(), "n"));
        }
        Printer.printMessage("Insert description:");
        inputLine= scanner.nextLine();
        String description=inputLine;
        Printer.printMessage("Insert image path:");
        String path=scanner.nextLine();
        RecipeBean recipeBean = new RecipeBean();
        recipeBean.setRecipeName(nameR);
        recipeBean.setDescription(description);
        recipeBean.setPath(path);
        ChefBean chefBean=new ChefBean();
        chefBean= Session.getCurrentSession().getChefBean();
        recipeBean.setChefName(chefBean.getUsername());
        RecipeController recipeController=new RecipeController();
        recipeController.saveRecipe(recipeBean);
        for(int i = 0; i< product.size(); i++){
            IngredientBean ingredientBean = new IngredientBean(product.get(i), quantity.get(i) );
            ingredients.add(ingredientBean);
        }
        recipeController.saveIngredients(ingredients);
        Printer.printMessage("\n 1) Confirm");
        scanner = new Scanner(System.in);
        inputLine = scanner.nextLine();
        try{
            this.addRecipeCLIController.executeCommand(inputLine);
        }catch (CommandNotValidException e){
            run();
        }

    }
}
