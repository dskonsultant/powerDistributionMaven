package com.savekompany.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.savekompany.dao.UserDAO;
import com.savekompany.model.User;
import com.savekompany.service.UserService;
 
@Component	
public class UserServiceImpl implements UserService{
	
	@Autowired
	protected UserDAO userDao;

	public void saveUserDetails(User person) {
		
	      userDao.save(person);
	      System.out.println("Person::"+person);
	}

	public List<User> getUserDetails() {
		return null;
	}
 

     
}