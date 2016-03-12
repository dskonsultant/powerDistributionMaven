package com.dskonsultants.common.exception;

import java.util.HashMap;
import java.util.Map;

import com.dskonsultants.common.logging.AppLogger;

/**
 * Superclass of All exceptions. GenericExceptions to be used for exceptions for
 * all conditions not supported by other exceptions
 * 
 */
public class GenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4418252461431627054L;
	protected String m_StrCode = "";
	protected String m_LogMessage = "";
	protected String m_UserMessage = "";	
	protected String m_ErrorType = "";
	protected Throwable m_ObjThrowable = null;
	protected static Map<Integer, ExceptionDefinition> s_MapExceptionMessages = new HashMap<Integer, ExceptionDefinition>();

	static {
		AppLogger.debug("SERVICES", "GenericException",
				"static initialization", " Initilization started");
		
		/*s_MapExceptionMessages = ExceptionConfigReader.INSTANCE
				.parseExceptionFile();
		
		AppLogger.debug("P2PSERVICES", "GenericException",
				"static initialization", " Map created is with size "
						+ s_MapExceptionMessages);*/
	}

	public GenericException() {
		super();
	}

	public GenericException(Exception e) {
		super(e);
	}

	public GenericException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute) {
		super(p_StrMsg + "File Name : " + p_StrFileName + "Attribute Name :"
				+ p_StrFileAttribute);
	}

	public GenericException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute, Throwable p_Objthrowable) {
		super(p_StrMsg + "File Name : " + p_StrFileName + "Attribute Name :"
				+ p_StrFileAttribute, p_Objthrowable);
	}

	public GenericException(String p_StrErrorCode) {
		super(p_StrErrorCode);
		this.m_StrCode=p_StrErrorCode;
	}

	public GenericException(String p_StrMsg, Throwable p_Objthrowable) {
		super(p_StrMsg, p_Objthrowable);
	}

	public String getLogMessage() {
		return m_LogMessage;
	}

	public String getUserMessage() {
		return m_UserMessage;
	}

	public String toString() {
		return m_LogMessage;
	}

	public String getErrorCode() {
		return m_StrCode;
	}

}
