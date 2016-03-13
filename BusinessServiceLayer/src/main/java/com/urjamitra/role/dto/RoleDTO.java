package com.urjamitra.role.dto;

import java.util.List;
import java.util.Map;

import com.dskonsultants.common.base.dto.BaseDTO;

public class RoleDTO extends BaseDTO {

	private String userType;
	private Map<String, List<String>> accessRights;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Map<String, List<String>> getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(Map<String, List<String>> accessRights) {
		this.accessRights = accessRights;
	}

}
