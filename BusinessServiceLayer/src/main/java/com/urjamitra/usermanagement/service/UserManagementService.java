package com.urjamitra.usermanagement.service;

import com.dskonsultants.common.exception.GenericException;
import com.urjamitra.clustermanagement.dto.ClusterDTO;
import com.urjamitra.usermanagement.dto.UserDTO;
import com.urjamitra.village.dto.VillageDTO;

public interface UserManagementService {

	public UserDTO addUser(UserDTO userDTO) throws GenericException;

	public UserDTO editUser(UserDTO userDTO) throws GenericException;

	public UserDTO deleteUser(UserDTO userDTO) throws GenericException;

	public UserDTO getUserById(UserDTO userDTO) throws GenericException;

	public UserDTO getUserByName(UserDTO userDTO) throws GenericException;

	public UserDTO getUserByCluster(UserDTO userDTO) throws GenericException; 

	public UserDTO assignRole(UserDTO userDTO) throws GenericException;

}
