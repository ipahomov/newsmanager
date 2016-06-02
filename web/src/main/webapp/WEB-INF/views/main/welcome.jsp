<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>
            <a class="navbar-brand" href="#">News manager</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <c:url var="authorUrl" value="/author"/>
            <form action="${authorUrl}" method="get" class="navbar-form navbar-right">
                <%--<div class="form-group">
                    <label for="inputEmail" class="sr-only"><i class="fa fa-user"></i></label>
                    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email" required="required">
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="sr-only"><i class="fa fa-lock"></i></label>
                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
                </div>
                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />--%>
                <button type="submit" class="btn btn-success"><spring:message code="button.author.sign"/> </button>
            </form>
            <p class="navbar-text navbar-right">
                <a href="?locale=en" class="navbar-link">Eng</a> |
                <a href="?locale=ru" class="navbar-link">Рус</a>
            </p>

        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <%--<div class="container">--%>
        <h1><spring:message code="page.header.greeting" /> </h1>
        <p><spring:message code="page.header.info" /></p>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            Learn more
        </button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel"><spring:message code="page.main.descriprion.title" /></h4>
                    </div>
                    <div class="modal-body">
                        <p><spring:message code="page.main.description.text" /></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    <%--</div>--%>
</div>

    <!-- row of columns -->
    <div class="row">
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
            <div class="list-group">
                <c:url value="/home" var="back"/>
                <a href="${back}" class="list-group-item active">
                    All news
                </a>

                <c:forEach var="category" items="${categories }">
                    <c:url value="/showByCategory/${category.categoryName}" var="categoryUrl"/>
                    <a
                            href="${categoryUrl}" class="list-group-item">${category.categoryName }</a>
                </c:forEach>

            </div>
        </div><!--/.sidebar-offcanvas-->


        <div class="col-xs-12 col-md-9" id="news">
            <c:if test="${!empty newslist}">
                <c:forEach items="${newslist}" var="news">
                    <c:url value="/shownews/${news.newsId}" var="newsUrl"/>

                    <div class="col-md-6">
                        <h3>${news.title}</h3>
                        <p>${news.annotation}</p>
                        <p><a class="btn btn-default" href="${newsUrl}" role="button"><spring:message code="button.welcome.news"/> »</a></p>
                    </div>

                </c:forEach>
            </c:if>









            <%--<c:url var="first" value="/user/list"/>
            <a href="${first}" class="btn btn-primary" role="button">First</a>

            <c:url var="next" value="/user/list/${nextPage}"/>
            <a href="${next}" class="btn btn-primary" role="button">Next</a>--%>




            <%--<nav>
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="0" end="lastPage">
                    <li><a href="#"></a></li>
                    </c:forEach>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>--%>

        </div>


        <ul class="pagination">
           <%-- Left --%>
            <c:choose>
                <c:when test="${(currentPage - 1) lt 1}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="./home?page=${currentPage - 1}&newsPerPage=${newsPerPage}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>

            <%-- Currents --%>
            <c:forEach begin="1" end="${count}" varStatus="loop">
                <c:choose>
                    <c:when test="${currentPage == loop.count}">
                        <li class="active"><a href="#">${loop.count}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="./home?page=${loop.count}&newsPerPage=${newsPerPage}">${loop.count}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%-- Right --%>
            <c:choose>
                <c:when test="${(currentPage + 1) gt count}">
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="./home?page=${currentPage + 1}&newsPerPage=${newsPerPage}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>




        <%--<form:radiobutton path="newsPerPage" value="2"></form:radiobutton>
        <form:radiobutton path="newsPerPage" value="4"></form:radiobutton>--%>


        <%--<c:url var="first" value="/user/list"/>
        <a href="${first}" class="btn btn-primary" role="button">First</a>

        <c:url var="next" value="/user/list/${nextPage}"/>
        <a href="${next}" class="btn btn-primary" role="button">Next</a>--%>


        <%--<div id="pagination">

            <c:url value="/home" var="prev">
                <c:param name="page" value="${page-1}"/>
            </c:url>
            <c:if test="${page > 1}">
                <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
            </c:if>

            <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                <c:choose>
                    <c:when test="${page == i.index}">
                        <span>${i.index}</span>
                    </c:when>
                    <c:otherwise>
                        <c:url value="/home" var="url">
                            <c:param name="page" value="${i.index}"/>
                        </c:url>
                        <a href='<c:out value="${url}" />'>${i.index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:url value="/home" var="next">
                <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <a href='<c:out value="${next}" />' class="pn next">Next</a>
            </c:if>
        </div>--%>



</div>

