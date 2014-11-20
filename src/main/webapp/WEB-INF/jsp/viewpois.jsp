<%-- 
    Document   : viewpois
    Created on : 20-nov-2014, 12.26.00
    Author     : Alex
--%>

<%@page import="java.util.List"%>
<%@page import="com.orchestra.portale.persistence.mongo.documents.PoiMongo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visuallizza tutti i POI</title>
    </head>
    <body>
        <c:forEach var="i" begin="0" end="${ListaPoi.size()-1}">
            ID = <c:out value="${ListaPoi.get(i).getId()}" /><br>
            NOME = <c:out value="${ListaPoi.get(i).getName()}" /> <br>
            LATITUDINE = ${ListaPoi.get(i).getLatitude()}<br>
            LONGITUDINE = ${ListaPoi.get(i).getLongitude()}<br>
            DESCRIZIONE = ${ListaPoi.get(i).getShortDescription()}<br><br>
        </c:forEach>
    </body>
</html>
