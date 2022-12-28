<%-- 
    Document   : EmployeeShow
    Created on : Feb 11, 2020, 11:29:31 PM
    Author     : Hi
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Employee"%>
<%@page import="Bean.empdeptBeanLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<center><a href="EmployeeForm.jsp">Add Record</a></center>
<br/><br/>
<table border="1" align="center">
    <tr>
        <th>Employee Name:</th>
        <th>Dept Name:</th>
        <th colspan="2">Operations</th>
    </tr>
<%
     InitialContext c= new InitialContext();
     empdeptBeanLocal el=(empdeptBeanLocal)c.lookup("java:global/Crud_Two_Table_Servlet/Crud_Two_Table_Servlet-ejb/empdeptBean!Bean.empdeptBeanLocal");
     if(request.getParameter("id") != null)
     {
         int sid=Integer.parseInt(request.getParameter("id"));
         el.delete(sid);
     }
     
     List<Employee> lst=el.getrecord();
     for(int i=0;i<lst.size();i++)
     {
         Employee e=lst.get(i);
         out.println("<tr>");
         out.println("<td>"+ e.getEmpName()+"</td>");
         out.println("<td>"+ e.getDeptId().getDeptName() +"</td>");
         out.println("<td><a href=EmployeeForm.jsp?id="+ e.getEmpId()+">Edit</a></td>");
         out.println("<td><a href=EmployeeShow.jsp?id="+ e.getEmpId()+">Delete</a></td>");
         out.println("</tr>");
     }


%>
</table>