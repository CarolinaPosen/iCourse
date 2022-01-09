<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>

<head>

    <title>iCourse itAcademy</title>

    <link rel="shortcut icon" href="#">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<header>
    <jsp:include page="fragment/header.jsp"/>
</header>

<div class="container-fluid">

    <div class="row">
        <div class="col-sm-5 col-md-4 col-lg-3 col-xl-3">
            <aside>
                <jsp:include page="fragment/aside.jsp"/>
            </aside>
        </div>
        <div class="col-sm-7 col-md-8 col-lg-9 col-xs-9">
            <main>
                <jsp:include page="${requestScope.currentPage}"/>
                <script>alert(${requestScope.currentPage})</script>
            </main>
        </div>
    </div>

</div>

<footer class="footer" style="background-color: #d0e9c6">
</footer>

<script src="${pageContext.request.contextPath}/resources/js/update-group-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/update-teacher-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/create-teacher-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/update-student-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/create-student-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/update-salary-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/create-salary-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/update-mark-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/create-mark-popup.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jsontest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app-ajax.js"></script>
</body>
</html>
