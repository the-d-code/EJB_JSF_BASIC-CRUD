<%-- 
    Document   : EmployeeForm
    Created on : Feb 11, 2020, 11:04:58 PM
    Author     : Hi
--%>

<%@page import="Entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Department"%>
<%@page import="Bean.empdeptBeanLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! Employee e= new Employee(0,"");%>
<%
           e= new Employee(0,"");
           e.setDeptId(new Department(0));
           InitialContext c= new InitialContext();
           empdeptBeanLocal el=(empdeptBeanLocal)c.lookup("java:global/Crud_Two_Table_Servlet/Crud_Two_Table_Servlet-ejb/empdeptBean!Bean.empdeptBeanLocal");
           List<Department> ls=el.getdept();
           //out.print("ls"+ ls.size());
           if(request.getParameter("id") != null)
           {
               int id=Integer.parseInt(request.getParameter("id"));
               e=el.search(id);
           }
           if(request.getParameter("s1") != null)
           {
               int eid=Integer.parseInt(request.getParameter("sid"));
               String name=request.getParameter("ename");
               int dept=Integer.parseInt(request.getParameter("combo"));
               
               if(eid > 0)
               {
                //Employee e= new Employee();   
                el.update(eid,dept,name);
               // e= new Employee(0,"");
               //e.setDeptId(new Department());
                response.sendRedirect("EmployeeShow.jsp");
                
               }
               else
               {
               el.insert(dept, name);
               //e= new Employee(0,"");
               //e.setDeptId(new Department());
               response.sendRedirect("EmployeeShow.jsp");
               }
           }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <input type="hidden" name="sid" value="<%= e.getEmpId() %>">
            <label>Enter Name Of Employee:</label>
            <input type="text" name="ename" id="ename" value="<%= e.getEmpName() %>">
            <br/><br/>
            <label>Choose Your Dept.</label>
                         <select name="combo">
                <%
                    for(int i=0;i<ls.size();i++)
                    {
                        Department d=ls.get(i);
                        if(d.getDeptId()==e.getDeptId().getDeptId())
                        {
                        
                 %>
                 <option  selected="true" value="<%= d.getDeptId() %>"><%= d.getDeptName() %></option>
                 <%
                     }
                     else
                       {
                        %>
                          <option value="<%= d.getDeptId() %>"><%= d.getDeptName() %></option>
                          <%
                                    }
                                }
 
%>
            </select>

            <br/><br/>
        
            <input type="submit" name="s1" value="Insert">
        </form>
    </body>
</html>
