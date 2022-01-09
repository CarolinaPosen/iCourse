<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>Signin - iCourse</title>

    <link href="${pageContext.request.contextPath}/static/css/signin.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

</head>
        <main class="form-signin">
            <form action="${pageContext.request.contextPath}/sign-in" method="post">

                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <div class="form-floating">
                    <input type="email" name="login" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="form-floating mb-3">
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                </div>

                <div class="form-floating mb-3">
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
                </div>

            </form>
        </main>
<body class="text-center">
</body>

<script src="${pageContext.request.contextPath}/static/css/signin.css"></script>
<script src="${pageContext.request.contextPath}/static/css/bootstrap.min.css"></script>

</html>
