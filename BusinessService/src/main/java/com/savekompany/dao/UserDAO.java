package com.savekompany.dao;
 
import java.util.List;
 
import com.savekompany.model.User;
 
public interface UserDAO {
 
    public void save(User p);
     
    public List<User> list();
     
}