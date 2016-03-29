<%-- 
    Document   : login
    Created on : Mar 1, 2016, 7:19:01 PM
    Author     : Timothy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Into World...</h1>
        <form action="Signin" method="post">
            <input type="text" name="username"/>
            <input type="password" name="password"/>
            <button type="submit">Login</button>
        </form>
    </body>
</html>
