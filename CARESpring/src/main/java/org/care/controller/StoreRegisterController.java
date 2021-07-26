package org.care.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.care.service.StoreRegisterService;
import org.care.dto.StoreDTO;

@Controller
@RequestMapping("/")
public class StoreRegisterController {

	private static final Logger logger = LoggerFactory.getLogger(StoreRegisterController.class);

	@Inject
	StoreRegisterService storeRegisterService;


	@RequestMapping(value = "/StoreRegister", method = RequestMethod.GET)
	public String getStoreRegister() throws Exception {
		logger.info("get storeRegister");

		return "login/StoreRegister";
	}

	// 회원가입 처리
	@RequestMapping(value = "/StoreRegister", method = RequestMethod.POST)
	public String postRegister(StoreDTO dto) throws Exception {
		logger.info("post register");
		logger.info("storeName=" + dto.getStoreName());
		logger.info("address=" + dto.getAddress());

		storeRegisterService.storeRegister(dto);
		return "login/login";
	}

}
