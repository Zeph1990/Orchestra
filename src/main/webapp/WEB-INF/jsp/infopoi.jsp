<%-- 
    Document   : infopoi
    Created on : 2-dic-2014, 12.10.28
    Author     : Alex
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <!--JQUERY JS--> 
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Bootstrap core CSS -->
        <link href="./dist/css/bootstrap.min.css" rel="stylesheet">
        <!--FONT AWESOME CSS-->
        <link href="./dist/css/font-awesome.min.css" rel="stylesheet">
        <!--BOOTSTRAP JS-->
        <script src="./dist/js/bootstrap.min.js"></script>
        <!--BOOTBOX JS-->
        <script src="./dist/js/bootbox.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            Poi nome: ${poi.name} <br>
            Poi latitude: ${poi.location[0]} <br>
            Poi Longitude: ${poi.location[1]} <br>
            Poi Short Description: ${poi.shortDescription} <br>
            Poi categories: ${poi.categories} <br>


            <c:if test="${not empty coverimg}">
                cover: ${coverimg.link} <br>
            </c:if>

            <c:if test="${not empty imagegallery}">
                <div class="container">
            <div class="row">
                
                <div class="col-md-8">
                    <jsp:include page="components/ImgGalleryComponent.jsp" /> 
                </div>
                <div class="col-md-4">
                    <jsp:include page="components/ContactsComponent.jsp" />
                </div>
            </div>
                </div>
        </c:if>
        <br>
        <c:if test="${not empty title}">
            Titolo del poi: ${title.title}<br>
        </c:if>
        <c:if test="${not empty description}">
            <c:forEach var="descr" items="${description.sectionsList}">
                ${descr.title}<br>
                ${descr.description}<br>
            </c:forEach>
        </c:if>
        <c:if test="${not empty contacts}">
            <c:forEach var="cont" items="${contacts.phoneList}">
                ${cont.label}:<br>
                ${cont.number}<br><br>
                </c:forEach>
            <c:forEach var="contm" items="${contacts.emailsList}">
                ${contm.label}:<br>
                ${contm.email}<br><br>
            </c:forEach>
                ${contacts.facebook}<br>
                ${contacts.twitter}<br>
        </c:if>
    </p>
</body>
</html>

