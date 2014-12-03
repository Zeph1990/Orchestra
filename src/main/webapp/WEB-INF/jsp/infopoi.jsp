<%-- 
    Document   : infopoi
    Created on : 2-dic-2014, 12.10.28
    Author     : Alex
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <link href="./dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="./dist/js/bootstrap.min.js"></script>
        <script src="./dist/js/bootbox.min.js"></script>
        <link href="./dist/materialDesign/dist/css/ripples.min.css" rel="stylesheet">
        <link href="./dist//css/font-awesome.min.css" rel="stylesheet">
        <link href="./dist/materialDesign/dist/css/material-wfont.css" rel="stylesheet">
        <script src="./dist/materialDesign/dist/js/ripples.min.js"></script>
        <script src="./dist/materialDesign/dist/js/material.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty coverimg}">
            <jsp:include page="components/CoverComponent.jsp"/>
        </c:if>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Info </h3>
                                </div>
                                <div class="panel-body">
                                    Poi nome: ${poi.name} <br>
                                    Poi latitude: ${poi.location[0]} <br>
                                    Poi Longitude: ${poi.location[1]} <br>
                                    Poi Short Description: ${poi.shortDescription} <br>
                                    Poi categories: ${poi.categories} <br>
                                </div>
                            </div>
                            <jsp:include page="components/ContactsComponent.jsp"/>
                            <c:if test="${not empty title}">
                                Titolo del poi: ${title.title}<br>
                            </c:if>
                            <c:if test="${not empty description}">
                                <c:forEach var="descr" items="${description.sectionsList}">
                                    ${descr.title}<br>
                                    ${descr.description}<br>
                                </c:forEach>
                            </c:if>
                            
                            </p>
                        </div>
                        <div class="col-md-8">
                            <c:if test="${not empty imagegallery}">
                                <jsp:include page="components/ImgGalleryComponent.jsp"/> 
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                             <script>
            $(document).ready(function() {
                $.material.init();
            });
        </script>
    </body>
    
</html>

