<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:update-teacher-popup/>


<c:forEach var="teacher" items="${requestScope.teachers}">
    <div class="col-xs-12 col-sm-8 col-md-4">
        <div id="teacher${teacher.key}" class="card mb-4 shadow-sm">

            <h3 class="name text-center font-weight-lighter">${teacher.value.name}</h3>
            <p class="age text-center font-weight-lighter">${teacher.value.age}</p>
            <p class="salary text-center font-weight-lighter">${teacher.value.salary}</p>
            <p class="id text-center font-weight-lighter">${teacher.key}</p>


            <button type="button" class="btn change-btn btn-success btn-sm btn-block"
                    data-id-teacher="${teacher.key}">Change attribute
            </button>

            <form action="/web-app/salary" method="post">
                <input name="id" type="hidden" value="${teacher.key}" class="form-control">
                <input name="name" type="hidden" value="${teacher.value.name}" class="form-control">
                <input name="age" type="hidden" value="${teacher.value.age}" class="form-control">
                <input name="salary" type="hidden" value="${teacher.value.salary}" class="form-control">
                <button type="submit" class="btn btn-info btn-sm btn-block">Average salary</button>
            </form>

            <form action="/web-app/delete-teacher" method="post">
                <input name="id" type="hidden" value="${teacher.key}" class="form-control">
                <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
            </form>
        </div>
    </div>
</c:forEach>

<div class="col-xs-12 col-sm-8 col-md-4">
    <div class="card mb-4 shadow-sm">
        <button type="button" class="btn create-teacher-btn btn-outline-success btn-lg btn-block">Create new
            teacher
        </button>
    </div>
</div>






