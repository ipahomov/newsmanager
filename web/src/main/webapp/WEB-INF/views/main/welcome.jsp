<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">News manager</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <c:url var="authorUrl" value="/author"/>
            <form action="${authorUrl}" method="get" class="navbar-form navbar-right">
                <%--<div class="form-group">
                    <label for="inputEmail" class="sr-only"><i class="fa fa-user"></i></label>
                    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email" required="required">
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="sr-only"><i class="fa fa-lock"></i></label>
                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
                </div>
                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />--%>
                <button type="submit" class="btn btn-success">I am author</button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <%--<div class="container">--%>
        <h1>Hello, friend</h1>
        <p>This is a news manager project. You can find here the latest and interesting news.
            Also, you can become one of our authors to share your articles with the world.</p>
        <p><a class="btn btn-primary" href="#" role="button">Learn more »</a></p>
    <%--</div>--%>
</div>

    <!-- row of columns -->
    <div class="row">
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
            <div class="list-group">
                <a href="/home" class="list-group-item active">
                    All news
                </a>

                <c:forEach var="category" items="${categories }">
                    <spring:url value="/showByCategory/${category.categoryName}" var="categoryUrl"/>
                    <a
                            href="${categoryUrl}" class="list-group-item">${category.categoryName }</a>
                </c:forEach>

            </div>
        </div><!--/.sidebar-offcanvas-->


        <div class="col-xs-12 col-md-9" id="news">
            <c:if test="${!empty newslist}">
                <c:forEach items="${newslist}" var="news">
                    <spring:url value="/shownews/${news.newsId}" var="newsUrl"/>

                    <div class="col-md-5">
                        <h2>${news.title}</h2>
                        <p>${news.annotation}</p>
                        <p><a class="btn btn-default" href="${newsUrl}" role="button">View news »</a></p>
                    </div>

                </c:forEach>
            </c:if>
        </div>
</div>