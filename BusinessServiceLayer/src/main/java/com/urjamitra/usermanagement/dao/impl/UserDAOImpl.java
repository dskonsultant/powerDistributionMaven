package com.urjamitra.usermanagement.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.dskonsultants.common.exception.DatabaseException;
import com.dskonsultants.common.base.dao.BaseDAOHibernateImpl;
import com.urjamitra.usermanagement.dao.UserDAO;
import com.urjamitra.usermanagement.domain.UserDO;
import com.urjamitra.usermanagement.dto.UserDTO;

public class UserDAOImpl extends BaseDAOHibernateImpl<UserDO,String> implements UserDAO{

	@Override
	public UserDTO createUser(UserDTO userDTO) throws DatabaseException{
		try
		{
			UserDO userDO = new UserDO();
			userDO.setUserPhoneNumber(userDTO.getContactNumber());
			userDO.setUserEmailAddress(userDTO.getEmailAddress());
			userDO.setUserFirstName(userDTO.getFirstName());
			userDO.setUserLastName(userDTO.getLastName());
			userDO.setLastAccessDateTime(userDTO.getLastAccessDateTime());
			
			userDO = saveAndCommit(userDO);
			
			
			
			return userDTO;
		}
		catch(Exception exception)
		{
			throw new DatabaseException(exception);
		}
	}
	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO deleteUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO searchUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> searchUsers(List<UserDTO> userDTOs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> searchAllUsers(List<UserDTO> userDTOs)
			throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> searchByCluster(List<UserDTO> userDTOs)
			throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}


}
