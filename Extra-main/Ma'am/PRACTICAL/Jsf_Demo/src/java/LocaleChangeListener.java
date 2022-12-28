/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hi
 */
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
public class LocaleChangeListener implements ValueChangeListener {
    
       @Override
   public void processValueChange(ValueChangeEvent event)
      throws AbortProcessingException {
      
      //access country bean directly
      UserData userData = (UserData) FacesContext.getCurrentInstance().
      getExternalContext().getSessionMap().get("userData");
      userData.setSelectedCountry(event.getNewValue().toString());
   }

    
}
