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
        <link href="${pageContext.request.contextPath}/css/petComeHome.css" rel="stylesheet">
<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css">-->   

        <!-- Call Bootstrap CSS styles -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap-3.3.5/bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link href="${pageContext.request.contextPath}/css/petComeHome.css" rel="stylesheet">
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
                <li><a href="${pageContext.request.contextPath}/jsp/submitForm.jsp">Report Lost Pet</a></li>
                <li><a href="${pageContext.request.contextPath}/found.jsp">Report Found pet</a></li>
                <li><a href="${pageContext.request.contextPath}/lost.jsp">Report a Sighting</a></li>
                <li><a href="${pageContext.request.contextPath}/search.jsp">Search</a></li>
                <li><a href="${pageContext.request.contextPath}/contactus.jsp">Contact Us</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <br>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <!--// Create a carousel of images to scroll automatically on  your web page. -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
                <li data-target="#myCarousel" data-slide-to="4"></li>
                <li data-target="#myCarousel" data-slide-to="5"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/images/dog.jpg" alt="Dog" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Dog</h3>
                        <p>Beautiful lost dog.  Please help us find this dog!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="${pageContext.request.contextPath}/images/cat.jpg" alt="Cat" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Missing Cat</h3>
                        <p>Named Vanna, beautiful and friendly!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="${pageContext.request.contextPath}/images/snake.jpg" alt="Snake" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Missing Snake</h3>
                        <p>From Slithering House.  Contact Harry Potter!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="${pageContext.request.contextPath}/images/horse.jpg" alt="Horse" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Found Horse</h3>
                        <p>Missing horse has been FOUND!!!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="${pageContext.request.contextPath}/images/monkey.jpg" alt="Monkey" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Found Monkey</h3>
                        <p>Monkey found in the woods in Danville, NH has been returned to it's owner!!!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="${pageContext.request.contextPath}/images/cockatoo.jpg" alt="Cockatoo" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Cockatoo Missing</h3>
                        <p>Missing cockatoo missing.  Last seen in Somersworth, NH.  Please help find my bird!!!</p>
                    </div>
                </div>

            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div class="container">
            <!-- container for admin function -->
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
<footer style="color:blue;margin-left:30px;">
    <hr>
    <center>Jan Gentille - Director of Pet Services</center>
    <center>123 North Main Street, Anywhere, USA</center>
    <center>800-873-5463</center>
    <hr>
</footer>
</html>