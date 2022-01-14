<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:update-student-popup/>
<popup:add-new-student/>

<c:forEach var="student" items="${requestScope.group.students}">
    <div class="col-xs-12 col-sm-8 col-md-4">
        <div id="student${student.id}" class="card mb-4 shadow-sm">

            <h3 class="name text-center font-weight-lighter">${student.name}</h3>
            <p class="login text-center font-weight-lighter">${student.login}</p>
            <p class="password text-center font-weight-lighter">${student.password}</p>
                <%--<p class="salary text-center font-weight-lighter">${teacher.value.salaries}</p>--%>
            <p class="id text-center font-weight-lighter">${student.id}</p>

            <button type="button" class="btn change-btn btn-success btn-sm btn-block"
                    data-id-student="${student.id}">Change student data
            </button>

            <form action="${pageContext.request.contextPath}/marks" method="post">
                <input name="id" type="hidden" value="${student.id}" class="form-control">
                <input name="name" type="hidden" value="${student.name}" class="form-control">
                <input name="login" type="hidden" value="${student.login}" class="form-control">
                <input name="salary" type="hidden" value="${student.marks}" class="form-control">
                <button type="submit" class="btn btn-info btn-sm btn-block">Show marks</button>
            </form>

            <form action="${pageContext.request.contextPath}/delete-student" method="post">
                <input name="id" type="hidden" value="${student.id}" class="form-control">
                <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
            </form>
        </div>
    </div>
</c:forEach>

<div class="col-xs-12 col-sm-8 col-md-4">
    <div class="card mb-4 shadow-sm">
        <button type="button" class="btn create-student-btn btn-outline-success btn-lg btn-block"
                data-id-group="${requestScope.group.id}">Create new student in group: "${requestScope.group.title}"
        </button>
    </div>
</div>



