package com.urjamitra.email.service;

import com.dskonsultants.common.exception.GenericException;
import com.urjamitra.email.dto.EmailDTO;

public interface EmailService {

	public boolean sendMail(EmailDTO emailDTO) throws GenericException; 

}
