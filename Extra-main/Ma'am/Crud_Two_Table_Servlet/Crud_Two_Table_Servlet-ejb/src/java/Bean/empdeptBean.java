/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Department;
import Entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hi
 */
@Stateless
public class empdeptBean implements empdeptBeanLocal {

    @PersistenceContext(unitName = "Crud_Two_Table_Servlet-ejbPU")
    EntityManager em;
    @Override
    public List<Employee> getrecord() 
    {
        List<Employee> lst=em.createNamedQuery("Employee.findAll").getResultList();
        return lst;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String insert( int deptid,String name) 
    {
        try
        {
            Employee e=new Employee();
            Department d= em.find(Department.class,deptid);
            e.setEmpName(name);
            e.setDeptId(d);
            em.persist(e);
            return "Inserted";
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String delete(int eid)
    {
         try
         {
             Employee e=em.find(Employee.class, eid);
             em.remove(e);
             return "Deleted";
         }
         catch(Exception e)
         {
             System.err.println(e.getMessage());
             return null;
         }
    }

    @Override
    public String update(int eid,int deptid, String name)
    {
        try
        {
            Employee e=em.find(Employee.class,eid);
            Department d=em.find(Department.class,deptid);
            e.setEmpName(name);
            e.setDeptId(d);
            em.merge(e);
            return "Updated";
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Department> getdept()
    {
        List<Department> ls=em.createNamedQuery("Department.findAll").getResultList();
        return ls;
    }

    @Override
    public Employee search(int eid)
    {
            try
            {
                Employee e=em.find(Employee.class, eid);
                return e;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }
    }
}
