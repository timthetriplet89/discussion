<%-- 
    Document   : viewPosts
    Created on : Mar 29, 2016, 9:59:59 PM
    Author     : Timothy
--%>

<%@page import="com.mycompany.discussion3.Bean123"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/DiscussionThread2/styles.css">
    </head>
    <body>
        <h1>Discussion Thread</h1>

<!--MVC model (with Bean)  
http://www.javatpoint.com/MVC-in-jsp  -->

<div id="thread_div">
<%
   // How to get attribute on jsp page
   // http://www.coderanch.com/t/445845/JSP/java/request-getAttribute-returns-null-jsp 
   Bean123 bean = (Bean123)request.getAttribute("bean"); 
   
   // If there is a bean with the discussion posts set...
    if (bean != null) {
        if(!bean.isListEmpty()) { // and if there are discussion posts...
           ArrayList<String> posts = bean.getList();
           for (String post : posts) {
               out.println("<p>" + post + "</p>"); // Display the posts!
           }
        } else {
            out.println("I guess there are no posts to show");
        }
    } else {
       out.println("Noone has posted to this discussion board yet.");
    }

 %> 

</div> 
<br>
<p>Go back to <a href="/DiscussionThread2/newPost.jsp">enter a new post.</a></p>
     
    </body>
</html>
