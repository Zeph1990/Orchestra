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
        <c:if test="${not empty cover}">
            <div id="cover">

            </div>
        </c:if>
        <c:if test="${not empty image_gallery}">
        <div id="imagegalley">

        </div>
        </c:if>
        <c:if test="${not empty title}">
        <div id="title">
            ${title.title}
        </div>
        </c:if>
    </body>
</html>
