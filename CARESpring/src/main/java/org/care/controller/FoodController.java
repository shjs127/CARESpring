
package org.care.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.care.domain.DetailInfo;
import org.care.domain.Favorite;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.StoreInfo;
import org.care.dto.ReviewDTO;
import org.care.dto.StoreDTO;
import org.care.service.DeleteFoodService;
import org.care.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoodController {

	

	@Inject
	public FoodService foodService;
	
	
	
	@RequestMapping(value = "/storeDetail", method = {RequestMethod.GET})
	public String FoodService(StoreInfo sInfo, DetailInfo dInfo, ReviewInfo rInfo, MenuInfo mInfo, HttpServletRequest req, Model model) throws Exception {  //StoreInfo storeInfo, DetailInfo detailInfo, ReviewInfo reviewInfo, MenuInfo menuInfo뺌
  
		
		StoreInfo storeInfo = foodService.selectStore(sInfo);
		model.addAttribute("storeInfo", storeInfo);

		DetailInfo detailInfo = foodService.selectDetail(dInfo);
		model.addAttribute("detailInfo", detailInfo);

		List<ReviewInfo> reviewInfo = foodService.selectReview(rInfo);
		model.addAttribute("reviewInfo", reviewInfo);

		List<MenuInfo> menuInfo = foodService.selectMenu(mInfo);
		model.addAttribute("menuInfo", menuInfo);

		return "detail/food-details";

	}
	
	

	
	@RequestMapping(value = "/storeDetail", method = {RequestMethod.POST})
	public String Insert(ReviewDTO dto, StoreInfo sInfo, DetailInfo dInfo, ReviewInfo rInfo, MenuInfo mInfo, Favorite fr,HttpServletRequest req,HttpSession session, Model model) throws Exception { 
		//StoreInfo storeInfo, DetailInfo detailInfo, ReviewInfo reviewInfo, MenuInfo menuInfo뺌
		
		
		//storeInfo부분
		StoreInfo storeInfo = foodService.selectStore(sInfo);
		model.addAttribute("storeInfo", storeInfo);
		
		//detailInfo부분
		DetailInfo detailInfo = foodService.selectDetail(dInfo);
		model.addAttribute("detailInfo", detailInfo);
		
		//reviewInfo부분
		List<ReviewInfo> reviewInfo = foodService.selectReview(rInfo);
		foodService.insertReview(rInfo);
		model.addAttribute("reviewInfo", reviewInfo);
		
		List<ReviewInfo> reviewInfoList = foodService.selectReviewList(rInfo);
		model.addAttribute("reviewInfoList", reviewInfoList);
		
		
		
		//menuInfo부분
		List<MenuInfo> menuInfo = foodService.selectMenu(mInfo);
		model.addAttribute("menuInfo", menuInfo);
		
		//favorite부분
		List<Favorite> favorite = foodService.selectFavorite(fr);
		model.addAttribute("favorite", favorite);
		
		
		
		return "detail/food-details";
	}
	
	
	@Inject
	private DeleteFoodService deleteFoodService;
	
	@RequestMapping(value = "/deleteReview", method = RequestMethod.GET)
	public String delete(ReviewDTO dto, StoreInfo sInfo, DetailInfo dInfo, ReviewInfo rInfo, MenuInfo mInfo,HttpServletRequest req, HttpServletResponse response,HttpSession session, Model model) throws Exception { 
		String param = req.getParameter("seq");
		deleteFoodService.deleteReview(param);
		
		
		return "detail/food-details";
				
	}

	
	@RequestMapping(value = "/deleteReview", method = RequestMethod.POST)
	public String deleter(ReviewDTO dto, ReviewInfo rin,HttpServletRequest req,HttpSession session, Model model) throws Exception { 
		
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
