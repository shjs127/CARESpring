package org.care.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.care.service.UserService;
import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;

@Controller
@RequestMapping("/")
public class UserController {

	
	 @Inject private UserService service;
	 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {
		
		return "login/login";
	}
	
	@RequestMapping(value = "/login/joinSuccess", method = RequestMethod.POST)
	  public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {

	    UserInfo uInfo = service.login(dto);

	    if (uInfo == null) {
	      return;
	    }

	    model.addAttribute("userInfo", uInfo);

		/*
		 * if (dto.isUseCookie()) {
		 * 
		 * int amount = 60 * 60 * 24 * 7;
		 * 
		 * Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
		 * 
		 * service.keepLogin(vo.getUid(), session.getId(), sessionLimit); }
		 */

	  }
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mainPage(HttpServletRequest request, Model model) {

		return "main/index";
	}


	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String boardPage(HttpServletRequest request, Model model) {

		return "board/listArticle";
	}

	@RequestMapping(value = "/storeDetail", method = RequestMethod.GET)
	public String detailPage(HttpServletRequest request, Model model) {

		return "main/food-details";
	}

	// @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	// public void loginPOST(LoginDTO dto, HttpSession session, Model model)
	// throws Exception {
	//
	// UserVO vo = service.login(dto);
	//
	// if (vo == null) {
	// return;
	// }
	//
	// model.addAttribute("userVO", vo);
	//
	// }

	/*
	 * @RequestMapping(value = "/loginPost", method = RequestMethod.POST) public
	 * void loginPOST(LoginDTO dto, HttpSession session, Model model) throws
	 * Exception {
	 * 
	 * UserVO vo = service.login(dto);
	 * 
	 * if (vo == null) { return; }
	 * 
	 * model.addAttribute("userVO", vo);
	 * 
	 * if (dto.isUseCookie()) {
	 * 
	 * int amount = 60 * 60 * 24 * 7;
	 * 
	 * Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
	 * 
	 * service.keepLogin(vo.getUid(), session.getId(), sessionLimit); }
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/logout", method = RequestMethod.GET) public String
	 * logout(HttpServletRequest request, HttpServletResponse response, HttpSession
	 * session) throws Exception {
	 * 
	 * Object obj = session.getAttribute("login");
	 * 
	 * if (obj != null) { UserVO vo = (UserVO) obj;
	 * 
	 * session.removeAttribute("login"); session.invalidate();
	 * 
	 * Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
	 * 
	 * if (loginCookie != null) { loginCookie.setPath("/");
	 * loginCookie.setMaxAge(0); response.addCookie(loginCookie);
	 * service.keepLogin(vo.getUid(), session.getId(), new Date()); } }
	 * 
	 * return "user/logout"; }
	 */
}
