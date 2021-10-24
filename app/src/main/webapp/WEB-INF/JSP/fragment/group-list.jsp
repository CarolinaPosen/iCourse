<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>

<c:forEach var="group" items="${requestScope.groups}">
    <div class="col-xs-12 col-sm-8 col-md-4">
        <div id="student${group.key}" class="card mb-4 shadow-sm">

            <p class="id text-center font-weight-lighter">${group.key}</p>
            <h3 class="name text-center font-weight-lighter">${group.value.title}</h3>
            <p class="age text-center font-weight-lighter">${group.value.teacher}</p>
            <p class="salary text-center font-weight-lighter">${group.value.students}</p>
            <p class="salary text-center font-weight-lighter">${group.value.themes}</p>


            <button type="button" class="btn change-btn btn-success btn-sm btn-block"
                    data-id-group="${group.key}">Change attribute
            </button>

            <form action="/web-app/salary" method="post">
                <input name="id" type="hidden" value="${group.key}" class="form-control">
                <input name="name" type="hidden" value="${group.value.title}" class="form-control">
                <input name="age" type="hidden" value="${group.value.teacher}" class="form-control">
                <input name="salary" type="hidden" value="${group.value.students}" class="form-control">
                <button type="submit" class="btn btn-info btn-sm btn-block">Average salary</button>
            </form>

            <form action="/web-app/delete-teacher" method="post">
                <input name="id" type="hidden" value="${group.key}" class="form-control">
                <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
            </form>
        </div>
    </div>
</c:forEach>



