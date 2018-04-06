package com.example.user.lifeplant.Models;

/**
 * Created by user on 16-03-2018.
 */

public class CartModel {
    private String productname;

    public CartModel(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}
