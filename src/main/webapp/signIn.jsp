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
        <link rel="stylesheet" href="/DiscussionThread2/styles.css">
    </head>
    <body>
        <h1>Welcome To Discussion Thread</h1>
        <h2>Please Sign In</h2>
        <form action="Signin" method="post">
            <label for="username">Username</label><br>
            <input type="text" name="username"/><br><br>
            <label for="password">Password</label><br>
            <input type="password" name="password"/><br><br>
            <button type="submit">Login</button>
        </form>
    </body>
</html>
