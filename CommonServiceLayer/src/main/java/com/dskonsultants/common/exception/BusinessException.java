package com.dskonsultants.common.exception;

import java.util.Arrays;

/**
 * Exception class for Business Exception
 * 
 */
public class BusinessException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3570735211003673531L;

	@Override
	public String getLogMessage() {

		return super.getLogMessage();
	}

	@Override
	public String getUserMessage() {

		return super.getUserMessage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusinessException [m_StrCode=" + m_StrCode + ", m_LogMessage="
				+ m_LogMessage + ", m_UserMessage=" + m_UserMessage
				+ ", m_ErrorType=" + m_ErrorType + ", m_ObjThrowable="
				+ m_ObjThrowable + ", getLogMessage()=" + getLogMessage()
				+ ", getUserMessage()=" + getUserMessage()
				+ ", getErrorCode()=" + getErrorCode() + ", toString()="
				+ super.toString() + ", getMessage()=" + getMessage()
				+ ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", fillInStackTrace()="
				+ ", getStackTrace()="
				+ Arrays.toString(getStackTrace()) + ", getSuppressed()="
				+ Arrays.toString(getSuppressed()) + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public String getErrorCode() {

		return super.getErrorCode();
	}

	public BusinessException(Exception e) {
		super(e);
	}

	public BusinessException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute, Throwable p_Objthrowable) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute, p_Objthrowable);

	}

	public BusinessException(String p_StrMsg, String p_StrFileName,
			String p_StrFileAttribute) {
		super(p_StrMsg, p_StrFileName, p_StrFileAttribute);

	}

	public BusinessException(String p_StrMsg, Throwable p_Objthrowable) {
		super(p_StrMsg, p_Objthrowable);

	}

	public BusinessException(String p_StrErrorCode) {
		super(p_StrErrorCode);
	}

	public BusinessException() {
		super();
	}

}
