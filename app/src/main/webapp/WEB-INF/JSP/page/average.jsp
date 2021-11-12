<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:update-salary-popup/>
<c:set var="month" value="0"/>

<div id="teacherList">

    <h1>NAME: ${requestScope.teacher.name}</h1>
    <h2>AVERAGE SALARY: ${requestScope.average}</h2>

    <div class="row load-more">
        <form action="/web-app/salary" method="post">
            <h2>COUNT OF MONTH:<input name="count" value="12" class="form-control"></h2><br>

            <c:forEach var="salary" items="${requestScope.teacher.salaries}">

                <%-- <input name="id" type="hidden" value="${requestScope.teacher.id}" class="form-control">
                 <input name="name" type="hidden" value="${requestScope.teacher.name}" class="form-control">
                 <input name="login" type="hidden" value="${requestScope.teacher.login}" class="form-control">
                 <input name="password" type="hidden" value="${requestScope.teacher.password}" class="form-control">

                     <c:set var="month" value="${month + 1}"/>
                     DATE:${salary.date}
                     <input type="number" name="month${month}" value="${salary.salary}" class="form-control"><br>--%>

                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div id="salary${salary.id}" class="card mb-12 shadow-sm">

                        <h3 class="id text-center font-weight-lighter">${salary.id}</h3>
                        <p class="salary text-center font-weight-lighter">${salary.salary}</p>
                        <p class="date text-center font-weight-lighter">${salary.date}</p>


                        <button type="button" class="btn change-salary-btn btn-success btn-sm btn-block"
                                data-id-salary="${salary.id}">Change salary
                        </button>


                        <form action="/web-app/delete-salary" method="post">
                            <input name="id" type="hidden" value="${salary.id}" class="form-control">
                            <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
                        </form>
                    </div>
                </div>

            </c:forEach>

<%--            <script>--%>
<%--                var jsonBlob = {--%>
<%--                    <c:forEach items="${requestScope.teacher.salaries}" var="state" varStatus="loop">--%>
<%--                    "${state.id}": ${state.salary} ${not loop.last ? ',' : ''}--%>
<%--                    </c:forEach>--%>
<%--                };--%>
<%--            </script>--%>

            <button type="submit" class="btn btn-info btn-sm btn-block">Change average salary</button>
        </form>
    </div>
</div>



