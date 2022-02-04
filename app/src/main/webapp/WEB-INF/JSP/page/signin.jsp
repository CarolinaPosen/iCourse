<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signin</title>
</head>
<body>
<form method="post" action="j_security_check">

    <input type="text" name="j_username">
    <input type="password" name="j_password">
    <button type="submit" class="btn btn-warning btn-sm btn-block">log in</button>

</form>
</body>
</html>
