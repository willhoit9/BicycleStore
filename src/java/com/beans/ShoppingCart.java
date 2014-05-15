/* 
 * Shopping Cart Shopping Cart clas
 * Andrew
 */

package com.beans;

import java.text.NumberFormat;
import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<LineItem> lineItems;
    private double tax;
    private double shipping;
    
    public ShoppingCart() {
        lineItems = new ArrayList<LineItem>();
        tax = 0;
        shipping = 0;
    }
    
    public ArrayList<LineItem> getLineItems() { 
        return lineItems;
    }

    public double getTax() {
        return tax;
    }
    

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getShipping() {
        return shipping;
    }

    public String getShippingCurrency() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getShipping());        
    }
    
    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
        
    
    
    public void addLineItem(LineItem lineItem) {
        int id = lineItem.getProduct().getId();
        int qty = lineItem.getQty();
        for (int i = 0; i < lineItems.size(); i++)
        {
            LineItem li = lineItems.get(i);
            if (li.getProduct().getId() == id)
            {
                li.setQty(qty);
                return;
            }
        }
        lineItems.add(lineItem);
    }   
    
    public void incrementLineItem(LineItem lineItem) {
        int id = lineItem.getProduct().getId();
        int qty = lineItem.getQty();
        for (int i = 0; i < lineItems.size(); i++)
        {
            LineItem li = lineItems.get(i);
            if (li.getProduct().getId() == id)
            {
                li.setQty(qty + li.getQty());
                return;
            }
        }
        lineItems.add(lineItem);
    }   
    
    public void removeItem(LineItem lineItem) {
        int id = lineItem.getProduct().getId();
        for (int i = 0; i < lineItems.size(); i++)
        {
            LineItem li = lineItems.get(i);
            if (li.getProduct().getId() == id)
            {
                lineItems.remove(i);
                return;
            }
        }
    }

    public void setLineItems(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
    
    
       
    public int getSize() {
        int size = lineItems.size();
        return size;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "lineItems=" + lineItems + '}';
    }

    public double getSubTotal() {
        double t = 0;
        for (int i= 0; i < lineItems.size(); i++){
            t = t + lineItems.get(i).getTotal();
        }
        return t;
    }
    
    public String getSubTotalCurrency() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getSubTotal());
    }
    
    public double getSalesTax() {
        return ((this.getSubTotal() + this.getShipping()) * getTax());
    }
    
    public String getSalesTaxCurrency() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getSalesTax());
    }
    
    public double getGrandTotal() {
        double t =0;
        t = (getSubTotal() + this.getShipping()) * this.getTax() ;
        t = t + (getSubTotal() + this.getShipping());        
        return t;
    }
    
    public String getGrandTotalCurrency() {     
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getGrandTotal());
    }
    
    
    
}
