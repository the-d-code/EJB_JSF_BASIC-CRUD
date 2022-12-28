/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Department;
import Entity.Employee;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Hi
 */
@Named(value = "empdep")
@SessionScoped
public class empdep implements Serializable {

    @EJB empdeptBeanLocal ebl;
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    String sname;
    int sid;
    int deptid;
    /**
     * Creates a new instance of empdep
     */
    public empdep() {
    }
    public List<Department> getdep()
    {
        return ebl.getdept();
    }
    public String empinsert()
    {
        if(sid > 0)
        {
            ebl.update(sid, deptid, sname);
        }
        else
        {
        ebl.insert(deptid, sname);
        }
        sid=0;
        sname="";
        deptid=0;
        return "index.xhtml";
    }
    public List<Employee> empshow()
    {
        List<Employee>ls=ebl.getrecord();
        return ls;
    }
    public void empdelete(int sid)
    {
        ebl.delete(sid);
    }
    public String empsearch(int id)
    {
        Employee e=ebl.search(id);
        sid=e.getEmpId();
        sname=e.getEmpName();
        return "EmployeeForm.xhtml";
    }
}
