<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<h1>${news.title}</h1>

<p>
    <i>${news.annotation}</i>
</p>

<p>${news.maintext}</p>

<p>Author: ${news.author} | Date: ${news.releaseDate}</p>

<c:url value="/" var="back"/>
<a href="${back}">Back</a>

