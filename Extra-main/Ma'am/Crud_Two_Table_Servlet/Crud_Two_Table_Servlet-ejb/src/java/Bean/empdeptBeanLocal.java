/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Department;
import Entity.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hi
 */
@Local
public interface empdeptBeanLocal 
{
       public List<Employee> getrecord();
       public String insert(int deptid,String name);
       public String delete(int eid);
       public String update(int eid,int deptid,String name);
       public List<Department> getdept();
       public Employee search(int eid);
}
