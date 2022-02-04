<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:update-group-popup/>
<popup:add-new-group/>

<c:forEach var="group" items="${requestScope.groups}">
    <div class="col-xs-12 col-sm-8 col-md-4">
        <div id="group${group.key}" class="card mb-4 shadow-sm">

            <p class="id text-center font-weight-lighter">${group.key}</p> <br>
            <h3 class="name text-center font-weight-lighter">${group.value.title}</h3> <br>
            Trainer:
            <p class="age text-center font-weight-lighter">${group.value.trainer.name}</p><br>
<%--            <p class="salary text-center font-weight-lighter">${group.value.students}</p>--%>
<%--            <p class="salary text-center font-weight-lighter">${group.value.themes}</p>--%>

            Students:
            <ol>
            <c:forEach var="student" items="${group.value.students}">
                <li class="student text-center font-weight-lighter">${student.name}</li>
            </c:forEach>
            <br>
            </ol>

            Themes:
            <ul>
            <c:forEach var="theme" items="${group.value.themes}">
                <li class="theme text-center font-weight-lighter">${theme.title}</li>
            </c:forEach>
            </ul>

            <button type="button" class="btn change-btn btn-success btn-sm btn-block"
                    data-id-group="${group.key}">Change groups name
            </button>

            <form action="${pageContext.request.contextPath}/group-students-edit" method="post">
                <input name="group-id" type="hidden" value="${group.key}" class="form-control">
                <button type="submit" class="btn btn-info btn-sm btn-block">Group students</button>
            </form>

            <form action="/web-app/delete-group" method="post">
                <input name="id" type="hidden" value="${group.key}" class="form-control">
                <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
            </form>
        </div>
    </div>
</c:forEach>



