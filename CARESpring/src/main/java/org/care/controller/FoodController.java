
package org.care.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.care.domain.DetailInfo;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.dto.DetailDTO;
import org.care.dto.MenuDTO;
import org.care.dto.ReviewDTO;
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

	@RequestMapping(value = "/storeDetail", method = RequestMethod.GET)
	public String StoreInfoList(StoreDTO dto, DetailDTO dto1, ReviewDTO dto2, MenuDTO dto3, HttpServletRequest req, Model model) throws Exception {

		List<StoreInfo> storeInfo = foodService.selectStore(dto);
		model.addAttribute("storeInfo", storeInfo);
		
		
		
		
		
		List<DetailInfo> detailInfo = foodService.selectDetail(dto1);
		model.addAttribute("detailInfo", detailInfo);
		
		
		
		List<ReviewInfo> reviewInfo = foodService.selectReview(dto2);
		model.addAttribute("reviewInfo", reviewInfo);
		
		
		
		List<MenuInfo> menuInfo = foodService.selectMenu(dto3);
		model.addAttribute("menuInfo", menuInfo);
		
		return "detail/food-details";

		  }
		
		
		

	 
	

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
