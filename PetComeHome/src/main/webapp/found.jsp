<%-- 
    Document   : found
    Created on : Feb 1, 2018, 3:15:27 PM
    Author     : n0147313
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Pet Come Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
          <link href="${pageContext.request.contextPath}/css/petComeHome.css" rel="stylesheet">
        <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css">-->   

        <!-- Call Bootstrap CSS styles -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<link rel="stylesheet" href="bootstrap-3.3.5/bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">-->
        <!--       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Pet Come Home</title>
    <div class="jumbotron text-center">
        <h1>Pet Come Home</h1>
    </div>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/jsp/home.jsp">PCH</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/jsp/home.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/submitForm.jsp">Report Lost Pet</a></li>
                <li><a href="${pageContext.request.contextPath}/found.jsp">Report Found pet</a></li>
                <li><a href="${pageContext.request.contextPath}/lost.jsp">Report a Sighting</a></li>
                <li><a href="${pageContext.request.contextPath}/search.jsp">Search</a></li>
                <li><a href="${pageContext.request.contextPath}/contactus.jsp">Contact Us</a></li>
            </ul>
        </div>
    </nav>
    <h1>This is the page for found pets.</h1>
</body>
<footer style="color:blue;margin-left:30px;">
    <hr>
     <center>Jan Gentille - Director of Pet Services</center>
    <center>123 North Main Street, Anywhere, USA</center>
    <center>800-873-5463</center>
    <hr>
</footer>
</html>
