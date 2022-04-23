<%-- 
    Document   : login
    Created on : Apr 20, 2022, 11:27:54 PM
    Author     : ASUS
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center text-danger">Dang Nhap</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Da co loi xay ra
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Ban khong co quyen truy cap
    </div>
</c:if>

<c:url value="/login" var="action"/>

<form method="post" action="${action}">
    <div class="form-group">
        <lable for="username">Username</lable>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
     <div class="form-group">
        <lable for="password">Password</lable>
        <input type="password" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Dang Nhap" class="btn btn-danger"/>
    </div>
</form>