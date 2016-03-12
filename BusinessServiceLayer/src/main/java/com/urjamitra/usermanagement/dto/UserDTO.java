package com.urjamitra.usermanagement.dto;

import java.util.List;

import com.dskonsultants.common.base.dto.BaseDTO;
import com.urjamitra.role.dto.RoleDTO;
import com.urjamitra.village.dto.VillageDTO;

public class UserDTO extends BaseDTO {

	String firstName;
	String lastName;
	String emailAddress;
	String contactNumber;
	boolean activeUser;
	boolean lockedUser;
	String lastAccessDateTime;

	List<VillageDTO> villageDTOs;
	RoleDTO roleDTO;

	// make the SMS DTO x
	// Make the email DTO x
	// Make the Email DAO impl - auditEmail
	// Make the SMS DAO and impl - auditSMS
	
	
	
	

}
