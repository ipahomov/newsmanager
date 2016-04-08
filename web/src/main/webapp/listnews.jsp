<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List News</title>
<style>
#header {
	background-color: gray;
	color: white;
	text-align: center;
	padding: 5px;
}
</style>
</head>
<body>

	<div id="header">
		<h1>List News</h1>
	</div>

	<ul style="list-style-type: square">
		<c:forEach var="news" items="${listNews }">

			<li><h3>
					<a href="ListNews?action=shownews&id=<c:out value="${news.id }"/>">${news.title }</a>
				</h3></li>
			<p>${news.annotation }</p>
			<hr>
		</c:forEach>
	</ul>

</body>
</html>