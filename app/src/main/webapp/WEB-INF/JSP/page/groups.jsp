<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="groupList">

    <div class="row load-more">
        <jsp:include page="/WEB-INF/JSP/fragment/group-list.jsp"/>
    </div>

    <div>
        <button type="button" class="btn create-group-btn btn-success btn-sm btn-block">Create new group</button>
    </div>
</div>
