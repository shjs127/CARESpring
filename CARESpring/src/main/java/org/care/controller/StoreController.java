
package org.care.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.care.domain.StoreInfo;
import org.care.domain.UserInfo;
import org.care.dto.LoginDTO;
import org.care.dto.StoreDTO;
import org.care.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
//@RequestMapping(value = "/storeDetail")
public class StoreController {

	@Inject
	public StoreService storeService;

	@RequestMapping(value = "/storeDetail", method = RequestMethod.GET)
	public String StoreInfoList(StoreDTO dto, HttpServletRequest req, Model model) throws Exception {

		List<StoreInfo> storeInfo = storeService.selectStore(dto);
		model.addAttribute("storeInfo", storeInfo);
		return "detail/food-details";
	}

	@RequestMapping(value = "/login/storeinSuccess", method = RequestMethod.POST)
	public void storeinPOST(StoreDTO dto, HttpSession session, Model model) throws Exception {

		StoreInfo sInfo = storeService.login(dto);

		if (sInfo == null) {
			return;
		}

		model.addAttribute("storeVo", sInfo);

	}

	@RequestMapping(value = "/storeLogout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		Object obj = session.getAttribute("storein");

		if (obj != null) {
	
			session.removeAttribute("storein");
			session.invalidate();

		}

		return "login/storeLogout";
	}
}
