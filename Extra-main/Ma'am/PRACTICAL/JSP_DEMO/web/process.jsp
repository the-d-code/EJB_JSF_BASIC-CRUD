
<%-- 
    Document   : process
    Created on : Aug 28, 2022, 5:35:58 PM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  
  
String num1=request.getParameter("n1");  
String num2=request.getParameter("n2");  
  
int a=Integer.parseInt(num1);  
int b=Integer.parseInt(num2);  
int c=a/b;  
out.print("division of numbers is: "+c);  
  
%>  

    </body>
</html>
