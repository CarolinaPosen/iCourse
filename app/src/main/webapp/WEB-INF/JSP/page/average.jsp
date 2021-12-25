<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:update-salary-popup/>
<popup:add-new-salary/>
<c:set var="month" value="0"/>

<div>
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-4">
            <div class="card mb-8 shadow-sm">
            <h1>NAME: ${requestScope.teacher.name}</h1>
            <h2>AVERAGE SALARY: ${requestScope.average}</h2>
            </div>
            <div class="card mb-4 shadow-sm">
                <form action="/web-app/salary" method="post">
                    <h2>COUNT OF MONTH:<input name="month" class="form-control" type="number" max="${requestScope.teacher.salaries.size()}">
                        <input id="trainer_id" name="id" type="hidden" value="${requestScope.teacher.id}"></h2>
                    <button type="submit" class="btn btn-info btn-sm btn-block">Calculate average salary</button>
                </form>
            </div>
        </div>
    </div>

    <br>

    <div class="row">
        <c:forEach var="salary" items="${requestScope.teacher.salaries}">
            <div class="col-xs-12 col-sm-8 col-md-4">

                <div id="salary${salary.id}" class="card mb-4 shadow-sm">

                    <p class="id font-weight-lighter">${salary.id}</p>
                    <h2 class="salary  font-weight-lighter">${salary.salary}</h2>
                    <p class="date  font-weight-lighter">${salary.date}</p>
                    <p class="trainer  font-weight-lighter">${requestScope.teacher.id}</p>

                    <button type="button" class="btn change-salary-btn btn-success btn-block "
                            data-id-salary="${salary.id}">Change salary
                    </button>

                    <form action="${pageContext.request.contextPath}/delete-salary" method="post">
                        <input name="id" type="hidden" value="${salary.id}" class="form-control">
                        <input type="hidden" name="teacher" class="teacher" value="${requestScope.teacher.id}">
                        <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<div class="col-xs-12 col-sm-8 col-md-4">
    <div class="card mb-4 shadow-sm">
        <button type="button" class="btn create-salary-btn btn-outline-success btn-lg btn-block"
                data-id-teacher="${requestScope.teacher.id}">
            Create new salary
        </button>
    </div>
</div>