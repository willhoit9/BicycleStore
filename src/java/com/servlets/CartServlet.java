/*
 * Shopping Cart cartServlet
 * Andrew
 */

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.*;
import com.util.*;
import javax.servlet.ServletContext;

public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        HttpSession session = request.getSession();
        // get cart or create cart
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
        }
        
        // where was the request from
        String from = request.getParameter("from");
        String fromUrl = "";
        if (from.equalsIgnoreCase("catalog")) {
            fromUrl = "/index.jsp";
            System.out.println("INDEX");
        } 
        if (from.equalsIgnoreCase("cart")) {
            fromUrl = "/cart.jsp";
            System.out.println("CART");
        } 
        
        String removeString = request.getParameter("remove");
        boolean remove = false;
        if (removeString != null) {
            if (removeString.equalsIgnoreCase("true")) {
                remove = true;
            }           
        }
        
        String message = "";
        String url = "/cart.jsp";
        
        String qtyString = request.getParameter("qty");
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        
        int qty = 0;
        try {
            qty = Integer.parseInt(qtyString);
        } catch (NumberFormatException e) {           
            message = "Enter a number";
            request.setAttribute("id", id);         
            request.setAttribute("message", message);
            request.getRequestDispatcher(fromUrl).forward(request, response);
            return;
        }
        
        
        if ( qty < 1 && remove == false ) {
            message = "Amt cannot be less than 1";
            request.setAttribute("id", id);
            request.setAttribute("message", message);
            request.getRequestDispatcher(fromUrl).forward(request, response);
            return;
        } 
        
        
        
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("WEB-INF/products.txt");
        Product product = MyFunctions.getProduct(id, path);
        
        
        
        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        
        
//        if (from.equalsIgnoreCase("catalog")) {
//            lineItem.setQty(qty + 1);
//        }
        
        lineItem.setQty(qty);
        
        
        System.out.println(product);
        
        if (from.equalsIgnoreCase("catalog")) {
            cart.incrementLineItem(lineItem);
        } else if (from.equalsIgnoreCase("cart")) {
            if (remove == false) {
                cart.addLineItem(lineItem);
            } else if (remove == true) {
                cart.removeItem(lineItem);
            }  
        }
        
        
        cart.setShipping(5.0);
        cart.setTax(0.07);

        session.setAttribute("cart", cart);
        request.setAttribute("message", message);
        
        
        
        
        
        // TODO verify this is correct
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
