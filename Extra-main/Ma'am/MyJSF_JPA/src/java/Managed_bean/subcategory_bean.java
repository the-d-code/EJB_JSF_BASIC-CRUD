/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed_bean;

import entity_bean.Category;
import entity_bean.Subcategory;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Named(value = "subcategory_bean")
@SessionScoped
public class subcategory_bean implements Serializable {
int subcategory_id;
int category_id;
String subcategory_name;
    @PersistenceContext(unitName = "MyJSF_JPAPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public int getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(int subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getSubcategory_name() {
        return subcategory_name;
    }

    public void setSubcategory_name(String subcategory_name) {
        this.subcategory_name = subcategory_name;
    }
        
    /**
     * Creates a new instance of subcategory_bean
     */
    public subcategory_bean() {
    }
public String insertSubcategory()
{
    try{
        Subcategory sc=new Subcategory();
        sc.setSubcategoryId(subcategory_id);
        Category d=em.find(Category.class,category_id);
        sc.setCategoryId(d);
        sc.setSubcategoryName(subcategory_name);
        utx.begin();
        em.persist(sc);
        utx.commit();
        return "subcategory_show.xhtml";
    }
    catch(Exception ex){
        ex.getMessage();
    }
    return null;
}
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}
