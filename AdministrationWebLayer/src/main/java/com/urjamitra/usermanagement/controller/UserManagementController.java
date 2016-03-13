package com.urjamitra.usermanagement.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.urjamitra.usermanagement.service.UserManagementService;

@Controller
public class UserManagementController {

	private static final Logger logger = Logger
			.getLogger(UserManagementController.class);
	
	@Autowired
	UserManagementService userManagementService;
	
	

}
