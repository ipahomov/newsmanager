<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<h1>${news.title}</h1>
    <p>
        <i>${news.annotation}</i>
    </p>
    <p>${news.maintext}</p>
    <p>Автор статьи: ${news.author} | Дата: ${news.releaseDate}</p>

<div class="btn-group" role="group" aria-label="...">
    <button type="button" class="btn btn-default" href="/admin">Back</button>
    <button type="button" class="btn btn-info" href="/admin/editNews/${news.newsId}">Edit</button>
    <button type="button" class="btn btn-danger" href="/admin/deletenews/${news.newsId}">Delete</button>
</div>

