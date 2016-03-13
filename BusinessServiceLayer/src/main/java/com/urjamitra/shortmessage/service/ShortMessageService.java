package com.urjamitra.shortmessage.service;

import com.dskonsultants.common.exception.GenericException;
import com.urjamitra.shortmessage.dto.ShortMessageDTO;

public interface ShortMessageService {
	
	
	public boolean sendSMS(ShortMessageDTO shortMessageDTO) throws GenericException; 

}
