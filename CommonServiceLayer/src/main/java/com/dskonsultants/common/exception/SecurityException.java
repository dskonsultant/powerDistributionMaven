package com.dskonsultants.common.exception;

import java.util.Arrays;


/**
 * Exception class for Security Exception
 * 
 */
public class SecurityException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5204534190537403452L;

	public SecurityException() {
		super();

	}

	public SecurityException(Exception e) {
		super(e);

	}

	public SecurityException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute, Throwable p_Objthrowable) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute, p_Objthrowable);

	}

	public SecurityException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute);

	}

	public SecurityException(String p_StrMsg, Throwable p_Objthrowable) {
		super(p_StrMsg, p_Objthrowable);

	}

	public SecurityException(String p_StrMsg) {
		super(p_StrMsg);

	}

	@Override
	public String getLogMessage() {
		return super.getLogMessage();
	}

	@Override
	public String getUserMessage() {

		return super.getUserMessage();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityException [m_StrCode=" + m_StrCode + ", m_LogMessage="
				+ m_LogMessage + ", m_UserMessage=" + m_UserMessage
				+ ", m_ErrorType=" + m_ErrorType + ", m_ObjThrowable="
				+ m_ObjThrowable + ", getLogMessage()=" + getLogMessage()
				+ ", getUserMessage()=" + getUserMessage()
				+ ", getErrorCode()=" + getErrorCode() + ", toString()="
				+ super.toString() + ", getMessage()=" + getMessage()
				+ ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", fillInStackTrace()="
				+ fillInStackTrace() + ", getStackTrace()="
				+ Arrays.toString(getStackTrace()) + ", getSuppressed()="
				+ Arrays.toString(getSuppressed()) + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public String getErrorCode() {

		return super.getErrorCode();
	}

}
