<%-- 
    Document   : infopoi
    Created on : 25-nov-2014, 12.05.07
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${nome}
    <center>
        <p>
            Nome: ${poi.name} <br>
            Latitudine: ${poi.latitude} <br>
            Longitudine: ${poi.longitude} <br>
            Descrizione breve: ${poi.shortDescription} <br>
            Categorie: ${poi.categories} <br>
            

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
        <a href="allpois">Torna Indietro</a>
        </center>
    </body>
</html>
