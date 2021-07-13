package org.care.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.care.domain.ReviewInfo;
import org.care.dto.ReviewDTO;
import org.care.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/review")
public class ReviewController {

	
	 @Inject private ReviewService service;
	 
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String reviewPage(HttpServletRequest request, Model model) {
		
		return "review/review";
	}
	
	@RequestMapping(value = "/review/reviewSuccess", method = RequestMethod.POST)
	  public void reviewPOST(ReviewDTO dto, HttpSession session, Model model) throws Exception {

	    ReviewInfo reviewInfo = service.review(dto);

	    if (reviewInfo == null) {
	      return;
	    }

	    model.addAttribute("reviewInfo", reviewInfo);


	  }
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String mainPage(HttpServletRequest request, Model model) {

		return "detail/index";
	}


	
}