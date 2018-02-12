<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Pet Come Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script>
            tinymce.init({
                selector: '#mytextarea',
                toolbar: 'undo redo | styleselect | bold italic underline blockquote | alignleft aligncenter alignright alignjustify alignnone | image',
                plugins: ['advlist autolink link image lists charmap print preview',
                    'searchreplace visualblocks code fullscreen',
                    'insertdatetime media table contextmenu paste code help',
                    'image code'],
                images_upload_url: '',
                branding: false
            });

        </script>


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
</head>
<body>
    <div class="container">
        <!--Change this to dynamically change Lost to whatever link the user selects-->
        <h1>Report a Lost pet</h1>
        <hr/>
        
        <div id="errorMessage" class="alert alert-danger fade in col-md-offset-2 col-md-8" hidden="false">
            <c:out value="${errorMessage}"/>
        </div>
        <div class="container row-md-12">
            <div  id="lostPetFormFields" class="col-md-6" align="left">
                <sf:form class="form-horizontal" role="form" modelAttribute="posting" action="createlostPetPost" method="POST">
                    <div class="form-group">
                        <!-- 
All form fields other than text area go here 
                        -->
                        <label for="user" class="col-md-4 control-label">User:</label>
                        <div class="col-md-8">
                            <input type="text" value="${pageContext.request.userPrincipal.name}" class="form-control" name="user" path="user" readonly="true"/>
                        </div>
                    </div>
                 
                    <div class="form-group" name="petDescriptors">
                        <!-- Type -->

                        <label for="name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="name" path="name" placeholder="Name"/>
                        </div>

                        <label for="chiptag" class="col-md-4 control-label">Chip Tag:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="chiptag" path="chiptag" placeholder="Chip Tag"/>
                        </div>

                        <!-- rabiestag -->
                        <label for="rabiestag" class="col-md-4 control-label">Rabies Tag:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="rabiestag" path="rabiestag" placeholder="Rabies Tag:"/>
                        </div>

                        <label for="breed" class="col-md-4 control-label">Choose Pet Breed</label>
                        <div class="col-md-8">
                            <select id="search-breed" name="breed" class="form-control" path="breed">
                                <option text="Choose the pet breed" value="">Choose Breed</option>
                                <c:forEach items="${breedList}" var="breedList">
                                    <option value="${breedList.breedId}">${breedList.breedName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <label for="size" class="col-md-4 control-label">Size:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="size" path="size" placeholder="Size"/>
                        </div>
                        <!-- color -->
                        <label for="color" class="col-md-4 control-label">Color:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="color" path="color" placeholder="Color"/>
                        </div>

                        <label for="color" class="col-md-4 control-label">Pet Image:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="imageurl" path="imageurl" placeholder="ImageURL"/>
                        </div>
                        <label for="type" class="col-md-4 control-label">Type:</label>      
                        <div class="col-md-8">
                            <!-- check against Pet tables -->
                            <select name="type" class="form-control" path="type"/>
                            <option text="Choose the pet type" value="ChoosePetType">Choose Pet Type</option>
                            <c:forEach items="${petTypeList}" var="petTypeList">
                                <option value="${petTypeList.typeId}">${petTypeList.species}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <label for="color" class="col-md-4 control-label">Lost Date:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="lostdate" path="lostdate" placeholder="LostDate"/>
                        </div>

                        <label for="status" class="col-md-4 control-label">Status:</label>      
                        <div class="col-md-8">
                            <!-- check against Pet tables -->
                            <select name="status" class="form-control" path="status"/>
                            <option text="Choose Pet Status" value="ChoosePetStatus">Choose Pet Status</option>
                            <c:forEach items="${petStatusList}" var="petStatusList">
                                <option value="${petStatusList.statusId}">${petStatusList.status}</option>
                            </c:forEach>
                            </select>
                        </div>

                    </div>
                    <!-- name -->
                    <!-- phone number -->
                    <!-- email -->
                    <!-- alternate phone number -->
                    <!-- alternate email -->
                </div>
            </div>
            <div id="lostPetDescAndButtons" class="col-md-6 row-md-8" align="right">
                <!-- 
                Textarea goes here 
                -->

                <div class="form-group" name="descriptionTextArea">
                    <label for="description" class="col-md-4 control-label">Description:</label><br>
                    <div class="col-md-8">
                        <textarea id="mytextarea" name="mytextarea" rows="7" cols="50"></textarea>
                    </div>
                </div>

                <!--
                Buttons here
                -->
                <!-- add hidden field to identify what action is being taken (lost,found,sighting) -->

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-4">
                        <a href="${pageContext.request.contextPath}/" class="btn btn-default">Cancel</a>
                    </div>
                    <div class="col-md-4">
                        <input type="submit" class="btn btn-default" value="Submit"/>
                    </div>
                </div>
            </div>
        </sf:form>
    </div>
</div>
</div>

<!-- End row div -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/AmazingAutoBlog.js"></script>
</body>

<footer style="color:blue;margin-left:30px;">
    <hr>
    <center>Jan Gentille - Director of Pet Services</center>
    <center>123 North Main Street, Anywhere, USA</center>
    <center>800-873-5463</center>
    <hr>
</footer>
</html>