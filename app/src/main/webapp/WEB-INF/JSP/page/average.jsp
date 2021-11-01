<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:add-new-teacher/>
<c:set var="month" value="0"/>

<div id="teacherList">

    <h1>NAME: ${requestScope.teacher.name}</h1>
    <h2>AVERAGE SALARY: ${requestScope.average}</h2>

    <div class="row load-more">
        <form action="/web-app/salary" method="post">
            <h2>COUNT OF MONTH:<input name="count" value="12" class="form-control"></h2><br>

            <c:forEach var="salary" items="${requestScope.teacher.salaries}">

                <input name="id" type="hidden" value="${requestScope.teacher.id}" class="form-control">
                <input name="name" type="hidden" value="${requestScope.teacher.name}" class="form-control">
                <input name="login" type="hidden" value="${requestScope.teacher.login}" class="form-control">
                <input name="password" type="hidden" value="${requestScope.teacher.password}" class="form-control">

                    <c:set var="month" value="${month + 1}"/>
                    DATE:${salary.date}
                    <input type="number" name="month${month}" value="${salary.salary}" class="form-control"><br>
            </c:forEach>

            <button type="submit" class="btn btn-info btn-sm btn-block">Change average salary</button>
        </form>
    </div>
</div>



