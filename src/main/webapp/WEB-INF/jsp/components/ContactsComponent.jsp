<%-- 
    Document   : ContactsComponent
    Created on : 1-dic-2014, 14.31.40
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>


<div class="panel panel-danger">
    <div class="panel-heading">
        <h3 class="panel-title">Contatti </h3>
    </div>
    <div class="panel-body">
        <center>
        <c:if test="${not empty contacts.emailsList}">
              
        <b>Contatti Email:</b><br>
        <c:forEach var="contm" items="${contacts.emailsList}">
                                    <b>${contm.label}:</b>
                                   <a href="mailto:${contm.email}" target="_top"> ${contm.email}</a><br>
                                </c:forEach>
                                    <br>
                                    </c:if>
                                    <c:if test="${not empty contacts.phoneList}">
                                    <b>Contatti Telefonici:</b><br>
                                    <c:forEach var="cont" items="${contacts.phoneList}">
                                        <b>${cont.label}:</b>
                                        ${cont.number}<br>
                                </c:forEach>
                                        <br>
                                    </c:if>
                                    <c:if test="${not empty contacts.faxList}">
                                    <b>Fax:</b><br>
                                    <c:forEach var="cont" items="${contacts.faxList}">
                                        <b>${cont.label}:</b>
                                        ${cont.fax}<br>
                                </c:forEach>
                                        <br>
                                    </c:if>
                                    <c:if test="${not empty contacts.facebook}">    
                                    <a href="#" class="btn btn-material-blue btn-fab fa fa-facebook"></a>
                                    </c:if>
                                    <c:if test="${not empty contacts.twitter}">    
                                    <a href="${contacts.twitter}" class="btn btn-material-lightblue btn-fab fa fa-twitter"></a>
                                    </c:if>
                                    <c:if test="${not empty contacts.google}">    
                                    <a href="${contacts.google}" class="btn btn-material-red btn-fab fa fa-google-plus"></a>
                                    </c:if>
                                    <c:if test="${not empty contacts.skype}">    
                                    <a href="${contacts.skype}" class="btn btn-material-lightblue btn-fab fa fa-skype"></a>
                                    </c:if>
                                    <c:if test="${not empty contacts.socialList}">
                                        <c:forEach var="cont" items="${contacts.socialList}">
                                            <a href="${cont.social}" class="btn btn-success btn-fab "></a>
                                        </c:forEach>
                                    </c:if>
                                    </center>
                                        
    </div>  
</div>




