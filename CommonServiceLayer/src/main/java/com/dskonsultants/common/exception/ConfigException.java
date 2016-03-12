package com.dskonsultants.common.exception;

import java.util.Arrays;


/**
 * Exception class for configuration Exception
 * 
 */
public class ConfigException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3296523758877169288L;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConfigException [m_StrCode=" + m_StrCode + ", m_LogMessage="
				+ m_LogMessage + ", m_UserMessage=" + m_UserMessage
				+ ", m_ErrorType=" + m_ErrorType + ", m_ObjThrowable="
				+ m_ObjThrowable + ", getLogMessage()=" + getLogMessage()
				+ ", getUserMessage()=" + getUserMessage() + ", toString()="
				+ super.toString() + ", getErrorCode()=" + getErrorCode()
				+ ", getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause()
				+ ", fillInStackTrace()=" + fillInStackTrace()
				+ ", getStackTrace()=" + Arrays.toString(getStackTrace())				
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed())
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public ConfigException() {
		super();

	}

	public ConfigException(Exception e) {
		super(e);

	}

	public ConfigException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute, Throwable p_Objthrowable) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute, p_Objthrowable);

	}

	public ConfigException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute);

	}

	public ConfigException(String p_StrMsg, Throwable p_Objthrowable) {
		super(p_StrMsg, p_Objthrowable);

	}

	public ConfigException(String p_StrMsg) {
		super(p_StrMsg);

	}

}
