<%-- 
    Document   : c_redirect
    Created on : Sep 30, 2022, 8:45:49 AM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <c:set var="url" value="0" scope="request"/>  
  <c:if test="${url<1}">  
     <c:redirect url="https://www.amazon.in"/>  
  </c:if>  
  <c:if test="${url>1}">  
     <c:redirect url="https://www.google.co.in"/>  
  </c:if>  

    </body>
</html>
