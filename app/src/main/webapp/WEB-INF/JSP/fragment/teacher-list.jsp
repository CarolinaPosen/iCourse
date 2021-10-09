<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:update-teacher-popup/>

    <c:forEach var="teacher" items="${requestScope.teachers}">
        <div class="col-xs-12 col-sm-8 col-md-4">
            <div id="product${teacher.key}" class="card mb-4 shadow-sm">

                <h3 class="name text-center font-weight-lighter">${teacher.value.name}</h3>
                <p class="age text-center font-weight-lighter">${teacher.value.age}</p>
                <p class="salary text-center font-weight-lighter">${teacher.value.salary}</p>
                <p class="id text-center font-weight-lighter">${teacher.key}</p>


                <%--<div class="col-sm-12">
                    <div class="row">

                        <div class="img__container mx-auto d-block">
                            <img src="${pageContext.request.contextPath}/media/images/icons/place.png">
                            <div class="img__description">
                                <span class="badge badge-pill badge-info">${teacher.numberOfSeats}</span>
                            </div>
                        </div>

                        <div class="img__container mx-auto d-block">
                            <img src="${pageContext.request.contextPath}/media/images/icons/door.png">
                            <div class="img__description">
                                <span class="badge badge-pill badge-info">${teacher.numberOfDoors}</span>
                            </div>
                        </div>

                        <div class="img__container mx-auto d-block">
                            <img src="${pageContext.request.contextPath}/media/images/icons/fuel.png">
                            <div class="img__description">
                                <span class="badge badge-pill badge-info">${teacher.fuelConsumption}</span>
                            </div>
                        </div>

                        <div class="img__container mx-auto d-block">
                            <img src="${pageContext.request.contextPath}/media/images/icons/engine.png">
                            <div class="img__description">
                                <span class="badge badge-pill badge-info">${teacher.engine}</span>
                            </div>
                        </div>

                        <div class="img__container mx-auto d-block">
                            <img src="${pageContext.request.contextPath}/media/images/icons/refueling.png">
                            <div class="img__description">
                                <span class="badge badge-pill badge-info">${teacher.fuelConsumption}</span>
                            </div>
                        </div>

                        <div class="img__container mx-auto d-block">
                            <img src="${pageContext.request.contextPath}/media/images/icons/snow.png">
                            <div class="img__description">
                                <span class="badge badge-pill badge-info">${teacher.conditioning}</span>
                            </div>
                        </div>
                    </div>
                </div>--%>
                <button type="button" class="btn change-btn btn-success btn-sm btn-block" data-id-teacher="${teacher.key}">Change attribute</button>

                <form action="/web-app/delete-teacher" method="post">
                    <input name="id" type="hidden"  value="${teacher.key}" class="form-control">
                    <button type="submit" class="btn btn-warning btn-sm btn-block">Delete</button>
                </form>

            </div>
        </div>
    </c:forEach>



