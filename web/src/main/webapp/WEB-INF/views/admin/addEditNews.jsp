<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container-fluid" style="padding-top: 30px">
    <div class="row-fluid">
        <div class="span12">
            <legend>Add or edit news</legend>
            <c:url var="addAction" value="/admin/addNews"/>
            <form:form action="${addAction}" modelAttribute="news" method="post" class="form-horizontal"
                       style="width: 800px">

                <form:input path="newsId" id="newsId" type="hidden"/>

                <div class="form-group">
                    <label for="category" class="col-sm-2 control-label">Category</label>

                    <div class="col-sm-7">
                        <form:select path="categoryName" type="text" class="form-control" name="category"
                                     value="${news.categoryName}">
                            <c:forEach var="category" items="${categories }">
                                <form:option value="${category.categoryName }"/>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">Title</label>

                    <div class="col-sm-7">
                        <form:errors path="title" cssStyle="color: red"/>
                        <form:input path="title" type="text" class="form-control" id="title" value="${news.title}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="annotation" class="col-sm-2 control-label">Annotation</label>

                    <div class="col-sm-7">
                        <form:errors path="annotation" cssStyle="color: red"/>
                        <form:input path="annotation" type="text" class="form-control" name="annotation"
                                    value="${news.annotation}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="maintext" class="col-sm-2 control-label">Maintext</label>

                    <div class="col-sm-7">
                        <form:errors path="maintext" cssStyle="color: red"/>
                        <form:textarea path="maintext" rows="10" cols="100" class="form-control"
                                       name="maintext"/>
                    </div>
                </div>

                <%-- Buttons --%>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <c:if test="${news.newsId == null}">
                            <button type="reset" class="btn btn-default">Reset</button>
                        </c:if>
                        <c:url value="/admin" var="back"/>
                        <a href="${back}" class="btn btn-default" role="button">Cancel</a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
