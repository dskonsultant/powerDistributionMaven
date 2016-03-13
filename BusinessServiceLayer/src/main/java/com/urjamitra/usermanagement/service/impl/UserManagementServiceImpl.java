package com.urjamitra.usermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskonsultants.common.exception.GenericException;
import com.urjamitra.usermanagement.dao.UserDAO;
import com.urjamitra.usermanagement.dto.UserDTO;
import com.urjamitra.usermanagement.service.UserManagementService;
import com.urjamitra.village.dto.VillageDTO;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserDTO addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO editUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO deleteUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserById(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserByName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserDTO assignRole(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserByVillageId(VillageDTO villageDTO)
			throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

}
