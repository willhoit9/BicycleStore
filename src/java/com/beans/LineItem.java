/* 
 * Shopping Cart Product
 * Andrew
 */

package com.beans;

import java.io.Serializable;
import java.text.NumberFormat;

public class LineItem implements Serializable{
    
    private Product product;
    private int qty;

    public LineItem() {
        qty = 0;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public double getTotal() {
        double t = product.getPrice() * qty;
        return t;
    }
    
    public String getTotalCurrency() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
    
}
