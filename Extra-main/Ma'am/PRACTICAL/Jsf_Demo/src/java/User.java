/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hi
 */
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped; 

@ManagedBean  


public class User {
   
    String name;  
    String lastName;  
public String getLastName() {  
return lastName;  
}  
public void setLastName(String lastName) {  
this.lastName = lastName;  
}  


    
public String getName() {  
return name;  
}  
public void setName(String name) {  
this.name = name;  
}  
    
}
