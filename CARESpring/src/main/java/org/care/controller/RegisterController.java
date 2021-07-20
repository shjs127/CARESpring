package org.care.controller;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.care.domain.UserInfo;
import org.care.service.RegisterService;

@Controller
// @RequestMapping("/care")
public class RegisterController {
	
	@Inject
	private RegisterService registerService;
	
	
	/*
	 * private final RegisterService registerService;
	 * 
	 * @Inject public RegisterController(RegisterService registerService) {
	 * this.registerService = registerService;
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET() throws Exception {
		return "/login/register";
	}
	
	//회원가입 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserInfo userInfo, RedirectAttributes redirectAttributes) throws Exception {
		
		String hashedPw = BCrypt.hashpw(userInfo.getPassword(), BCrypt.gensalt());
		userInfo.setPassword(hashedPw);
		//registerService.register(userInfo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");
		
		return "redirect:/login";
	}
	

}



