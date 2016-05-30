<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <tiles:insertAttribute  name="title"/>
    <c:if test="${not empty title}">
        <title>${title}</title>
    </c:if>
    <!-- Bootstrap -->
    <link href="/assets/css/bootstrap-theme.css" rel="stylesheet">
    <link href="/assets/css/bootstrap.css" rel="stylesheet">
</head>
<body>
    <div class="jumbotron">
        <tiles:insertAttribute name="header"/>
    </div>

    <div class="container">
        <tiles:insertAttribute name="body"/>
    </div>

    <footer class="modal-footer">
        <tiles:insertAttribute name="footer"/>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/assets/js/jquery-1.11.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/assets/js/bootstrap.js"></script>
</body>
</html>
