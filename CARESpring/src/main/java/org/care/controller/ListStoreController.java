package org.care.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

//import org.care.domain.Criteria;
//import org.care.domain.PageMaker;
import org.care.service.ListStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
//	@RequestMapping(value = "/storeList", method = RequestMethod.GET)
//	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception { 
//		Logger.info(cri.toString());
//		
//		model.addAttribute("list",service.listCriteria(cri));
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		
//		pageMaker.setTotalCount((service.countPaging(cri)));
//		
//		model.addAttribute("pageMaker", pageMaker);
//	
//	}
	
	 
//	 @RequestMapping(value = "/storeList", method = RequestMethod.GET) 
//	 public void listAll(Model model) throws Exception {
//	 
//	 Logger.info("show all list..."); 
//	 model.addAttribute("list", service.listAll()); 
//	 }
	 

}
