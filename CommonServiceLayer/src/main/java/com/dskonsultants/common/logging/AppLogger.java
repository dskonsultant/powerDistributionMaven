package com.dskonsultants.common.logging;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * This class is used to write the log of activities performed
 * 
 * @author 356785
 */
public class AppLogger implements LoggerConstants {

	private static AppLogger s_Objlogger = null;
	private static HashMap<Object, Logger> loggers;

	private AppLogger() {
	}

	/**
	 * This method is used to get a logger of given category
	 * 
	 * @param category
	 *            Specifies the category of the logger
	 * @return Logger object present for given key else returns null
	 */
	private static Logger getLogger(String p_Strcategory) {
		Logger logger = null;
		if (loggers != null && loggers.containsKey(p_Strcategory)) {
			logger = loggers.get(p_Strcategory);
		} else {
			logger = Logger.getLogger(p_Strcategory);
		}
		return logger;
	}

	/**
	 * @return existing instance of AppLogger
	 */
	public static AppLogger getInstance() {
		return s_Objlogger;
	}

	/**
	 * This method is used to create a log message from a user for a given
	 * category.
	 * 
	 * @param theCategory
	 *            Specifies the category
	 * @param theMessage
	 *            Specifies the the info message to be created
	 */
	public static void log(String p_StrtheCategory, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.info(p_StrtheCategory + ":" + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to create a info message from a user for a given
	 * category.
	 * 
	 * @param theCategory
	 *            Specifies the category
	 * @param theMessage
	 *            Specifies the the info message to be created
	 */
	public static void info(String p_StrtheCategory, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.info(p_StrtheCategory + ":" + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to create a info message from a user for a given
	 * category.
	 * 
	 * @param p_StrtheCategory
	 *            : specifies category of logger
	 * @param p_StrtheClass
	 *            : class name from which logger is called ,It get appended to
	 *            log message
	 * @param p_StrtheMethod
	 *            : method name from which logger is called, It get appended to
	 *            log message
	 * @param p_StrtheMessage
	 *            : Message to be logged
	 */
	public static void info(String p_StrtheCategory, String p_StrtheClass,
			String p_StrtheMethod, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.info(p_StrtheCategory + ":" + p_StrtheClass + ":"
					+ p_StrtheMethod + ", Message: " + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Create a debug message from a user for a given category.
	 * 
	 * @param theCategory
	 *            Specifies the category
	 * @param theMessage
	 *            Specifies the the debug message
	 */
	public static void debug(String p_StrtheCategory, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.debug(p_StrtheCategory + ":" + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to create a debug message from a user for a given
	 * category.
	 * 
	 * @param p_StrtheCategory
	 *            : specifies category of logger
	 * @param p_StrtheClass
	 *            : class name from which logger is called ,It get appended to
	 *            log message
	 * @param p_StrtheMethod
	 *            : method name from which logger is called, It get appended to
	 *            log message
	 * @param p_StrtheMessage
	 *            : Message to be logged
	 */
	public static void debug(String p_StrtheCategory, String p_StrtheClass,
			String p_StrtheMethod, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.debug(p_StrtheCategory + ":" + p_StrtheClass + ":"
					+ p_StrtheMethod + ", Message: " + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Create a warn message from a user for a given category.
	 * 
	 * @param theCategory
	 *            Specifies the category
	 * @param theMessage
	 *            Specifies the the debug message
	 * 
	 */
	public static void warn(String p_StrtheCategory, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.warn(p_StrtheCategory + ":" + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to create a worn message from a user for a given
	 * category.
	 * 
	 * @param p_StrtheCategory
	 *            : specifies category of logger
	 * @param p_StrtheClass
	 *            : class name from which logger is called ,It get appended to
	 *            log message
	 * @param p_StrtheMethod
	 *            : method name from which logger is called, It get appended to
	 *            log message
	 * @param p_StrtheMessage
	 *            : Message to be logged
	 */
	public static void warn(String p_StrtheCategory, String p_StrtheClass,
			String p_StrtheMethod, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.warn(p_StrtheCategory + ":" + p_StrtheClass + ":"
					+ p_StrtheMethod + ", Message: " + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Create a error message from a user for a category.
	 * 
	 * @param theCategory
	 *            Specifies the category
	 * @param theMessage
	 *            Specifies the the error message
	 */
	public static void error(String p_StrtheCategory, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.error(p_StrtheCategory + ":" + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to create a error message from a user for a given
	 * category.
	 * 
	 * @param p_StrtheCategory
	 *            : specifies category of logger
	 * @param p_StrtheClass
	 *            : class name from which logger is called ,It get appended to
	 *            log message
	 * @param p_StrtheMethod
	 *            : method name from which logger is called, It get appended to
	 *            log message
	 * @param p_StrtheMessage
	 *            : Message to be logged
	 */
	public static void error(String p_StrtheCategory, String p_StrtheClass,
			String p_StrtheMethod, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.error(p_StrtheCategory + ":" + p_StrtheClass + ":"
					+ p_StrtheMethod + ", Message: " + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Create a fatal message from a user for a caterory.
	 * 
	 * @param theCategory
	 *            Specifies the category
	 * @param theMessage
	 *            Specifies the the fatal message
	 */
	public static void fatal(String p_StrtheCategory, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.fatal(p_StrtheCategory + ":" + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to create a fatal message from a user for a given
	 * category.
	 * 
	 * @param p_StrtheCategory
	 *            : specifies category of logger
	 * @param p_StrtheClass
	 *            : class name from which logger is called ,It get appended to
	 *            log message
	 * @param p_StrtheMethod
	 *            : method name from which logger is called, It get appended to
	 *            log message
	 * @param p_StrtheMessage
	 *            : Message to be logged
	 */
	public static void fatal(String p_StrtheCategory, String p_StrtheClass,
			String p_StrtheMethod, String p_StrtheMessage) {
		try {
			Logger logger = AppLogger.getLogger(p_StrtheCategory);
			logger.fatal(p_StrtheCategory + ":" + p_StrtheClass + ":"
					+ p_StrtheMethod + ", Message: " + p_StrtheMessage);
		} catch (NoClassDefFoundError ex) {
			ex.printStackTrace();
		}
	}
}