<%-- 
    Document   : cart
    Created on : Apr 23, 2022, 5:28:15 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-danger">GIO HANG</h1>

<c:if test="${carts == null}">
    <h4 class="text-danger text-center">Khong co san pham nao trong gio</h4>
</c:if>

<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Ma san pham</th>
            <th>Ten san pham</th>
            <th>Don gia</th>
            <th>So luong</th>
            <th></th>
        </tr>
        <c:forEach var="c" items="${carts}">
            <tr id="product${c.productId}">
            <td>${c.productId}</td>
            <td>${c.productName}</td>
            <td>${c.price} VND</td>
            <td>
                <div class="form-group">
                     <input type="number" 
                            onblur="updateCart(this, ${c.productId})"
                            value="${c.quantity}" 
                            class="form-control"/>
                </div>
            </td>
            <td>
                <input onclick="deleteCartItem(${c.productId})" type="button" value="Xoa" class="btn btn-danger"/>
            </td>
        </tr>
        </c:forEach>
    </table>
    
    <div>
        <h4 class="text-info">Tong tien hoa don: <span id="amountCart">${cartStats.amount}</span> VND</h4>
    </div>
    <input onclick="pay()" type="button" value="Thanh toan" class="btn btn-danger"/>
    <br><br>
</c:if>