<%-- 
    Document   : uppercase
    Created on : Sep 29, 2022, 8:29:59 AM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <c:set var="site" value="google.com"/>  
  <c:set var="author" value="ABCD"/>  
  Hi, This is ${fn:toUpperCase(site)} developed by ${fn:toUpperCase(author)}.  

    </body>
</html>
