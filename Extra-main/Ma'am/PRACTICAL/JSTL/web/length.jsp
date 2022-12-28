<%-- 
    Document   : length
    Created on : Sep 29, 2022, 8:32:12 AM
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
        <c:set var="str1" value="This is first string"/>  
<c:set var="str2" value="Hello"/>  

Length of the String-1 is: ${fn:length(str1)}<br>  
Length of the String-2 is: ${fn:length(str2)}  

    </body>
</html>
