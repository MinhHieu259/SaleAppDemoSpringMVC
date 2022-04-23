<%-- 
    Document   : register
    Created on : Apr 21, 2022, 10:42:56 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/register" var="action"/>
<h1 class="text-center text-danger">Dang Ky</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user">
    <div class="form-group">
        <lable for="firstname">FirstName</lable>
        <form:input type="text" id="firstname" path="firstName" class="form-control"/>
    </div>
     <div class="form-group">
        <lable for="lastname">LastName</lable>
        <form:input type="text" id="lastname" path="lastName" class="form-control"/>
    </div>
     <div class="form-group">
        <lable for="lastname">Email</lable>
        <form:input type="email" id="email" path="email" class="form-control"/>
    </div>
    <div class="form-group">
        <lable for="username">Username</lable>
        <form:input type="text" id="username" path="username" class="form-control"/>
    </div>
     <div class="form-group">
        <lable for="password">Password</lable>
          <form:input type="password" id="password" path="password" class="form-control"/>
    </div>
     <div class="form-group">
        <lable for="confirm-password">Confirm Password</lable>
          <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
    </div>
    <div class="form-group">
        <lable for="avatar">Avatar</lable>
          <form:input type="file" id="avatar" path="file" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Dang Ky" class="btn btn-danger"/>
    </div>
</form:form>
