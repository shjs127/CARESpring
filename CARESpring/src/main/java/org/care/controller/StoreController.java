package org.care.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.care.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/store")
public class StoreController {

	
	 @Inject private StoreService service;
	 
	
	
	
	

	
}