<%-- 
    Document   : index
    Created on : Apr 22, 2022, 9:19:39 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">MINH HIEU WEB</h1>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(productCounter/9)}" var="page">
        <li class="page-item"><a class="page-link" href="<c:url value="/"/>?page=${page}">${page}</a></li>
        </c:forEach>
</ul>
<div class="row"> 
    <c:forEach var="p" items="${products}">
        <div class="col-md-4 col-xs-12" style="padding: 10px">
            <div class="card">
                <a href="<c:url value="/product/${p.id}"/>">
                    <c:choose>
                        <c:when test="${p.image != null && p.image.startsWith('https') == true}">
                            <img class="card-img-top img-fluid" src="${p.image}" alt="Card image">
                        </c:when>
                        <c:when test="${p.image == null || p.image.startsWith('https') == false}">
                            <img class="card-img-top" src="<c:url value="/images/anh1.jpg"/>" alt="Card image">
                        </c:when>
                    </c:choose>
                </a>
                <div class="card-body">
                    <h4 class="card-title">${p.name}</h4>
                    <p class="card-text">${p.price} VND</p>
                    <a href="#" class="btn btn-primary">Dat hang</a>
                </div>
            </div>

        </div>
    </c:forEach>
</div>