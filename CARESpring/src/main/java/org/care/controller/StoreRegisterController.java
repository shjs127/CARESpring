package org.care.controller;


import javax.inject.Inject;

import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;
import org.care.service.StoreRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

	// ȸ������ ó��
	@RequestMapping(value = "/StoreRegister", method = RequestMethod.POST)
	public String postRegister(StoreDTO dto , DetailDTO ddto) throws Exception {
		logger.info("post register");
		logger.info("storeName=" + dto.getStoreName());
		logger.info("address=" + dto.getAddress());

		storeRegisterService.storeRegister(dto,ddto);
		
		return "login/login";
	}

}
