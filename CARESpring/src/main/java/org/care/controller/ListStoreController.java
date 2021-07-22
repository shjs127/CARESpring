package org.care.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.care.domain.Criteria;
import org.care.domain.DetailInfo;
import org.care.domain.Favorite;
import org.care.domain.MenuInfo;
import org.care.domain.PageMaker;
import org.care.domain.ReviewInfo;
import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
import org.care.dto.ReviewDTO;
import org.care.service.DeleteFoodService;
import org.care.service.FoodService;
import org.care.service.ListStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/store")
public class ListStoreController {
	
	public static final Logger Logger = LoggerFactory.getLogger(ListStoreController.class);
	
	@Inject 
	private ListStoreService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardPage(HttpServletRequest request, Model model) throws Exception {
		
		model.addAttribute("list", service.listAll());
		
		return "board/cafeGrid";
	}
	
	@RequestMapping(value = "/storeList", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception { 
		Logger.info(cri.toString());
		
		model.addAttribute("list",service.listCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount((service.countPaging(cri)));
		
		model.addAttribute("pageMaker", pageMaker);
	
		return "board/cafeGrid";
	}
	
	@RequestMapping(value = "/storeList", method = RequestMethod.POST)
	public String SearchListPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		
		model.addAttribute("list", service.listSearch(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		
		pageMaker.setTotalCount(service.listSearchCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/cafeGrid";
	}
	@Inject
	public FoodService foodService;
	@Inject
	private DeleteFoodService deleteFoodService;
	
	@RequestMapping(value = "/storeList/detail", method = RequestMethod.GET)
	public String StoreDetailPage(@RequestParam("storeNo") int storeNo, StoreInfo sInfo, DetailInfo dInfo, ReviewInfo rInfo, MenuInfo mInfo,@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		  StoreInfo storeInfo = foodService.selectStore(sInfo); service.read(storeNo);
		  model.addAttribute("storeInfo", storeInfo);
		  
		 DetailInfo detailInfo = foodService.selectDetail(dInfo);
		  model.addAttribute("detailInfo", detailInfo);
		  
		  List<ReviewInfo> reviewInfo = foodService.selectReview(rInfo);
		  model.addAttribute("reviewInfo", reviewInfo);
		  
		  List<MenuInfo> menuInfo = foodService.selectMenu(mInfo);
		  model.addAttribute("menuInfo", menuInfo);
		

			
		model.addAttribute("storeInfo", storeInfo);
		
		return "detail/food-details";
	}
	 
	
	@RequestMapping(value = "/storeList/detail", method = {RequestMethod.POST})
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
	
		
		//menuInfo부분
		List<MenuInfo> menuInfo = foodService.selectMenu(mInfo);
		model.addAttribute("menuInfo", menuInfo);
		
	
		
		return "detail/food-details";
	}
	
	@RequestMapping(value = "/storeList/deleteReview", method = RequestMethod.GET)
	public String delete(ReviewDTO dto, HttpServletRequest req, HttpServletResponse response, HttpSession session, Model model) throws Exception { 
		
		  String param = req.getParameter("seq");
		  deleteFoodService.deleteReview(param);
		
		return "detail/food-details";
				
	}

	
	@RequestMapping(value = "/storeList/writeReview", method = RequestMethod.POST)
	public String deleter(StoreInfo sInfo, ReviewInfo rInfo,ReviewDTO dto, ReviewInfo rin,HttpSession session, Model model) throws Exception { 
		System.out.println("session :: " + session.getAttributeNames());
		//storeInfo부분
		StoreInfo storeInfo = foodService.selectStore(sInfo);
		model.addAttribute("storeInfo", storeInfo);
		
		
		//reviewInfo부분
		List<ReviewInfo> reviewInfo = foodService.selectReview(rInfo);
		foodService.insertReview(rInfo);
		model.addAttribute("reviewInfo", reviewInfo);
	
		/* System.out.println("dto :: " + dto); */
		return "detail/food-details";
				
	}
//	@RequestMapping(value = "/storeList/orderby", method = )	
	
	@RequestMapping(value = "/storeList/detailInfoChk", method = RequestMethod.POST)
	@ResponseBody
	public void detailInfoChk(@RequestParam(value = "valueArrTest[]") List<String> valueArr) {

	}


}
