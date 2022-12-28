<%-- 
    Document   : set_get
    Created on : Aug 28, 2022, 6:14:44 PM
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
        <jsp:useBean id="u" class="mypack.myclass">
            
        </jsp:useBean>  
        <jsp:setProperty property="name" name="u" value="cc" />  
  
Record:<br>  
<jsp:getProperty property="name" name="u"/><br>  
<jsp:getProperty property="password" name="u"/><br>  
<jsp:getProperty property="email" name="u" /><br>  
    </body>
</html>
