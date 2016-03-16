package com.urjamitra.status.dto;

import com.dskonsultants.common.base.dto.BaseDTO;

public class StatusDTO extends BaseDTO {
	
	private long statusId;
	private String statusName;

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
