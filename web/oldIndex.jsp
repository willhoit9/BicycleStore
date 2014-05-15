<!--
THIS IS OLD INDEX. RIP. - 3/19/14


Document   : Shopping Cart index.jsp
Created on : Mar 16, 2014, 10:07:05 AM
Author     : Andrew
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%@taglib uri="/WEB-INF/tlds/mylib" prefix="my" %>

<%--<jsp:useBean scope="page" id="product" class="com.beans.Product" />
<jsp:useBean scope="page" id="products" class="com.beans.ShoppingCart" />--%>

<%--<jsp:setProperty name="products" value="expression" property="lineItems" />--%>

<%--<jsp:setProperty name="products" property="lineItems">
  <jsp:attribute name="value"> ${my:getAllProducts("C:\\Users\\Andrew\\Dropbox\\School\\Spring2014\\JAVA3\\ClassProjects\\ShoppingCart\\web\\WEB-INF\\products.txt")} </jsp:attribute>
</jsp:setProperty>--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="shoppingCart.css">
        <title>Bicycles</title>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import var="products" url="WEB-INF/products.txt"></c:import>
        
        
        
        <nav>
            <ul>
                <li><a href="#frame">Frames</a></li>
                <li><a href="#wheel">Wheels</a></li>
                <li><a href="#saddle">Saddles</a></li>
                <li><a href="#brake">Brakes</a></li>
                <li><a href="#shift">Derailleurs</a></li>
            </ul>
        </nav>
        
        <div id="search">
            <input type="text" name="search">
            <input type="submit" value="Search" /> 
        </div>
        
        <br class="clear" />

        
        <div id="catalog">
            
            
           
            <div id="frame">
                
                <img src="images/frame.jpg">
                The Rivendell Atlantis Frame and Fork
                &nbsp;
                2300.95
                &nbsp;
                <span class="error">
                    <p><c:if test="${id == 1}">
                       ${message} 
                    </c:if></p>
                </span>
                <form action="<c:url value='/CartServlet'  />" method="POST">
                    Amt: <input type="text" name="qty" class="qty" value="1" /> 
                    <input type="hidden" name="id" value="1">
                    <input type="hidden" name="from" value="catalog">
                    <input type="submit" value="Add To Cart"  />
                </form>
            </div>
          

            
            <div id="wheel">
                
                <img src="images/wheel.jpg">
                700c R36 Rims 3x laced onto Phil Wood Touring Hubs
                &nbsp;
                389.95
                &nbsp;
                <span class="error">
                    <p><c:if test="${id == 2}">
                       ${message} 
                    </c:if></p>
                </span>
                <form action="<c:url value='/CartServlet'  />" method="POST">
                    Amt: <input type="text" name="qty" class="qty" value="1" />
                    <input type="hidden" name="id" value="2">
                    <input type="hidden" name="from" value="catalog">
                    <input type="submit" value="Add To Cart"  />
                </form>
            </div>
                
            <div id="saddle">
                
                <img src="images/saddle.jpg">
                Brooks B17 Select Saddle
                &nbsp;
                44.95
                &nbsp;
                <span class="error">
                    <p><c:if test="${id == 3}">
                       ${message} 
                    </c:if></p>
                </span>
                <form action="<c:url value='/CartServlet'  />" method="POST">
                    Amt: <input type="text" name="qty" class="qty" value="1" />    
                    <input type="hidden" name="id" value="3">
                    <input type="hidden" name="from" value="catalog">
                    <input type="submit" value="Add To Cart"  />
                </form>                
            </div>
            <div id="brake">
                
                <img src="images/brake.jpg">
                 Tektro R539 Brakes
                 &nbsp;
                54.95
                &nbsp;
                <span class="error">
                    <p><c:if test="${id == 4}">
                       ${message} 
                    </c:if></p>
                </span>
                <form action="<c:url value='/CartServlet'  />" method="POST">
                    Amt: <input type="text" name="qty" class="qty" value="1" />
                    <input type="hidden" name="id" value="4">
                    <input type="hidden" name="from" value="catalog">
                    <input type="submit" value="Add To Cart"  />
                </form> 
            </div>
                
            <div id="shift">
                
                <img src="images/shift.jpg">
                
                MicroShift Standard Rear Derailer
                &nbsp;
                67.95
                &nbsp;
                <span class="error">
                    <p><c:if test="${id == 5}">
                       ${message} 
                    </c:if></p>
                </span>
                <form action="<c:url value='/CartServlet'  />" method="POST">
                    Amt: <input type="text" name="qty" class="qty" value="1" /> 
                    <input type="hidden" name="id" value="5">
                    <input type="hidden" name="from" value="catalog">
                    <input type="submit" value="Add To Cart"  />
                </form>
            </div>    

            
        </div> <!-- end catalog-->
        
        
        
        
        
        
        
        
    </body>
</html>
