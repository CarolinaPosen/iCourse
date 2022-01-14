<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>

<div id="teacherList">

    <div>

        <h3>"GROUP NAME: ${requestScope.group.title}"</h3>
        <h6>"GROUP ID: ${requestScope.group.id}"</h6>

        <div class="row load-more">
            <jsp:include page="/WEB-INF/JSP/fragment/group-student-list.jsp"/>
        </div>
    </div>

</div>
