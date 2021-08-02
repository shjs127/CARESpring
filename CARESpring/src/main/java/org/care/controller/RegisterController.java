package org.care.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.care.service.RegisterService;
import org.care.dto.LoginDTO;

@Controller
@RequestMapping("/")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Inject
	RegisterService registerService;


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() throws Exception {
		logger.info("get register");

		return "login/register";
	}

	// 회원가입 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(LoginDTO dto) throws Exception {
		logger.info("post register");
		logger.info("userId=" + dto.getUserId());
		logger.info("userName=" + dto.getUserName());

		registerService.register(dto);
		return "login/success";
	}

}
