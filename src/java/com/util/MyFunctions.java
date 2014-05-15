package com.util;


import com.beans.Catalog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.beans.Product;



public class MyFunctions {
    
    public static ArrayList<Product> getAllProducts(String filepath)
    {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try
        {
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String idAsString = t.nextToken();
                int id = Integer.parseInt(idAsString);
                String name = t.nextToken();                
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);                
                String desc = t.nextToken();
                String imgLocation = t.nextToken();
                
                Product p = new Product();
                p.setId(id);
                p.setName(name);
                p.setPrice(price);
                p.setDesc(desc);
                p.setImgLocation(imgLocation);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    } //end getAllProducts(.)
    
    public static Product getProduct(int productID, String filepath)
    {
        try
        {
            File file = new File(filepath);
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String idString = t.nextToken();
                int id = Integer.parseInt(idString);
                
                if (productID == id)
                {
                    String name = t.nextToken();                
                    String priceAsString = t.nextToken();
                    double price = Double.parseDouble(priceAsString);                
                    String desc = t.nextToken();
                    String imgLocation = t.nextToken();
                    
                    Product p = new Product();
                    p.setId(productID);
                    p.setName(name);
                    p.setPrice(price);
                    p.setDesc(desc);
                    p.setImgLocation(imgLocation);
                    
                    in.close();
                    return p;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
     public static ArrayList<Product> searchProducts(String search, String filepath)
    {
        try
        {
            ArrayList<Product> products = new ArrayList<Product>();
            File file = new File(filepath);
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String idString = t.nextToken();
                int id = Integer.parseInt(idString);
                String name = t.nextToken();
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);                
                String desc = t.nextToken();
                
                
                if ((name.toLowerCase().contains(search.trim().toLowerCase())) || (desc.toLowerCase().contains(search.trim().toLowerCase())))
                {
                                   
                    String imgLocation = t.nextToken();
                    
                    Product p = new Product();
                    p.setId(id);
                    p.setName(name);
                    p.setPrice(price);
                    p.setDesc(desc);
                    p.setImgLocation(imgLocation);
                    products.add(p);
                    
                    
                }
                
                line = in.readLine();
            }
            in.close();
            return products;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    public static void main(String[] args) {
//C:\Users\Andrew\Dropbox\School\Spring2014\JAVA3\ClassProjects\ShoppingCart\web\WEB-INF\products.txt
        
        String path = "C:\\Users\\Andrew\\Dropbox\\School\\Spring2014\\JAVA3\\ClassProjects\\ShoppingCart\\web\\WEB-INF\\products.txt";
        
         ArrayList<Product>  products = getAllProducts(path);
        
        
//        File file = new File("WEB-INF/products.txt");
//        System.out.println(file.getAbsolutePath());
        
       
       
        
        for (Product product : products) {
            System.out.println(product.toString());
            
        }
        
        Product product = getProduct(3, path);
        System.out.println("\n" + product);
        
        
        ArrayList<Product> prods = searchProducts("a", path);
        
        
        Catalog catalog = new Catalog();
        catalog.setProducts(prods);
        
        
        System.out.println(prods.toString());
        
        
        
    }
    
    
}
