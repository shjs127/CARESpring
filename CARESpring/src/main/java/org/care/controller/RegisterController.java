package org.care.controller;


import javax.inject.Inject;

import org.care.dto.LoginDTO;
import org.care.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// ���̵� �ߺ� üũ
	@ResponseBody
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	public int idChk(LoginDTO dto) throws Exception {
		int result = registerService.idChk(dto);
		logger.info("result=" + result);
		return result;
	}
	

	// ȸ������ ó��
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(LoginDTO dto) throws Exception {
		logger.info("post register");
		logger.info("userId=" + dto.getUserId());
		logger.info("userName=" + dto.getUserName());

		/*
		 * registerService.register(dto);
		 */		
		int result = registerService.idChk(dto);
		try {
			if(result == 1) {
				return "/login/register";
			}else if(result == 0) {
				registerService.register(dto);
			}
			// ��⿡��~ �Էµ� ���̵� �����Ѵٸ� -> �ٽ� ȸ������ �������� ���ư��� 
			// �������� �ʴ´ٸ� -> register
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return "login/success";
	}
	
	
	/*
	 * 
	 * // ȸ������ post
	 * 
	 * @RequestMapping(value = "/register", method = RequestMethod.POST)
	 * 
	 * public String postRegister(LoginDTO dto) throws Exception {
	 * 
	 * logger.info("post register");
	 * 
	 * int result = registerService.idChk(dto);
	 * 
	 * try {
	 * 
	 * if(result == 1) {
	 * 
	 * return "/login/register";
	 * 
	 * }else if(result == 0) {
	 * 
	 * registerService.register(dto);
	 * 
	 * }
	 * 
	 * // ��⿡��~ �Էµ� ���̵� �����Ѵٸ� -> �ٽ� ȸ������ �������� ���ư���
	 * 
	 * // �������� �ʴ´ٸ� -> register
	 * 
	 * } catch (Exception e) {
	 * 
	 * throw new RuntimeException();
	 * 
	 * }
	 * 
	 * return "login/success";
	 * 
	 * }
	 */

}
