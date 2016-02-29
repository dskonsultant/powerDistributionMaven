package com.savekompany.service;
 
import java.util.List;
 
import com.savekompany.model.User;
 
public interface UserService {
 
    public void saveUserDetails(User p);
     
    public List<User> getUserDetails();
     
}