<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Welcome</h1>
	<br>
	<h3>Login, please</h3>
	<form action="LoginController" method="post">
		<b>Input email:</b><br> <input name="email"> <br> <b>Input
			password:</b><br> <input name="password"> <input
			type="submit" value="login">
	</form>

</body>
</html>