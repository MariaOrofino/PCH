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
<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.jsp">PCH</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
                <li><a href="">Lost</a></li>
                <li><a href="">Found</a></li>
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
                    <img src="images/cat.jpg" alt="Pizza" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Missing Cat</h3>
                        <p>Named Vanna, beautiful and friendly!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="images/snake.jpg" alt="Garlic Bread" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Missing Snake</h3>
                        <p>From Slithering House.  Contact Harry Potter!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="images/horse.jpg" alt="Meal" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Found Horse</h3>
                        <p>Missing horse has been FOUND!!!</p>
                    </div>
                </div>

                <div class="item">
                    <img src="images/monkey.jpg" alt="Meal" width="360" height="245">
                    <div class="carousel-caption">
                        <h3>Missing Monkey</h3>
                        <p>Missing monkey in Dover area.</p>
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
            <h1>The World's Best Pet Locator Website</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Add Pet Information</a></li>
                </ul>    
            </div>
            <h2>This is where the search information will be added.  This will be open for all with no authentication.</h2>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>

