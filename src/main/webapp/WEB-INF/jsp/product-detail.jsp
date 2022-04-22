<%-- 
    Document   : product-detail
    Created on : Apr 22, 2022, 9:50:13 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-danger">Chi tiet san pham</h1>
<div class="row">
    <div class="col-md-6">
        <c:choose>
            <c:when test="${product.image != null && product.image.startsWith('https') == true}">
                <img class="card-img-top img-fluid" src="${product.image}" alt="${product.name}">
            </c:when>
            <c:when test="${p.image == null || p.image.startsWith('https') == false}">
                <img class="card-img-top" src="<c:url value="/images/anh1.jpg"/>" alt="${product.name}">
            </c:when>
        </c:choose>
    </div>
    <div class="col-md-6">
        <h1>${product.name}</h1>
        <h3 class="text-danger">${product.price} VND</h3>
        <p>${product.description}</p>
        <div>
            <input type="button" value="Dat hang" class="btn btn-danger"/>
        </div>
    </div>
</div>
<br><br>
<form>
    <div class="form-group">
        <textarea class="form-control" placeholder="Nhap danh gia..."></textarea>
        <br>
        <input type="submit" value="Gui binh luan" class="btn btn-danger"/>
    </div>
</form>

<c:forEach var="comment" items="${product.commentCollection}">
<div class="row">
    <div class="col-md-2" style="padding: 10px">
        <img class="rounded-circle img-fluid" src="<c:url value="/images/anh1.jpg"/>"/>
    </div>
    <div class="col-md-10">
        <p>${comment.content}</p>
        <i>22/04/2022 22:22</i>
    </div>
</div>
        
</c:forEach>

