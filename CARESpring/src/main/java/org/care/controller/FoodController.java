
package org.care.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;
import org.care.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

	@Inject
	public FoodService foodService;


	@RequestMapping(value = "/login/storeinSuccess", method = RequestMethod.POST)
	public void storeinPOST(StoreDTO dto, HttpSession session, Model model) throws Exception {

		StoreInfo sInfo = foodService.login(dto);

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
