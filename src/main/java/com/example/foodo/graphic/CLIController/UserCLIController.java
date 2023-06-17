package com.example.foodo.graphic.CLIController;

import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.UserViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class UserCLIController implements GrapghiCLIController{
    private static final String PANTRY="1";
    private static final String PROFILE="2";
    private static final String KITCHEN="3";
    private static final String CHEF="4";
    UserViewCLI userViewCLI;

    @Override
    public void start() throws SQLException, ConnectionDbException, FileNotFoundException {
        this.userViewCLI= new UserViewCLI(this);
        this.userViewCLI.run();
    }

    public void executeCommand(String inputLine) throws CommandNotValidException, SQLException, ConnectionDbException, FileNotFoundException {
        switch(inputLine){
            case PANTRY -> {
                PantryCLIController pantryCLIController=new PantryCLIController();
                pantryCLIController.start();
            }case PROFILE -> {
                ProfileCLIController profileCLIController=new ProfileCLIController();
                profileCLIController.start();
                //this.start();
            }case KITCHEN -> {
                KitchenCLIController kitchenCLICOntroller= new KitchenCLIController();
                kitchenCLICOntroller.start();
                this.start();
            }case CHEF -> {
                MyChefCLIController myChefCLIController = new MyChefCLIController();
                myChefCLIController.start();
            }
            default -> throw new CommandNotValidException();
        }
    }
}
