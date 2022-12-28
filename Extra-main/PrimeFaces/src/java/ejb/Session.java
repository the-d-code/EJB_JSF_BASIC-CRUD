/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class Session implements SessionLocal {

    @PersistenceContext(unitName = "PrimeFacesPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<User> getallUser() {
        List<User> allUser = em.createNamedQuery("User.findAll").getResultList();
        return allUser;
    }

    @Override
    public String addUser(String email, String password, String role) {
        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        u.setRole("User");
        em.persist(u);
        return "Inserted";
        
    }

    @Override
    public User serchUser(int id) {
        User u = em.find(User.class, id);
        return u;
    }

    @Override
    public String updateUser(int id, String email, String password, String role) {
        User u = em.find(User.class, id);
        u.setEmail(email);
        u.setPassword(password);
        u.setRole("User");
        em.merge(u);
        return "Updated";
    }

    @Override
    public String deleteUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return "deleted";
    }

    
}
