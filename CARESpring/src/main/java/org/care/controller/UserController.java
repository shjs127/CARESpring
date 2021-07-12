package org.care.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/*import org.care.service.UserService;*/

@Controller
@RequestMapping("/")
public class UserController {

	/*
	 * @Inject private UserService service;
	 */

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage(HttpServletRequest request, Model model){
      // 세션정보에 유저 정보가 있으면 메인페이지로 강제이동
     
	  	return "login/login";
          //return new ModelAndView("login");
      }
  
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public String boardPage(HttpServletRequest request, Model model){
      // 세션정보에 유저 정보가 있으면 메인페이지로 강제이동
     
	  	return "guestbook/listArticle";
          //return new ModelAndView("login");
      }
  @RequestMapping(value = "/storeDetail", method = RequestMethod.GET)
  public String detailPage(HttpServletRequest request, Model model){
      // 세션정보에 유저 정보가 있으면 메인페이지로 강제이동
     
	  	return "main/food-details";
          //return new ModelAndView("login");
      }
  @RequestMapping(value = "/storeList", method = RequestMethod.GET)
  public String listPage(HttpServletRequest request, Model model){
      // 세션정보에 유저 정보가 있으면 메인페이지로 강제이동
     
	  	return "board/cafeGrid";
          //return new ModelAndView("login");
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
