package org.care.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.care.dto.StoreDTO;
import org.care.service.ListStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

	@Inject
	private ListStoreService listStoreService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mainPage(StoreDTO dto,HttpServletRequest request, Model model) {

		
		List<StoreDTO> listStore=listStoreService.listTop(dto);
		model.addAttribute("sTop", listStore);
		
		return "main/index";
	}


}
