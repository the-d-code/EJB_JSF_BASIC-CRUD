/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hi
 */
public class Product {
    
    private final int id;    
private final String name;    
private final float price;    
public Product(int id, String name, float price) {    
this.id = id;    
this.name = name;    
this.price = price;    
}  
public int getId() {  
return id;  
}  
public String getName() {  
return name;  
}  
public float getPrice() {  
return price;  
}  

    
}
