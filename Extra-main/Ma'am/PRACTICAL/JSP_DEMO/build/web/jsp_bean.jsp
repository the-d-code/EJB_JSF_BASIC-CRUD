<%-- 
    Document   : jsp_bean
    Created on : Aug 28, 2022, 6:06:20 PM
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
        <jsp:useBean id="obj" class="mypack.Calculator"/>  
  
<%  
int m=obj.cube(5);  
out.print("cube of 5 is "+m);  
%>  
    </body>
</html>
