package com.urjamitra.usermanagement.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urjamitra.usermanagement.service.UserManagementService;
import com.urjamitra.usermanagement.view.dto.UserManagementViewDTO;

@Controller
@RequestMapping("/userManagement")
public class UserManagementController {

	private static final Logger logger = Logger
			.getLogger(UserManagementController.class);

	@Autowired
	UserManagementService userManagementService;

	@RequestMapping("/add")
	public @ResponseBody UserManagementViewDTO addUser(
			@RequestBody UserManagementViewDTO userManagementViewDTO) {
		return null;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody UserManagementViewDTO deleteUser(
			@RequestBody UserManagementViewDTO userManagementViewDTO) {
		return null;
	}
	
	@RequestMapping("/edit")
	public @ResponseBody UserManagementViewDTO editUser(
			@RequestBody UserManagementViewDTO userManagementViewDTO) {
		return null;
	}
	
	@RequestMapping("/search")
	public @ResponseBody UserManagementViewDTO searchUser(
			@RequestBody UserManagementViewDTO userManagementViewDTO) {
		return null;
	}
	
	
	
}
