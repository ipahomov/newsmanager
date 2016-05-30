<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#header {
	background-color: gray;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: auto;
	width: 100px;
	float: left;
	padding: 5px;
}

#section {
	width: auto;
	float: left;
	padding-left: 110px;
	padding-top: 10px;
}

#footer {
	background-color: gray;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
<title>News manager</title>
	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		Welcome, ${sessionScope.get("user").firstName}
		<a href="#">Logout</a>
	<div id="header">
		<h1>News Manager</h1>
	</div>

	<div id="nav" style="position: fixed;">
		<a href="SiteController">All news</a>
		<br>
		<c:forEach var="category" items="${categories }">
			<a
				href="SiteController?action=showbycat&catId=<c:out value="${category.categoryName }"/>">${category.categoryName }</a>
			<br>

		</c:forEach>
		<hr>
		<a href="#">Add Category</a>
	</div>

	<div id="section">
		<h2 style="padding-left: 60px">News List</h2>

		<ul style="list-style-type: square">
			<hr>
			<c:forEach var="news" items="${allnews }">
				<li><h3>
						<a
							href="SiteController?action=shownews&id=<c:out value="${news.newsId }"/>">${news.title }</a>
					</h3></li>
				<p>${news.author }| Дата: ${news.releaseDate }
				<hr>
			</c:forEach>
		</ul>
		<p>
			<a href="SiteController?action=addnewsPage" class="btn btn-primary">Add News</a>
		</p>
	</div>
	</div>
	<div id="footer">Copyright © it.academy.com</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>