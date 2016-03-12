package com.dskonsultants.common.exception;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.dskonsultants.common.logging.AppLogger;
import com.dskonsultants.common.exception.*;

@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionController {
	private static final Logger logger = Logger.getLogger(GlobalExceptionController.class);
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(SQLException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(BusinessException.class)
	public ModelAndView handleException(BusinessException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(ServiceException.class)
	public ModelAndView handleException(ServiceException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(SecurityException.class)
	public ModelAndView handleException(SecurityException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(GenericException.class)
	public ModelAndView handleException(GenericException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(DatabaseException.class)
	public ModelAndView handleException(DatabaseException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	@ExceptionHandler(ConfigException.class)
	public ModelAndView handleException(ConfigException exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception exception){
		AppLogger.error("GlobalExceptionController",exception.toString());
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
}