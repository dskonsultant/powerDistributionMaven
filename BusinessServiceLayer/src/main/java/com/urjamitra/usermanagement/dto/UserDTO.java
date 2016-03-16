package com.urjamitra.usermanagement.dto;

import java.sql.Date;
import java.util.List;

import com.dskonsultants.common.base.dto.BaseDTO;
import com.urjamitra.cluster.domain.ClusterDO;
import com.urjamitra.clustermanagement.dto.ClusterDTO;
import com.urjamitra.role.dto.RoleDTO;
import com.urjamitra.village.dto.VillageDTO;

public class UserDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String contactNumber;
	private boolean activeUser;
	private boolean lockedUser;
	private Date lastAccessDateTime;

	private List<ClusterDTO> clusterDTOs;
	private RoleDTO roleDTO;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public boolean isActiveUser() {
		return activeUser;
	}
	public void setActiveUser(boolean activeUser) {
		this.activeUser = activeUser;
	}
	public boolean isLockedUser() {
		return lockedUser;
	}
	public void setLockedUser(boolean lockedUser) {
		this.lockedUser = lockedUser;
	}
	public Date getLastAccessDateTime() {
		return lastAccessDateTime;
	}
	public void setLastAccessDateTime(Date lastAccessDateTime) {
		this.lastAccessDateTime = lastAccessDateTime;
	}
	public List<ClusterDTO> getClusterDTOs() {
		return clusterDTOs;
	}
	public void setClusterDTOs(List<ClusterDTO> clusterDTOs) {
		this.clusterDTOs = clusterDTOs;
	}
	public RoleDTO getRoleDTO() {
		return roleDTO;
	}
	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	
	
	
	

}
