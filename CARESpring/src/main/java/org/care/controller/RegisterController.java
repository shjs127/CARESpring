package org.care.controller;

import java.lang.reflect.Member;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.care.service.RegisterService;
import org.care.domain.RegisterInfo;
@Controller
 @RequestMapping("/care/*")
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
@Inject
 RegisterService registerService;
	
	
	/*
	 * private final RegisterService registerService;
	 * 
	 * @Inject public RegisterController(RegisterService registerService) {
	 * this.registerService = registerService;
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("get register");
	}
	
	//회원가입 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(RegisterInfo registerInfo) throws Exception {
		logger.info("post register");
		
		registerService.register(registerInfo);
		
		return null;
	}
	

}



