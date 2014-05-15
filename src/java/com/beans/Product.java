/*
 * Shopping Cart Product
 * Andrew
 */
package com.beans;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {

    private int id;
    private String name;
    private double price;
    private String desc;
    private String imgLocation;

    public Product(int id, String name, double price, String desc, String imgLocation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imgLocation = imgLocation;
    }

    public Product() {
        id = 0;
        name = "";
        price = 0;
        desc = "";
        imgLocation = "";
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }
    
    public String getPriceCurrency() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    } 

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + ", imgLocation=" + imgLocation + '}';
    }
    
    

}
