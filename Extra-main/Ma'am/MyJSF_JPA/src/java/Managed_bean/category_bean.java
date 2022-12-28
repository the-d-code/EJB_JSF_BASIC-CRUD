/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed_bean;

import entity_bean.Category;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Named(value = "category_bean")
@SessionScoped
public class category_bean implements Serializable {
int category_id;
String category_name;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @PersistenceContext(unitName = "MyJSF_JPAPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of category_bean
     */
    public category_bean() {
    }
    //insertCategory
    public String insertCategory(){
        try{
            if(category_id>0) {
                Category c=em.find(Category.class,category_id);
                c.setCategoryId(category_id);
                c.setCategoryName(category_name);
                utx.begin();
                em.merge(c);
                utx.commit();
            }
            else{
                Category c=new Category();
        c.setCategoryId(category_id);
        c.setCategoryName(category_name);
        utx.begin();
        em.persist(c);
        utx.commit();
            }
         return "category_show.xhtml";
        }
        catch(Exception ex){
            ex.getMessage();
        }
    return null;
    }
    public List<Category> showCategory()
    {
        try{
            List<Category> lt=em.createNamedQuery("Category.findAll").getResultList();
            return lt;
        }
        catch(Exception ex)
        {
            System.out.print("error"+ex);
        }
    return null;
    }
    //delete
    public String deleteCategory(int category_id){
        try{
            Category c=em.find(Category.class, category_id);
            utx.begin();
            Category c1=em.merge(c);
            em.remove(c1);
            utx.commit();
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    return null;
    }
    public String searchCategory(int category_id)
    {
        try{
            Category c=em.find(Category.class,category_id);
            category_id=c.getCategoryId();
            category_name=c.getCategoryName();
            return "category_form.xhtml";
        }
        catch(Exception ex){
            System.out.print("error"+ex);
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
