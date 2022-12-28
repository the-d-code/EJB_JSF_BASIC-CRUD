<%-- 
    Document   : x_if
    Created on : Sep 30, 2022, 8:22:04 AM
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="vegetables">  
<vegetables>  
    <vegetable>  
      <name>onion</name>  
      <price>40</price>  
    </vegetable>  
 <vegetable>  
      <name>Potato</name>  
      <price>30</price>  
    </vegetable>  
 <vegetable>  
      <name>Tomato</name>  
      <price>90</price>  
    </vegetable>  
</vegetables>  
</c:set>  
<x:parse xml="${vegetables}" var="output"/>  
<x:if select="$output/vegetables/vegetable/price < 100">  
   Vegetables prices are very low.  
</x:if>  

    </body>
</html>
