<%-- 
    Document   : base
    Created on : Apr 17, 2022, 4:55:49 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><tiles:insertAttribute name="title"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <tiles:insertAttribute name="header"/>

            <tiles:insertAttribute name="content"/>

            <tiles:insertAttribute name="footer"/>
        </div>
            <script src="<c:url value="js/main.js"/>"></script>
    </body>
</html>
