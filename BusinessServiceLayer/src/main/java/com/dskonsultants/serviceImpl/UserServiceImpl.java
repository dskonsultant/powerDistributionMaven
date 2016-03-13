package com.dskonsultants.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dskonsultants.common.exception.DatabaseException;
import com.dskonsultants.dao.UserDAO;
import com.dskonsultants.model.User;
import com.dskonsultants.service.UserService;
 
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	protected UserDAO userDao;
	
	@Transactional
	public void saveUserDetails(User person) throws Exception{
		
	      userDao.save(person);
	      System.out.println("Person::"+person);
	}

	public List<User> getUserDetails() {
		return null;
	}
 

     
}