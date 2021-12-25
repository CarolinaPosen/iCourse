<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:update-mark-popup/>
<popup:add-new-mark/>
<c:set var="month" value="0"/>

<div>
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-4">
            <div class="card mb-8 shadow-sm">
                <h1>${requestScope.student.name}</h1>
            </div>
            <div id="student-id-main" class="card mb-4 shadow-sm">
                <p class="student-id-main  font-weight-lighter">${requestScope.student.id}</p>
            </div>
        </div>
    </div>

    <br>

    <div class="row">
        <c:forEach var="mark" items="${requestScope.student.marks}">
            <div class="col-xs-12 col-sm-8 col-md-4">

                <div id="mark${mark.id}" class="card mb-4 shadow-sm">

                    <p class="id font-weight-lighter">${mark.id}</p>
                    <h2 class="mark  font-weight-lighter">${mark.mark}</h2>
                    <h3 class="themeTitle  font-weight-lighter">${mark.theme.title}</h3>
                    <p class="theme-id  font-weight-lighter">${mark.theme.id}</p>
                    <p class="date  font-weight-lighter">${mark.date}</p>
                    <p class="student-id  font-weight-lighter">${requestScope.student.id}</p>

                    <button type="button" class="btn change-mark-btn btn-success btn-block "
                            data-id-mark="${mark.id}">Change mark
                    </button>

                    <form action="${pageContext.request.contextPath}/delete-mark" method="post">
                        <input name="id" type="hidden" value="${mark.id}" class="form-control">
                        <input type="hidden" name="student" class="student" value="${requestScope.student.id}">
                        <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="col-xs-12 col-sm-8 col-md-4">
        <div class="card mb-4 shadow-sm">
            <button type="button" class="btn create-mark-btn btn-outline-success btn-lg btn-block"
                    data-id-student=60>
                Create new mark
            </button>
        </div>
    </div>

</div>