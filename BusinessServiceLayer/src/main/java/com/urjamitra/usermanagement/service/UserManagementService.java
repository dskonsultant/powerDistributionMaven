package com.urjamitra.usermanagement.service;

import com.urjamitra.usermanagement.dto.UserDTO;

public interface UserManagementService {

	public UserDTO addUser(UserDTO userDTO) throws Exception; /*
															 * TODO : It should
															 * throw an generic
															 * exception
															 */

	public UserDTO editUser(UserDTO userDTO);

	public UserDTO deleteUser(UserDTO userDTO);

	public UserDTO getUserById(UserDTO userDTO);

	public UserDTO getUserByName(UserDTO userDTO);

	public UserDTO getUserByVillageId(int villageId); // Village DTO.

	public UserDTO assignRole(UserDTO userDTO);

}
