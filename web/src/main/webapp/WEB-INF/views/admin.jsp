<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin page</title>
</head>
<body>
	Dear <strong>${user}</strong>, Welcome to Admin Page.
	<c:url var="logout" value="/logout"/>
	<a href="${logout}">Logout</a>
</body>
</html>

