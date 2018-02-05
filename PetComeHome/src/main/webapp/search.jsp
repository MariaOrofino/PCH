<%-- 
    Document   : search
    Created on : Feb 5, 2018, 10:15:21 AM
    Author     : n0147313
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Pet Come Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css">-->   

        <!-- Call Bootstrap CSS styles -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap-3.3.5/bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <!--       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Pet Come Home</title>
    <div class="jumbotron text-center">
        <h1>Pet Come Home</h1>
    </div>
</head>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/jsp/index.jsp">PCH</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/jsp/index.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
            <li><a href="${pageContext.request.contextPath}/submitForm">Report Lost Pet</a></li>
            <li><a href="${pageContext.request.contextPath}/found.jsp">Report Found pet</a></li>
            <li><a href="${pageContext.request.contextPath}/lost.jsp">Report a Sighting</a></li>
            <li><a href="${pageContext.request.contextPath}/search.jsp">Search</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
