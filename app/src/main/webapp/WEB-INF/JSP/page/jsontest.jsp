<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:add-new-teacher/>


<c:set var="credential" value=""/>

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


        <div class="col-xs-12 col-sm-8 col-md-4">
            <div id="teacher" class="card mb-4 shadow-sm">

                <section1>

                </section1>

                <section2>

                </section2>

                <h3 class="name text-center font-weight-lighter"></h3>
                <p class="login text-center font-weight-lighter"></p>
                <p class="password text-center font-weight-lighter"></p>
                <p class="salary text-center font-weight-lighter"></p>
                <p class="id text-center font-weight-lighter"></p>


                <button type="button" class="btn change-btn btn-success btn-sm btn-block"
                        data-id-teacher="777">Change attribute
                </button>

                <form action="/web-app/salary" method="post">
                    <input name="id" type="hidden" value="" class="form-control">
                    <input name="name" type="hidden" value="" class="form-control">
                    <input name="login" type="hidden" value="" class="form-control">
                    <input name="salary" type="hidden" value="" class="form-control">
                    <button type="submit" class="btn btn-info btn-sm btn-block">Average salary</button>
                </form>

                <form action="/web-app/delete-teacher" method="post">
                    <input name="id" type="hidden" value="" class="form-control">
                    <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
                </form>
            </div>
        </div>

</div>



    <div id="jsontest">

    <div>
        <button type="button" class="btn btn-jsontest btn-success btn-sm btn-block">JSON-TEST</button>
    </div>
</div>

