package com.urjamitra.usermanagement.dao;

import java.util.List;



import com.dskonsultants.common.exception.DatabaseException;
import com.urjamitra.usermanagement.dto.UserDTO;

public interface UserDAO{
	
	public UserDTO createUser(UserDTO userDTO) throws DatabaseException; // throws Database Exception , Validation Exception
	public UserDTO updateUser(UserDTO userDTO) throws DatabaseException; 
	public UserDTO deleteUser(UserDTO userDTO) throws DatabaseException;
	public UserDTO searchUser(UserDTO userDTO) throws DatabaseException;
	public List<UserDTO> searchUsers(List<UserDTO> userDTOs) throws DatabaseException;

}
