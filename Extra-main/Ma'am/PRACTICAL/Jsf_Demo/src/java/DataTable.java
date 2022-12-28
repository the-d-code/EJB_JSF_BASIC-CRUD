/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hi
 */
import java.util.List;  
import java.util.ArrayList;  
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;  
  
@ManagedBean(name = "product")  
@RequestScoped  
public class DataTable {
    public List<Product> productsList;  
public List<Product> getProductList() {    
productsList = new ArrayList<>();    
productsList.add(new Product(1,"HP Laptop",25000f));    
productsList.add(new Product(2,"Dell Laptop",30000f));    
productsList.add(new Product(3,"Lenevo Laptop",28000f));    
productsList.add(new Product(4,"Sony Laptop",28000f));    
productsList.add(new Product(5,"Apple Laptop",90000f));    
return productsList;  
}
    
}
