<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="popup" %>
<popup:add-new-teacher/>

<div id="productList">

    <div class="row load-more">
    <jsp:include page="/WEB-INF/JSP/fragment/teacher-list.jsp"/>
    </div>

    <div>
        <button type="button" class="btn create-teacher-btn btn-success btn-sm btn-block">Create new teacher</button>
    </div>
</div>

