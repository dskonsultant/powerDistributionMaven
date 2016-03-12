package com.urjamitra.usermanagement.service;

import com.urjamitra.usermanagement.dto.UserDTO;

public interface UserManagementService {
	
	
	public UserDTO addUser();
	public UserDTO editUser();
	public UserDTO deleteUser();
	public UserDTO getUserById(String userName);
	public UserDTO getUserByName(String name);
	public UserDTO getUserByVillageId(int villageId);
	public UserDTO assignRole(String role);

}
