/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class SessionBean implements SessionBeanLocal {

    @PersistenceContext(unitName = "JSF_EJB_CRUDPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Category> findAllCategory() {
        List<Category> allCategory = em.createNamedQuery("Category.findAll").getResultList();
        return allCategory;
    }

    @Override
    public String addCategory(String category_name) {
        Category category = new Category();
        category.setCategoryName(category_name);
        em.persist(category);
        return "Inserted";
    }

    @Override
    public Category searchCategory(int category_id) {
        Category category = em.find(Category.class, category_id);
        return category;
    }

    @Override
    public String updateCategory(int category_id, String category_name) {
        Category category = em.find(Category.class, category_id);
        category.setCategoryName(category_name);
        em.merge(category);
        return "Updated";
    }

    @Override
    public String deleteCategory(int category_id) {
        Category category = em.find(Category.class, category_id);
        em.remove(category);
        return "Deleted";
    }

    @Override
    public List<Item> findAllItem() {
        List<Item> allItem = em.createNamedQuery("Item.findAll").getResultList();
        return allItem;
    }

    @Override
    public String addItem(String item_name, int category_id) {
        Item item = new Item();
        item.setItemName(item_name);
        Category category = em.find(Category.class, category_id);
        item.setCategoryId(category);
        em.persist(item);
        return "Inserted";
        
    }

    @Override
    public Item searchItem(int item_id) {
        Item item = em.find(Item.class, item_id);
        return item;
    }

    @Override
    public String updateItem(int item_id, String item_name, int category_id) {
        Item item = em.find(Item.class, item_id);
        item.setItemName(item_name);
        Category category = em.find(Category.class, category_id);
        item.setCategoryId(category);
        em.merge(item);
        return "Updated";
    }

    @Override
    public String deleteItem(int item_id) {
        Item item = em.find(Item.class, item_id);
        em.remove(item);
        return "Deleted";
    }

    
}
