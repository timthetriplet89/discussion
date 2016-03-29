<%-- 
    Document   : welcome
    Created on : Mar 1, 2016, 7:39:18 PM
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
        <!-- <h1>Welcome! ${username} </h1>-->
        <h1>Enter New Post</h1>
        <form action="CreatePost" method="POST">
            <label for="postText">What do you have to say?</label>
            <textarea id="postText" name="postText" rows="4" cols="65"></textarea>
            <button type="submit">Submit</button>
        </form>
        <br><a href="/discussion3/Logout">Logout</a>
        <br><br><br><br>
        
        <h5>Or <a href="/discussion3/LoadPosts">view current posts</a></h5>
    </body>
</html>
