package com.example.foodo.model;

public class ChefModel extends GenericUserModel{
    private String typeOfCuisine;
    private String workplace;
    private String email;
    private String number;
    private String location;
    private String path;

    public String getPath() {
        return path;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ChefModel(String username, int profileType){
        super(username, profileType);

    }
    public ChefModel(String username, String typeOfCuisine, String workplace, String email, String number, String location, String path){
        super(username);
        this.typeOfCuisine=typeOfCuisine;
        this.workplace=workplace;
        this.email = email;
        this.number = number;
        this.location = location;
        this.path=path;
    }

    public String getTypeOfCuisine() {
        return typeOfCuisine;
    }

    public void setTypeOfCuisine(String typeOfCuisine) {
        this.typeOfCuisine = typeOfCuisine;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    public void setPath(String path) {
        this.path = path;
    }

}
