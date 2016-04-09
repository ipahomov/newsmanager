<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add&Edit news</title>
</head>
<body>
	<h1>Add or edit news</h1>
	<form action="SiteController">
		<input type="hidden" name="action" value="addnews">
		<fieldset>
			<div>
				<input type="hidden" name="id" value="${news.id}" />
			</div>
			<div>
				<b>Category:</b><br>
				<input type="text" size="60" name="categoryId"
					value="${news.categoryId}" />
			</div>
			<div>
				<b>Title</b><br>
				<input type="text" size="60" name="title" value="${news.title}" />
			</div>
			<div>
				<b>Annotation</b><br>
				<input type="text" size="60" name="annotation" value="${news.annotation}" />
			</div>
			<div>
				<b>Maintext:</b><br>
				<textarea rows="10" cols="100" name="maintext">${news.maintext}</textarea>
			</div>


			<div>
				<input type="submit" value="Save" />
				<c:if test="${news.id == null}"/>
				<input type="reset" value="Reset" />
				<a href="SiteController">Cancel</a>
			</div>
		</fieldset>
	</form>


</body>
</html>