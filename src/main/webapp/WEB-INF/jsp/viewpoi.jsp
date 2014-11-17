<%-- 
    Document   : viewpoi
    Created on : Nov 17, 2014, 1:10:12 PM
    Author     : mekko
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            Poi nome: ${poi.name} <br>
            Poi latitude: ${poi.latitude} <br>
            Poi Longitude: ${poi.longitude} <br>
            Poi Short Description: ${poi.shortDescription} <br>
            Poi categories: ${poi.categories} <br>


            <c:if test="${not empty cover}">
                Link alla cover: ${cover.link} <br>
            </c:if>

            <c:if test="${not empty image_gallery}">
                Link galleria immagini: 
                <c:forEach var="link" items="${image_gallery.links}">
                    ${link},
                </c:forEach>
            </c:if>
            <br>
            <c:if test="${not empty title}">
                Titolo del poi: ${title.title}
            </c:if>
        </p>
    </body>
</html>
