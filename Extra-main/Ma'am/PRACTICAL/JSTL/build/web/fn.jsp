<%-- 
    Document   : fn
    Created on : Sep 29, 2022, 8:24:11 AM
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
        
        <c:set var="String" value="Welcome"/>  
  
<c:if test="${fn:contains(String, 'Welcome')}">  
   <p>Found Welcome string<p>  
</c:if>  
  
<c:if test="${fn:contains(String, 'WELCOME')}">  
   <p>Found WELCOME string<p>  
</c:if>  
  

    </body>
</html>
