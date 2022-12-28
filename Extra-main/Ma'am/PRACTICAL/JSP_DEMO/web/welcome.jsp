<%-- 
    Document   : welcome
    Created on : Aug 28, 2022, 5:20:03 PM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="index.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%   
 
String name=request.getParameter("uname");  
out.print("Welcome "+name);  
  
HttpSession sc = request.getSession();
sc.setAttribute("user",name);  
 
out.print("<a href=second.jsp>second jsp page</a>");  
  
%>  

    </body>
</html>
