<%-- 
    Document   : second
    Created on : Aug 28, 2022, 5:22:23 PM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%   
  HttpSession sc = request.getSession();
String name=(String)sc.getAttribute("user");  
out.print("Hello "+name);  
  
%>  

    </body>
</html>
