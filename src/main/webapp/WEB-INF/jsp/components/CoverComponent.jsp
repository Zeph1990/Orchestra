<%-- 
    Document   : CoverComponent
    Created on : 2-dic-2014, 12.45.06
    Author     : Marco Valentino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="
     height: 300px; 
     overflow: hidden; 
     background: url(./dist/poi/img/${poi.id}/${coverimg.link});
     background-size: cover;
     width: 100%;">
</div>
<div style="position: absolute; top: 250px;" class="col-md-12">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="well text-center" style="background-color: #03a9f4; color: white;">
            <h3><b>${poi.name}</b></h3>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>
<div style="padding: 40px;"></div>