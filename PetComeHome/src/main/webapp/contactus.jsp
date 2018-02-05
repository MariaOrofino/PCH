<%-- 
    Document   : contactus
    Created on : Feb 1, 2018, 3:19:51 PM
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
<center>

    <h2>Contact Us</h2>
    <form action="a" method="post">
        <div class="warning" style="color:red;font-weight:bold;">
            The following fields are required:
        </div>
        <div>
            <p class="warning" style="color:red;font-weight:bold;">Full Name is required.</p>
            <label id="fullanmelabel" for ="Full Name">Name:</label>
            <input id="fullname" name="FullName" type="text" />
        </div></br>
        <div>
            <label id="Email" for ="Email">Email:</label>
            <input id="Email" name="Email" type="text" />
        </div></br>
        <div>
            <label id="PhoneLabel" for ="Phone">Phone:</label>
            <input id="PhoneLabel" name="Email" type="text" />
        </div></br>
        Reason for Inquiry:
        <select name="Reason">
            <option value="Value1">Select a Reason</option>
            <option value="Value2">Lost Pet</option>
            <option value="Value3">Found Pet</option>
            <option value="Value4">Pet Sighting</option>
            <option value="Value5">Other</option>
        </select></br><p></p>
        Additional Information:
        <textarea name="additionalinfo"></textarea></br>
        <p></p>
        Have you used our services in the past?
        <input type="checkbox" name="myChoices" value="Yes"/>Yes
        <input type="checkbox" name="myChoices" value="No"/>No</br>
        <p></p>
        Best days to contact you:
        <input type="checkbox" name="myChoices" value="Monday"/>M
        <input type="checkbox" name="myChoices" value="Tuesday"/>Tu
        <input type="checkbox" name="myChoices" value="Wednesday"/>W
        <input type="checkbox" name="myChoices" value="Thursday"/>Th
        <input type="checkbox" name="myChoices" value="Friday"/>F
        <p></p>
        <div>
            <input type="submit" id="SubmitButton" value="Send Request" />
        </div>
    </form>
</center>
</body>
<footer style="color:blue;margin-left:30px;">
    <hr>
     <center>Jan Gentille - Director of Pet Services</center>
    <center>123 North Main Street, Anywhere, USA</center>
    <center>800-873-5463</center>
    <hr>
</footer>
</html>
