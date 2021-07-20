package org.care.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.care.domain.Criteria;
import org.care.domain.PageMaker;
import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
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
	
	@RequestMapping(value = "/storeList/detail", method = RequestMethod.GET)
	public String StoreDetailPage(@RequestParam("storeNo") int storeNo, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		StoreInfo storeInfo = service.read(storeNo);
		
		model.addAttribute("storeInfo", storeInfo);
		
		return "detail/food-details";
	}
	 
//	@RequestMapping(value = "/storeList/orderby", method = )	
	
	@RequestMapping(value = "/storeList/detailInfoChk", method = RequestMethod.POST)
	@ResponseBody
	public void detailInfoChk(@RequestParam(value = "valueArrTest[]") List<String> valueArr) {

	}


}
