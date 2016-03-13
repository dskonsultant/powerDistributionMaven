package com.dskonsultants.common.exception;

/**
 * Holds exception code, log message , user message and type of exception
 */
public class ExceptionDefinition {
	private String exceptionCode = "";
	private String exceptionLogMessage = "";
	private String exceptionUserMessage = "";
	private String exceptionType = "";

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionLogMessage() {
		return exceptionLogMessage;
	}

	public void setExceptionLogMessage(String exceptionLogMessage) {
		this.exceptionLogMessage = exceptionLogMessage;
	}

	public String getExceptionUserMessage() {
		return exceptionUserMessage;
	}

	public void setExceptionUserMessage(String exceptionUserMessage) {
		this.exceptionUserMessage = exceptionUserMessage;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[exceptionCode=").append(exceptionCode)
				.append("]");
		stringBuilder.append("[exceptionLogMessage=")
				.append(exceptionLogMessage).append("]");
		stringBuilder.append("[exceptionUserMessage=")
				.append(exceptionUserMessage).append("]");
		stringBuilder.append("[exceptionType=").append(exceptionType)
				.append("]");
		return stringBuilder.toString();
	}

}
