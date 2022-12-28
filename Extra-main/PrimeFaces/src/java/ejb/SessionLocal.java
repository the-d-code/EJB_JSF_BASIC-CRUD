/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface SessionLocal {
    public List<User> getallUser();
    public String addUser(String email,String password,String role);
    public User serchUser(int id);
    public String updateUser(int id,String email,String password,String role);
    public String deleteUser(int id);
}
