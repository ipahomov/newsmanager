<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <h1>${news.title}</h1>
    <p>
        <i>${news.annotation}</i>
    </p>
    <p>${news.maintext}</p>
    <p>Автор статьи: ${news.author} | Дата: ${news.releaseDate}</p>
    <a href="/home">Back</a>

