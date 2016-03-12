package com.dskonsultants.common.exception;

import java.util.Arrays;


/**
 * Exception class for Database related exception
 * 
 */
public class DatabaseException extends GenericException {

	public DatabaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseException(Exception e) {
		super(e);

	}

	public DatabaseException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute, Throwable p_Objthrowable) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute, p_Objthrowable);

	}

	public DatabaseException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute);

	}

	public DatabaseException(String p_StrMsg, Throwable p_Objthrowable) {
		super(p_StrMsg, p_Objthrowable);

	}

	public DatabaseException(String p_StrMsg) {
		super(p_StrMsg);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DatabaseException [m_StrCode=" + m_StrCode + ", m_LogMessage="
				+ m_LogMessage + ", m_UserMessage=" + m_UserMessage
				+ ", m_ErrorType=" + m_ErrorType + ", m_ObjThrowable="
				+ m_ObjThrowable + ", getLogMessage()=" + getLogMessage()
				+ ", getUserMessage()=" + getUserMessage() + ", toString()="
				+ super.toString() + ", getErrorCode()=" + getErrorCode()
				+ ", getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause()
				+ ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed())
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
