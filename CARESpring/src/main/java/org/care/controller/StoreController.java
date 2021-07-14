
package org.care.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.care.domain.StoreInfo;
import org.care.dto.StoreDTO;
import org.care.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value = "/storeDetail")
public class StoreController {
	
	@Inject
	public StoreService storeService;
	 
	@RequestMapping(value = "/storeDetail", method = RequestMethod.GET)
	public String StoreInfoList(StoreDTO dto,HttpServletRequest req, Model model) throws Exception {
		
		List<StoreInfo> storeInfo = storeService.selectStore(dto);
		model.addAttribute("storeInfo", storeInfo);
		return "detail/food-details";
	}

}
