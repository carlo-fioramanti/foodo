package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.model.ProductModel;

import java.sql.SQLException;

public class PantryController {

//    private final ProductBean productBean;

//    public PantryController(ProductBean productBean){
//        this.productBean=productBean;
//    }

    public void addNewProduct (ProductBean productBean) throws SQLException {
        ProductModel productModel= new ProductModel(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getDay(), productBean.getMonth(), productBean.getYear());
//        Session.setSessionInstance(productBean);
        ProductDAO productDAO=new ProductDAO();
        productDAO.InsProduct(productModel);

    }
}