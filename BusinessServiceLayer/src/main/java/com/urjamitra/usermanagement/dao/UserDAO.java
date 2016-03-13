package com.urjamitra.usermanagement.dao;

import java.util.List;

import com.dskonsultants.common.baseDAO.BaseDAO;
import com.urjamitra.usermanagement.dto.UserDTO;

public interface UserDAO extends BaseDAO{
	
	public UserDTO createUser(UserDTO userDTO); // throws Database Exception , Validation Exception
	public UserDTO updateUser(UserDTO userDTO); 
	public UserDTO deleteUser(UserDTO userDTO);
	public UserDTO searchUser(UserDTO userDTO);
	public List<UserDTO> searchUsers(List<UserDTO> userDTOs);

}
