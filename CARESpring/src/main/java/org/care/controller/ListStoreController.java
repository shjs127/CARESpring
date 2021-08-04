package org.care.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.care.domain.Criteria;
import org.care.domain.PageMaker;
import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
import org.care.service.ListStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/storeList", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		
		if(scri.getOrderBy() == null || "".equals(scri.getOrderBy()) ) {
			scri.setOrderBy("STORENO");
		}
		
		model.addAttribute("list", service.listSearch(scri));
		
		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listSearchCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);

		return "board/cafeGrid";
	}
	 
	@RequestMapping(value = "/storeList/detailChk", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> detailInfoChk(@RequestParam(value = "valueArr", required = false) List<String> valueArr, 
			@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		System.out.println("----------------------------");
		System.out.println(valueArr);
		scri.setValChk(valueArr);
		System.out.println(scri.getValChk());
		int page = 1;
		
		if(scri.getOrderBy() == null || "".equals(scri.getOrderBy()) ) {
			scri.setOrderBy("STORENO");
		}

		ResponseEntity<Map<String, Object>> entity = null;
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<StoreInfo> list = service.listSearchDetail(scri);
			
			map.put("list", list);
			
			int detailCnt = service.listSearchDetailCount(scri);
			pageMaker.setTotalCount(detailCnt);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
