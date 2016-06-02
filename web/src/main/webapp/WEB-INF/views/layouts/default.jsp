<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap-theme.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
</head>
<body>
    <%--<div class="jumbotron">--%>
        <tiles:insertAttribute name="header"/>
    <%--</div>--%>

    <div class="container">
        <tiles:insertAttribute name="body"/>
    </div>

    <div class="container">
    <footer class="modal-footer">
        <tiles:insertAttribute name="footer"/>
    </footer>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
</body>
</html>
