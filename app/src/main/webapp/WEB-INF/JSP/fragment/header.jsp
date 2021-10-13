<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ishop" tagdir="/WEB-INF/tags" %>

<div class="jumbotron text-center jum_bg">
    <h1>iCourse</h1>
    <p>itAcademy</p>
    <c:choose>
        <c:when test="${CURRENT_ACCOUNT != null }">
            <ul class="nav navbar-nav navbar-right">
                <li><a>Welcome ${CURRENT_ACCOUNT.description }</a></li><br>
                <form action="/web-app/sign-out" method="post">
                    <li><button type="submit" class="btn btn-dark btn-sm">Sign-out</button></li>
                </form>
            </ul>
        </c:when>
    </c:choose>
</div>
