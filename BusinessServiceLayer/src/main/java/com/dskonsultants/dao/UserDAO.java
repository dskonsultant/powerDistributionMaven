package com.dskonsultants.dao;
 
import java.util.List;

import com.dskonsultants.model.User;
 
public interface UserDAO {
 
    public void save(User p)  throws Exception ;
     
    public List<User> list();
     
}