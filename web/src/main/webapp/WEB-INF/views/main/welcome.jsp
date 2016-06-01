<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            <span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>
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
                <button type="submit" class="btn btn-success"><spring:message code="button.author.sign"/> </button>
            </form>
            <p class="navbar-text navbar-right">
                <a href="?locale=en" class="navbar-link">Eng</a> |
                <a href="?locale=ru" class="navbar-link">Рус</a>
            </p>

        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <%--<div class="container">--%>
        <h1><spring:message code="page.header.greeting" /> </h1>
        <p><spring:message code="page.header.info" /></p>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            Learn more
        </button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel"><spring:message code="page.main.descriprion.title" /></h4>
                    </div>
                    <div class="modal-body">
                        <p><spring:message code="page.main.description.text" /></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
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

                    <div class="col-md-6">
                        <h3>${news.title}</h3>
                        <p>${news.annotation}</p>
                        <p><a class="btn btn-default" href="${newsUrl}" role="button"><spring:message code="button.welcome.news"/> »</a></p>
                    </div>

                </c:forEach>
            </c:if>

            <%--<nav>
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="0" end="lastPage">
                    <li><a href="#"></a></li>
                    </c:forEach>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>--%>

        </div>
</div>

