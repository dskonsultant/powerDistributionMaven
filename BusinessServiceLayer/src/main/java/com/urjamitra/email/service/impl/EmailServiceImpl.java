package com.urjamitra.email.service.impl;

import org.springframework.stereotype.Service;

import com.urjamitra.email.dto.EmailDTO;
import com.urjamitra.email.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public boolean sendMail(EmailDTO emailDTO) {

		return true;
	}

}
