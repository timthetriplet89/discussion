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
        <link rel="stylesheet" href="/DiscussionThread2/styles.css">
    </head>
    <body>
        <h1>Enter New Post</h1>
        <form action="CreatePost" method="POST">
            <label for="postText">What do you have to say?</label><br>
            <textarea id="postText" name="postText" rows="4" cols="65"></textarea><br>
            <button type="submit">Submit</button>
        </form>
        <br>
        <p>Or <a href="/DiscussionThread2/LoadPosts">View Current Posts</a></p>
        <br>
        <a href="/DiscussionThread2/Logout">Logout</a>
        <br><br>
    </body>
</html>
