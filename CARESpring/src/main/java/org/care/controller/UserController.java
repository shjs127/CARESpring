package org.care.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.care.domain.Favorite;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;
import org.care.dto.ReviewDTO;
import org.care.service.FoodService;
import org.care.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping("/")
public class UserController {

	@Inject
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {

		return "login/login";
	}

	@RequestMapping(value = "/login/joinSuccess", method = RequestMethod.POST)
	public String loginPOST(LoginDTO dto, HttpSession session, Model model, HttpServletRequest request,
			RedirectAttributes rttr) throws Exception {

		UserInfo uInfo = userService.login(dto);

		if (uInfo == null) {
			model.addAttribute("userInfo", null);
			rttr.addFlashAttribute("loginFalse", false);
			return "redirect:/login";

		} else {

			model.addAttribute("userInfo", uInfo);

			if (dto.isUseCookie()) {

				int amount = 60 * 60 * 24 * 7;

				Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

				userService.keepLogin(uInfo.getUserId(), session.getId(), sessionLimit);
			}

		}
		return "login/joinSuccess";
	}

	@Inject
	public FoodService foodService;

	
	  @RequestMapping(value = "/login/profile", method = RequestMethod.GET) public
	  String profilePage(LoginDTO dto, StoreInfo sInfo, ReviewInfo rInfo, Favorite
	  fr,HttpServletRequest request, HttpSession session, Model model) throws
	  Exception {
	  
		UserInfo userInfo= (UserInfo)session.getAttribute("login"); 
		int userNo=userInfo.getUserNo();
		/*
		 * StoreInfo storeInfo = foodService.selectStore(sInfo);
		 * model.addAttribute("storeInfo", storeInfo);
		 */
	  
	  
	  List<ReviewDTO> reviewInfoList = userService.selectReviewUser(userNo);
	  model.addAttribute("reviewInfoList", reviewInfoList);
	  
	  
	  
		
		  List<Favorite> favorite = foodService.selectFavorite(userNo);
		  model.addAttribute("favorite", favorite);
		 
	  
	  return "profile/profile"; 
	  }
	 

	@RequestMapping(value = "/login/change", method = RequestMethod.POST)
	public String profilePost(LoginDTO uInfo, HttpSession session, HttpServletRequest req, RedirectAttributes rttr)
			throws Exception {

		UserInfo user = (UserInfo) session.getAttribute("login");

		if (!user.getPassword().equals(uInfo.getPassword())) {

			rttr.addFlashAttribute("msg", "fail");
			return "redirect:/login/profile";
		}

		if (uInfo.getNewPassword() == null || uInfo.getNewPassword().isEmpty()) {
			uInfo.setNewPassword(user.getPassword());
		}
		if (uInfo.getNickName() == null || uInfo.getNickName().isEmpty()) {
			uInfo.setNickName(user.getNickName());
		}
		if (uInfo.getBirth() == null || uInfo.getBirth().isEmpty()) {
			uInfo.setBirth(user.getBirth());
		}
		if (uInfo.getEmail() == null || uInfo.getEmail().isEmpty()) {
			uInfo.setEmail(user.getEmail());
		}

		userService.changeInfo(uInfo);
		session.removeAttribute("login");
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String boardPage(HttpServletRequest request, Model model) {

		return "board/listArticle";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		Object obj = session.getAttribute("login");

		if (obj != null) {
			UserInfo vo = (UserInfo) obj;

			session.removeAttribute("login");
			session.invalidate();

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				userService.keepLogin(vo.getUserId(), session.getId(), new Date());
			}
		}

		return "login/logout";
	}

}
