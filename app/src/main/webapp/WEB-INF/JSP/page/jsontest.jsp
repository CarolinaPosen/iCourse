<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:add-new-teacher/>

    <section1>

    </section1>

    <section2>

    </section2>


<c:set var="user" value=""/>

<div id="jsonReceiver">

<%--                        <div class="list-group hidden-xs adv-chars">
                            ID:<input type="number" name="id" class="id" name="id" class="form-control"><br>
                            NAME:<input type="text" name="name" class="name" class="form-control"><br>
                            LOGIN:<input type="text" name="login" class="login" class="form-control"><br>
                            PASSWORD:<input type="text" name="password" class="password" class="form-control"><br>
                            ROLE:<p><select name="role" size="3" multiple>
                            <option selected type="number" value="1"> Administrator</option>
                            <option type="number" value="2"> Manager</option>
                            <option type="number" value="3"> User</option>
                        </select><br>
                        </div>--%>


    <c:forEach var="teacher" items="${user}">
        <div class="col-xs-12 col-sm-8 col-md-4">
            <div id="teacher${teacher.key}" class="card mb-4 shadow-sm">

                <h3 class="name text-center font-weight-lighter">${teacher.value.name}</h3>
                <p class="login text-center font-weight-lighter">${teacher.value.login}</p>
                <p class="password text-center font-weight-lighter">${teacher.value.password}</p>
                <p class="salary text-center font-weight-lighter">${teacher.value.salary}</p>
                <p class="id text-center font-weight-lighter">${teacher.key}</p>


                <button type="button" class="btn change-btn btn-success btn-sm btn-block"
                        data-id-teacher="${teacher.key}">Change attribute
                </button>

                <form action="/web-app/salary" method="post">
                    <input name="id" type="hidden" value="${teacher.key}" class="form-control">
                    <input name="name" type="hidden" value="${teacher.value.name}" class="form-control">
                    <input name="login" type="hidden" value="${teacher.value.login}" class="form-control">
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

</div>






    <div id="jsontest">

    <div>
        <button type="button" class="btn btn-jsontest btn-success btn-sm btn-block">JSON-TEST</button>
    </div>
</div>

