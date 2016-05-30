<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <!-- Bootstrap -->
    <link href="/assets/css/bootstrap-theme.css" rel="stylesheet">
    <link href="/assets/css/bootstrap.css" rel="stylesheet">
    <link href="/assets/css/signin.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <c:url var="loginUrl" value="/j_spring_security_check"/>
    <form action="${loginUrl}" method="post" class="form-signin">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p>Invalid username and password.</p>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only"><i class="fa fa-user"></i></label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
        <label for="inputPassword" class="sr-only"><i class="fa fa-lock"></i></label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
       <%-- <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>--%>
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/assets/js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/assets/js/bootstrap.js"></script>
</body>
</html>
