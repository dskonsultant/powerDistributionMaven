package com.dskonsultants.service;
 
import java.util.List;
 
import com.dskonsultants.model.User;
 
public interface UserService {
 
    public void saveUserDetails(User p);
     
    public List<User> getUserDetails();
     
}