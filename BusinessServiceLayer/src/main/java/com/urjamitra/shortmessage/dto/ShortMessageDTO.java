package com.urjamitra.shortmessage.dto;

import com.dskonsultants.common.base.dto.BaseDTO;

public class ShortMessageDTO extends BaseDTO {

	private String shortMessageID;
	private String shortMessageType;
	private String shortMessageNumber;
	private String shortMessageText;
	private String shortMessageComments;
	private boolean shortMessageSuccess;

	public String getShortMessageID() {
		return shortMessageID;
	}

	public void setShortMessageID(String shortMessageID) {
		this.shortMessageID = shortMessageID;
	}

	public String getShortMessageType() {
		return shortMessageType;
	}

	public void setShortMessageType(String shortMessageType) {
		this.shortMessageType = shortMessageType;
	}

	public String getShortMessageNumber() {
		return shortMessageNumber;
	}

	public void setShortMessageNumber(String shortMessageNumber) {
		this.shortMessageNumber = shortMessageNumber;
	}

	public String getShortMessageText() {
		return shortMessageText;
	}

	public void setShortMessageText(String shortMessageText) {
		this.shortMessageText = shortMessageText;
	}

	public String getShortMessageComments() {
		return shortMessageComments;
	}

	public void setShortMessageComments(String shortMessageComments) {
		this.shortMessageComments = shortMessageComments;
	}

	public boolean isShortMessageSuccess() {
		return shortMessageSuccess;
	}

	public void setShortMessageSuccess(boolean shortMessageSuccess) {
		this.shortMessageSuccess = shortMessageSuccess;
	}

}
