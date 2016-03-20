package com.dskonsultants.controller;
 
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dskonsultants.model.User;
import com.dskonsultants.service.UserService;
import com.dskonsultants.view.dto.UserViewDto;
import com.dskonsultants.common.exception.BusinessException;
import com.dskonsultants.common.logging.AppLogger;
 
@Controller
public class UserController {
	
	String message = "";
	
	@Autowired
	protected UserService userService;

	@RequestMapping("/init")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "Pay") String name) throws Exception {
		AppLogger.info ("BaseController.class","CONTROLLER BLOCK - initialize");
		
		if(name.equals("error")){
			 throw new IOException();
		}
		ModelAndView mv = new ModelAndView("addUser");
		UserViewDto userBean = new UserViewDto();
        mv.addObject("userBean", userBean);

		return mv;
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("userBean")UserViewDto userBean) throws Exception
	{
		AppLogger.info ("BaseController.class","CONTROLLER BLOCK - add user");
		
		try
		{
				  User person = new User();
			      person.setName(userBean.getUsername()); 
			      person.setCountry(userBean.getAge());
				  userService.saveUserDetails(person);
		}
		catch(Exception e)
		{
			throw new SQLException();
		}
		ModelAndView mv = new ModelAndView("landingPage");
		mv.addObject("message", message);
		mv.addObject("name", "User has been added successfully");
		return mv;
	}
}