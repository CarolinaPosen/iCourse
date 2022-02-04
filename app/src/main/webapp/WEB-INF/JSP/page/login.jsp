<html lang="en">
<head>
    <meta charset="utf-8">
    <title>iCourse - Login</title>
    <link rel="shortcut icon" href="#">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <form class="col-4">
            <div class="form-group">
                <form class="form-signin" method="post" action="${pageContext.request.contextPath}/auth/login">
                    <h2 class="form-signin-heading text-center">iCourse Login</h2>
                    <p>
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
                    </p>
                    <p>
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                    </p>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </form>
    </div>
</div>

</body>
</html>