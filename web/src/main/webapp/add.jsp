<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add&Edit news</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container-fluid" style="padding-top: 30px">
    <div class="row-fluid">
        <div class="span12">
            <legend>Add or edit news</legend>

            <form action="SiteController" class="form-horizontal" style="width: 800px">
                <input type="hidden" name="action" value="addnews">
                <input type="hidden" name="id" value="${news.id}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Category</label>

                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="categoryId" value="${news.categoryId}">
                    </div>
                    <%--<div class="col-sm-3">
                        <c:if test="${not empty errorCategory}">
                            <span style="color: red"><c:out value="${errorCategory}"/></span>
                        </c:if>
                    </div>--%>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Title</label>

                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="title" value="${news.title}">
                    </div>
                    <%--<div class="col-sm-3">
                        <c:if test="${not empty errorTitle}">
                            <span style="color: red"><c:out value="${errorTitle}"/></span>
                        </c:if>
                    </div>--%>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Annotation</label>

                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="annotation" value="${news.annotation}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Maintext</label>

                    <div class="col-sm-7">
                        <textarea rows="10" cols="100" class="form-control" name="maintext">${news.maintext}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <c:if test="${news.id == null}">
                            <button type="reset" class="btn btn-default">Reset</button>
                        </c:if>
                        <a href="SiteController" class="btn btn-default" role="button">Cancel</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>