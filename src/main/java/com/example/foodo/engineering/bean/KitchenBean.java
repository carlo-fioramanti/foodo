package com.example.foodo.engineering.bean;


public class KitchenBean {

    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    private String ingredient5;

    public KitchenBean(String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5) {
        this.setIngredient1(ingredient1);
        this.setIngredient2(ingredient2);
        this.setIngredient3(ingredient3);
        this.setIngredient4(ingredient4);
        this.setIngredient5(ingredient5);
    }

    public KitchenBean() {

    }




    public String getIngredient2() {
        return ingredient2;
    }
    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }
    public String getIngredient1(){return ingredient1;}
    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }



    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }
    public String getIngredient3() {
        return ingredient3;
    }


    public void setIngredient4(String ingredient4) {
        this.ingredient4 = ingredient4;
    }
    public String getIngredient4() {
        return ingredient4;
    }


    public void setIngredient5(String ingredient5) {
        this.ingredient5 = ingredient5;
    }
    public String getIngredient5() {
        return ingredient5;
    }
}
