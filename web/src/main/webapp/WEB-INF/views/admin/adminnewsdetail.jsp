<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<h1>${news.title}</h1>

<p>
    <strong>${news.annotation}</strong>
</p>

<h4>${news.maintext}</h4>

<p>Author: ${news.author} | Date: ${news.releaseDate}</p>

<%-- Buttons group --%>
<spring:url value="/admin" var="back"/>
<spring:url value="/admin/editNews/${news.newsId}" var="newsEdit"/>
<spring:url value="/admin/deleteNews/${news.newsId}" var="newsDelete"/>
<a class="btn btn-default" href="${back}" role="button">Back</a>
<a class="btn btn-info" href="${newsEdit}" role="button">Edit</a>
<a class="btn btn-danger" href="${newsDelete}" role="button">Delete</a>

