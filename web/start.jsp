<!--
THIS FILE IS NOT USED. RIP START.JSP INDEX.JSP IS NOW USED.

Document   : Shopping Cart start.jsp
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

            start.jsp


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
                <form action="<c:url value='/LoadServlet'  />" method="POST">
                    <input type="text" name="search">
                    <input type="submit" value="Search" /> 
                </form>

            </div>

            <br class="clear" />


            <div id="catalog">

                <div id ="catItems">

                <c:forEach var="product" items="${catalog.products}">
                    <div class="prod">
                        <span class="error">
                            <p><c:if test="${id == product.id}">
                                    ${message} 
                                </c:if></p>
                        </span>
                        <div class="prodName">
                            ${product.name}
                        </div>
                        <div class="prodMain">
                            <div class="prodImg">
                                 <img src="${product.imgLocation}"> 
                            </div>
                            <div class="prodDesc">
                                <p>
                                    ${product.desc}
                                </p>
                            </div>
                            <div class="prodPrice">
                                ${product.priceCurrency}
                                <form action="<c:url value='/CartServlet'  />" method="POST">
                                    Amt: <input type="text" name="qty" class="qty" value="1" /> 
                                    <input type="hidden" name="id" value="${product.id}">
                                    <input type="hidden" name="from" value="catalog">
                                    <input type="submit" value="Add To Cart"  />
                                </form>
                            </div>
                            
                        </div>
                        <div class="prodFooter">
                             
                        </div>

                    </div> <!-- end div prod-->
                </c:forEach>




            </div> <!-- end div catItems-->
            
            <div id="showAll">                
                 <form action="<c:url value='/LoadServlet'  />" method="POST">
                    <input type="hidden" name="search" />
                    <input type="submit" value="Show All" /> 
                </form>
                    
            </div>
                    <br class="clear" />
        </div> <!-- end catalog-->
        <br> 
    </body>
</html>
