<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

    <head>
        <title>Login</title>
    </head>
    <body>
    <h1>${msg}</h1>
        <form method="post" action="login">
            <div class="box">
                <h1>Login</h1>

                <p><input name="username" placeholder="User Name" required /></p>

                <p><input type="password" placeholder="Password" name="password" required /></p>

                <p><input type="submit" value="Log In!" /></p>

                <p><label><input type="checkbox" name="rememberMe" /> Remember Me!</label></p>
            </div>

        </form>

    </body>
</html>
