<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:add-new-teacher/>

<div id="teacherList">

    <div class="row load-more">
        <jsp:include page="/WEB-INF/JSP/fragment/student-list.jsp"/>
    </div>

    <div>
        <button type="button" class="btn create-student-btn btn-success btn-sm btn-block">Create new student</button>
    </div>
</div>
