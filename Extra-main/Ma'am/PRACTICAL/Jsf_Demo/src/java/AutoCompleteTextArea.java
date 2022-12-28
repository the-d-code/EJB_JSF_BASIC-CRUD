/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hi
 */
import java.util.ArrayList;  
import java.util.List;  
import javax.faces.bean.ManagedBean;  
@ManagedBean  
public class AutoCompleteTextArea {
    
    public List<String> sugessions(String str) {  
List<String> results = new ArrayList<>();  
if (str.equals("hello")) {  
results.add("hello is a Tutorial Site.");  
results.add("hello is good to learn Java.");  
results.add("hello provides technical tutorials.");  
results.add("hello is easy to understand.");  
results.add("hello is developed by Sonoo Jaiswal!");  
} else {  
results.add("hello "+str);  
}  
return results;  
    }
    
}
