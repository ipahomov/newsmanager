<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Dear <strong>${user}</strong>, You are not authorized to access this page
<c:url var="logout" value="/logout"/>
<a href="${logout}">Logout</a>
