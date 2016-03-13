package com.urjamitra.usermanagement.dto;

import java.util.List;

import com.dskonsultants.common.base.dto.BaseDTO;
import com.urjamitra.role.dto.RoleDTO;
import com.urjamitra.village.dto.VillageDTO;

public class UserDTO extends BaseDTO {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String contactNumber;
	private boolean activeUser;
	private boolean lockedUser;
	private String lastAccessDateTime;

	private List<VillageDTO> villageDTOs;
	private RoleDTO roleDTO;

	
	
	
	

}
