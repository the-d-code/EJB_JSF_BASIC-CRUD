/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hi
 */
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "userData", eager = true)
@SessionScoped

public class UserData implements Serializable {
    
       private static final long serialVersionUID = 1L;
   private static Map<String,String> countryMap;
   private String selectedCountry = "United Kingdom"; //default value 

   static {
      countryMap = new LinkedHashMap<String,String>();
      countryMap.put("en", "United Kingdom"); //locale, country name
      countryMap.put("fr", "French");
      countryMap.put("de", "German");	
   }

   public void localeChanged(ValueChangeEvent e) {
      //assign new value to country
      selectedCountry = e.getNewValue().toString(); 
   }

   public Map<String, String> getCountries() {
      return countryMap;
   }

   public String getSelectedCountry() {
      return selectedCountry;
   }

   public void setSelectedCountry(String selectedCountry) {
      this.selectedCountry = selectedCountry;
   }

    
}
