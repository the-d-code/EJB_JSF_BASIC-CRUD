<%-- 
    Document   : error
    Created on : Aug 28, 2022, 5:36:32 PM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h3>Sorry an exception occured!</h3>  
  
Exception is: <%= exception %>  

    </body>
</html>
