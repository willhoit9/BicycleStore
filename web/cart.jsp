<!--
Document   : Shopping Cart cart.jsp
Created on : Mar 16, 2014, 10:09:05 AM
Author     : Andrew
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

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

            <h2>Shopping Cart</h2>

            <!--${cart}-->

        <div id="review">
            <div id="innerReview">
                
            
            
            
                
            <c:if test="${cart.size > 0}">
                <div id="top">    
                    <ul>
                        <li>Qty</li>
                        <li>Name</li>
                        <li>Price</li>

                        <li>LinePrice</li>
                        <li></li>
                    </ul>

                </div>    
            </c:if>
               
            <c:if test="${cart.size == 0}">
                <div class="emptyTop">
                 Your Cart is Empty.
                </div>
            </c:if>
            
            

            <div id ="items">
                
                <c:forEach var="lineItems" items="${cart.lineItems}">
                    
                    <span class="errorCart">
                        <p><c:if test="${id == lineItems.product.id}">
                                ${message} 
                            </c:if></p>
                    </span>
                    <ul>

                        <li>
                            <form class="updateQty" method="POST" action="<c:url value='/CartServlet'  />">
                                <input type="hidden" name="id" value="${lineItems.product.id}">
                                <input type=text class="qty" name="qty" value="${lineItems.qty}">
                                <input type="hidden" name="from" value="cart">
                                <input type="submit" value="Update">
                                <!--${lineItems.qty}-->
                            </form>
                        </li>

                        <li> ${lineItems.product.name} </li>       
                        <li>${lineItems.product.priceCurrency}</li>

                        <li>${lineItems.totalCurrency}</li>
                        <li>
                            <form class="updateQty" method="POST" action="<c:url value='/CartServlet' />">
                                <input type="hidden" name="id" value="${lineItems.product.id}">
                                <input type="hidden" name="remove" value="true">
                                <input type="hidden" name="qty" value="0">
                                <input type="hidden" name="from" value="cart">
                                <input type="submit" value="Remove">
                            </form>
                        </li>

                    </ul>

                </c:forEach>

                

                
            </div> <!-- end div items-->

            <div id="total">
                <c:if test="${cart.size > 0}">
                    <ul id="space"><li></li><li></li>
                        <li>
                            &nbsp;
                        </li>
                        <li> 
                           
                        </li>

                    </ul> 
                    <ul><li></li><li></li>
                        <li>
                            Subtotal:
                        </li>
                        <li>
                            ${cart.subTotalCurrency}
                        </li>
                    </ul>
                    <ul><li></li><li></li>
                        <li>
                            Shipping: 
                        </li>
                        <li> 
                            ${cart.shippingCurrency}
                        </li>

                    </ul>
                    <ul><li></li><li></li>
                        <li>
                           Tax: 
                        </li>
                        <li> 
                           ${cart.salesTaxCurrency}
                        </li>

                    </ul>   
                    <ul><li></li><li></li>
                        <li>
                           Total:
                        </li>
                        <li> 
                           ${cart.grandTotalCurrency}
                        </li>

                    </ul>     
                    <ul><li></li><li></li>
                        <li>
                           
                        </li>
                        <li> 
                           
                        </li>

                    </ul> 


                    <br>
                </c:if>
            </div><!-- end div total-->


            <br><br><br><br>



            <form class="inline" action="<c:url value='/index.jsp' />" method="post">
                <input type="submit" value="Continue Shopping">
            </form>

            <form class="inline" action="<c:url value='/checkout.jsp' />" method="post">
                <input type="submit" value="Checkout">
            </form>
                
                <br><br>
        </div> <!-- end div innerReview -->
        <br><br><br><br>
        </div><!-- end div review-->

    </body>
</html>
