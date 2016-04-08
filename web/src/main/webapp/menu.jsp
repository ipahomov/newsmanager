<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
</head>
<body>

	<div id="header">
		<h1>News Manager</h1>
	</div>

	<div id="nav" style="position: fixed;">
		<c:forEach var="category" items="${categories }">
			<a
				href="SiteController?action=showbycat&catId=<c:out value="${category.catId }"/>">${category.catId }</a>
			<br>

		</c:forEach>
		<a href="#">Add Category</a>
	</div>

	<div id="section">
		<h2>News List</h2>

		<ul style="list-style-type: square">
			<hr>
			<c:forEach var="news" items="${allnews }">
				<li><h3>
						<a
							href="SiteController?action=shownews&id=<c:out value="${news.id }"/>">${news.title }</a>
					</h3></li>
				<p>${news.author }| Дата: ${news.releaseDate }
				<hr>
			</c:forEach>
		</ul>
		<h2 align="center">
			<a href="SiteController?action=addnewsPage">Add News</a>
		</h2>
	</div>

	<div id="footer">Copyright © it.academy.com</div>
</body>
</html>