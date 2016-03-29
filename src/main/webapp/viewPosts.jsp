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
    </head>
    <body>
        <h1>One Small Step For Man...</h1>

<!-- MVC model (with Bean)  
<!-- http://www.javatpoint.com/MVC-in-jsp --> 

<%
    
//   
//   // First attempt
   Bean123 bean = (Bean123)request.getAttribute("bean"); 
   
   if (bean != null) { 
//       out.println("bean = null"); 
//   } else { 
//       out.println("bean is NOT null"); 
//   } 
   
//   
//   // How to get attribute from jsp page ROUND 2
//   // http://stackoverflow.com/questions/25621497/get-attribute-from-servletcontext-on-jsp-page  
////    ServletContext sc = request.getServletContext();
//    Bean123 bean = (Bean123)sc.getAttribute("attributeName");
//   
//    // How to get attribute on jsp page, ROUND 3
//    // http://www.coderanch.com/t/445845/JSP/java/request-getAttribute-returns-null-jsp 
//    Bean123 bean = (Bean123)request.getAttribute("bean"); 
//   
////   FOR DEBUGGING    
////    if(bean == null) {
////       out.println("bean = null!");
////   } else {
////       out.println("bean is not null");
////   }
//  

   if(!bean.isListEmpty()) { 
      ArrayList<String> posts = bean.getList(); 
      for (String post : posts) { 
          out.println("<p>" + post + "</p>"); 
      } 
   } else { 
       out.println("I guess there are no posts to show"); 
   } 
//} else { 
//    out.println("Noone has posted to this discussio board yet."); 
} else { 
       out.println("Noone has posted to this discussion board yet."); 
} 
       
//   // How to access Bean Variables from JSP page --> 
//   // http://stackoverflow.com/questions/19297397/jstl-foreach-bean-having-a-list-of-beans-as-property --> 
//   //pageContext.setAttribute("allPosts", posts); 
//   //out.println("Welcome, "+bean.getName()); 
 %> 
 
 
 
     
    </body>
</html>
