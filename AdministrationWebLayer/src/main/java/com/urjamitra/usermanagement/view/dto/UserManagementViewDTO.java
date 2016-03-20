package com.urjamitra.usermanagement.view.dto;

import java.util.List;

import com.urjamitra.usermanagement.dto.UserDTO;

public class UserManagementViewDTO {

	private String name;
	private String userName;
	private String contactNumber;
	private String emailAddress;
	private int errorId;
	private String errorName;
	private String errorDescrption;

	public UserManagementViewDTO convertToViewDTO(UserDTO userDTO) {
		return null;
	}

	public UserDTO convertFromViewDTO(
			UserManagementViewDTO userManagementViewDTO) {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<String> getVillageName() {
		return villageName;
	}

	public void setVillageName(List<String> villageName) {
		this.villageName = villageName;
	}

	public List<Integer> getVillageId() {
		return villageId;
	}

	public void setVillageId(List<Integer> villageId) {
		this.villageId = villageId;
	}

	public List<Integer> getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(List<Integer> wardNumber) {
		this.wardNumber = wardNumber;
	}

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public String getErrorDescrption() {
		return errorDescrption;
	}

	public void setErrorDescrption(String errorDescrption) {
		this.errorDescrption = errorDescrption;
	}

}
