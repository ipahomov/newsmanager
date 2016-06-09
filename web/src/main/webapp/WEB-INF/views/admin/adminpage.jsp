<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<security:authorize access="isAuthenticated()">
    <security:authentication property="principal.username" var="username"/>
</security:authorize>

<%-- Navbar --%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">News manager</a>
        </div>

        <p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">
            ${username}
        </a>
            <c:url var="logout" value="/logout"/>
            <a href="${logout}">Logout</a>
        </p>
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Hello, ${username}!</h1>

        <p>This is all yours! Do what ever you want!</p>

        <p>
            <c:url value="/admin/addPage" var="addPage"/>
            <a href="${addPage}" class="btn btn-primary">Add News</a>
        </p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
            <div class="list-group">
                <c:url value="/admin" var="back"/>
                <a href="${back}" class="list-group-item active">
                    All news
                </a>

                <c:forEach var="category" items="${categories }">
                    <spring:url value="/admin/showByCategory/${category.categoryName}" var="categoryUrl"/>
                    <a
                            href="${categoryUrl}" class="list-group-item">${category.categoryName }</a>
                </c:forEach>

            </div>
        </div><!--/.sidebar-offcanvas-->

        <%-- News --%>
        <div class="col-xs-12 col-md-9" id="news">
            <c:if test="${!empty newslist}">
                <c:forEach items="${newslist}" var="news">
                    <c:url value="/admin/shownews/${news.newsId}" var="newsInfo"/>
                    <c:url value="/admin/editNews/${news.newsId}" var="newsEdit"/>
                    <c:url value="/admin/deleteNews/${news.newsId}" var="newsDelete"/>

                    <div class="col-md-6">
                        <h3>${news.title}</h3>

                        <p>${news.annotation}</p>

                        <p><i>${news.author}</i></p>

                        <!-- Split button -->
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                Action <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="${newsInfo}">Show news</a></li>
                                <li><a href="${newsEdit}">Edit</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="${newsDelete}">Delete</a></li>
                            </ul>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>
    </div>
</div>