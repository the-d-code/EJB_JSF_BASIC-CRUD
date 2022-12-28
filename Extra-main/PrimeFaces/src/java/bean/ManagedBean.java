/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.SessionLocal;
import entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author HP
 */
@Named(value = "managedBean")
@SessionScoped
public class ManagedBean implements Serializable {

    @EJB
    private SessionLocal sb;
    
    int id;
    String code;
    String email;
    String password;
    String role;

    public SessionLocal getSb() {
        return sb;
    }

    public void setSb(SessionLocal sb) {
        this.sb = sb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public List<User> getAllUser(){
        return sb.getallUser();
    }
//    
//    public String addUser(){
//        try{
//            sb.addUser(email, password, role);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        email = "";
//        password = "";
//        role = "";
//        return "display.jsf";
//    }
//    
//    public String searchUser(int uid){
//        User user = sb.serchUser(uid);
//        id = user.getId();
//        email = user.getEmail();
//        password = user.getPassword();
//        return "update.jsf";
//    }
//    
//    public String updateUser(){
//        try{
//            sb.updateUser(id, email, password, role);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        email = "";
//        password = "";
//        role = "User";
//        return "display.jsf";
//    }
//    public void deleteUser(int id){
//        sb.deleteUser(id);
//    }
    // Prime Faces
    private List<User> users;
    
    private User selectedUser;
    
    private List<User> selectedUsers;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<User> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }
    
    public void openNew() {
        this.selectedUser = new User();
    }
    
    public void saveUser(){
        if(this.selectedUser.getCode() == null){
            this.selectedUser.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.users.add(this.selectedUser);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Added"));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Updated"));
        }
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages","form:dt-users");
    }
    
    public void deleteUser(){
        this.users.remove(this.selectedUser);
        this.selectedUsers.remove(this.selectedUser);
        this.selectedUser = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Deleted"));
        PrimeFaces.current().ajax().update("form:messages","form:dt-users");
    }
    
    public String getDeleteButtonMessage(){
        if(hasSelectedUsers()){
            int size = this.selectedUsers.size();
            return size > 1 ? size + "User Selected" : "1 User Selected";
        }
        
        return "Deleted";
    }
    
    public boolean hasSelectedUsers(){
        return this.selectedUsers != null && !this.selectedUsers.isEmpty();
    }
    
    public void deleteSelectedUsers(){
        this.users.removeAll(this.selectedUsers);
        this.selectedUsers = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
        PrimeFaces.current().executeScript("PF('dtUsers').clearFilters()");
    }
    
//    @PostConstruct
//    public void init(){
//        
//    }
    
//    public List<User> getallUsers() {
//        return new ArrayList<>(users);
//    }
//    
//    public List<User> getallUsers(int size){
//        if(size > users.size()){
//            Random rand = new Random();
//            
//            List<User> randomList = new ArrayList<>();
//            for(int i = 0; i < size; i++){
//                int randomIndex = rand.nextInt(users.size());
//                randomList.add(users.get(randomIndex));
//            }
//            return randomList;
//        }
//        else {
//            return new ArrayList<>(users.subList(0, size));
//        }
//    }
//    
//    
//    
//    public List<User> getClonedUsers(int size){
//        
//        List<User> results = new ArrayList<>();
//        List<User> originals = getallUsers(size);
//        for(User original : originals){
//            results.add(original);
//        }
//        
//        for(User user : results){
//            user.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
//        }
//        
//        return results;
//        
//    }
//    
//    
    
    
    
    public ManagedBean() {
    }
    
}
