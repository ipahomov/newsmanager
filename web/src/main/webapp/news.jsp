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

#section {
	width: auto;
	float: left;
	padding: 10px;
}

#footer {
	background-color: gray;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
<title>news page</title>
</head>
<body>
	<div id="header">
		<h1>${news.title}</h1>
	</div>

	<p>
		<i>${news.annotation}</i>
	</p>
	<p>${news.maintext}</p>
	<p>Автор статьи: ${news.author} | Дата: ${news.releaseDate}</p>
	<p>
		<a
			href="SiteController?action=editnews&id=<c:out value="${news.newsId }"/>">EditNews</a>
		| <a
			href="SiteController?action=deletenews&id=<c:out value="${news.newsId }"/>">DeleteNews</a>
		<a href="SiteController">Back</a>
	<div id="footer">Copyright © it.academy.com</div>
</body>
</html>