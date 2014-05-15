

package com.beans;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class Catalog {
    private ArrayList<Product> products;
    
    public Catalog() {
        products = new ArrayList<Product>();

    }
    
    public ArrayList<Product> getProducts() { 
        return products;
    }
     
    
    
    public void addProduct(Product product) {
        
        
        products.add(product);
        
        

    }   
    
    
    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    
       
    public int getSize() {
        int size = products.size();
        return size;
    }

    @Override
    public String toString() {
        return "Catalog{" + "products=" + products + '}';
    }


   
}
