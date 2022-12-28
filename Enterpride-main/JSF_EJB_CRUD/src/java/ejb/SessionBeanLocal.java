/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface SessionBeanLocal {
    
    //Category Table Method
    
    public List<Category> findAllCategory();
    public String addCategory(String category_name);
    public Category searchCategory(int category_id);
    public String updateCategory(int category_id,String category_name);
    public String deleteCategory(int category_id);
    
    //Item Table Method
    
    public List<Item> findAllItem();
    public String addItem(String item_name,int category_id);
    public Item searchItem(int item_id);
    public String updateItem(int item_id,String item_name,int category_id);
    public String deleteItem(int item_id);
}
