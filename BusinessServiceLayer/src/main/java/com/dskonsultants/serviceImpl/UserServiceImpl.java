package com.dskonsultants.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dskonsultants.dao.UserDAO;
import com.dskonsultants.model.User;
import com.dskonsultants.service.UserService;
 
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