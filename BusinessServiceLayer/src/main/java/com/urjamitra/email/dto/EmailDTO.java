package com.urjamitra.email.dto;

import com.dskonsultants.common.base.dto.BaseDTO;

public class EmailDTO extends BaseDTO {

	private String emailID;
	private String emailSendAddress;
	private String emailMessage;
	private boolean emailSuccess;

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getEmailSendAddress() {
		return emailSendAddress;
	}

	public void setEmailSendAddress(String emailSendAddress) {
		this.emailSendAddress = emailSendAddress;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public boolean isEmailSuccess() {
		return emailSuccess;
	}

	public void setEmailSuccess(boolean emailSuccess) {
		this.emailSuccess = emailSuccess;
	}

}
