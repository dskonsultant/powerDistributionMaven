package com.savekompany.exception;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionController {
	private static final Logger logger = Logger.getLogger(GlobalExceptionController.class);
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException exception){
		logger.error(exception);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(SQLException exception){
		logger.error(exception);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception exception){
		logger.error(exception);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
}