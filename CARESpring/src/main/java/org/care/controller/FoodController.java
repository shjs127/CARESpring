
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
	

	@RequestMapping(value = "/storeDetail", method = {RequestMethod.GET})
	public String FoodService(StoreInfo sInfo, DetailInfo dInfo, ReviewInfo rInfo, MenuInfo mInfo, HttpServletRequest req, Model model) throws Exception {  //StoreInfo storeInfo, DetailInfo detailInfo, ReviewInfo reviewInfo, MenuInfo menuInfo뺌
  
    
		System.out.println("ReviewInfo.reviewContents="+rInfo.getReviewContents());
		StoreInfo storeInfo = foodService.selectStore(sInfo);
		model.addAttribute("storeInfo", storeInfo);

		DetailInfo detailInfo = foodService.selectDetail(dInfo);
		model.addAttribute("detailInfo", detailInfo);

		List<ReviewInfo> reviewInfo = foodService.selectReview(rInfo);
		//foodService.insertReview(rInfo);
		model.addAttribute("reviewInfo", reviewInfo);

		List<MenuInfo> menuInfo = foodService.selectMenu(mInfo);
		model.addAttribute("menuInfo", menuInfo);

		return "detail/food-details";

	}
	

	@RequestMapping(value = "/storeDetail", method = {RequestMethod.POST})
	public String Insert(StoreInfo sInfo, DetailInfo dInfo, ReviewInfo rInfo, MenuInfo mInfo, HttpServletRequest req, Model model) throws Exception { 
		//StoreInfo storeInfo, DetailInfo detailInfo, ReviewInfo reviewInfo, MenuInfo menuInfo뺌
		
		System.out.println("ReviewInfo.reviewContents="+rInfo.getReviewContents());
		StoreInfo storeInfo = foodService.selectStore(sInfo);
		model.addAttribute("storeInfo", storeInfo);

		DetailInfo detailInfo = foodService.selectDetail(dInfo);
		model.addAttribute("detailInfo", detailInfo);
		
		List<ReviewInfo> reviewInfo = foodService.selectReview(rInfo);
		foodService.insertReview(rInfo);
		model.addAttribute("reviewInfo", reviewInfo);
		
		List<MenuInfo> menuInfo = foodService.selectMenu(mInfo);
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
