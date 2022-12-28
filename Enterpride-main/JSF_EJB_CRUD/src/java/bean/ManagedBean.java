/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.SessionBeanLocal;
import entity.Category;
import entity.Item;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author HP
 */
@Named(value = "ManagedBean")
@SessionScoped
public class ManagedBean implements Serializable {

    @EJB
    private SessionBeanLocal sbl;

    public SessionBeanLocal getSbl() {
        return sbl;
    }

    public void setSbl(SessionBeanLocal sbl) {
        this.sbl = sbl;
    }
    
    
    
    //Category
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
    
    public List<Category> findAllCategory(){
        return sbl.findAllCategory();
    }
    
    public String addCategory(){
        try{
            sbl.addCategory(category_name);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "category.jsf?faces-redirect=true";
    }
    
    public String searchCategory(int cid){
        Category category = sbl.searchCategory(cid);
        category_id = category.getCategoryId();
        category_name = category.getCategoryName();
        
        return "update_category.jsf?faces-redirect=true";
    }
    
    public String updateCategory(){
        try{
            sbl.updateCategory(category_id, category_name);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "category.jsf?faces-redirect=true";
    }
    
    public void deleteCategory(int category_id){
            sbl.deleteCategory(category_id);
    }
    
    
    
    
    
    //Item
    int item_id;
    String item_name;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    
    public List<Item> findAllItem(){
        return sbl.findAllItem();
    }
    
    public String addItem(){
        try{
            sbl.addItem(item_name, category_id);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "item.jsf?faces-redirect=true";
    }
    
    public String searchItem(int iid){
        Item item = sbl.searchItem(iid);
        item_id = item.getItemId();
        item_name = item.getItemName();
        category_id = item.getCategoryId().getCategoryId();
        
        
        return "update_item.jsf?faces-redirect=true";
    }
    
    public String updateItem(){
        try{
            sbl.updateItem(item_id, item_name, category_id);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "item.jsf?faces-redirect=true";
    }
    
    public void deleteItem(int item_id){
        sbl.deleteItem(item_id);
    }
    
    public ManagedBean() {
    }
    
}
