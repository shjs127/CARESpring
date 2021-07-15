package org.care.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.care.service.ListArticleService;
import org.care.service.ReadArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/board")
public class ListArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ListArticleController.class);

	@Inject
	private ListArticleService listService;
	
	@Inject
	private ReadArticleService readService;
//	private LoginService loginService;

	@RequestMapping(value = "/listArticle", method = RequestMethod.GET)
	public String listArticleForm(HttpServletRequest req, Model model) throws Exception {

		String searching = req.getParameter("searching");
		if (searching == null) {
			searching = "";
		}
		String pageNoVal = req.getParameter("p");
		String pageView = req.getParameter("pageView");
		int pageNo = 1;
		int pageV = 10;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		if (pageView != null) {
			pageV = Integer.parseInt(pageView);
		}
		model.addAttribute("articlePage", listService.getArticlePage(pageNo, pageV, searching));

		return "board/listArticle";
	}

	@RequestMapping(value = "/listArticle", method = RequestMethod.POST)
	public String listArticleSubmit(HttpServletRequest req, Model model) throws Exception {

		String searching = req.getParameter("searching");
		if (searching == null) {
			searching = "";
		}
		String pageNoVal = req.getParameter("p");
		String pageView = req.getParameter("pageView");
		int pageNo = 1;
		int pageV = 10;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		if (pageView != null) {
			pageV = Integer.parseInt(pageView);
		}
		model.addAttribute("articlePage", listService.getArticlePage(pageNo, pageV, searching));

		return "board/listArticle";
	}

	@RequestMapping(value = "/readArticle", method = RequestMethod.GET)
	public String readArticleSubmit(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		System.out.println(boardNo);
		System.out.println("readService="+readService);

		model.addAttribute("boardInfoList", readService.view(boardNo));
		model.addAttribute("nextBoardNo", readService.nextView(boardNo));
		model.addAttribute("prevBoardNo", readService.prevView(boardNo));
//		req.getSession().setAttribute("articleUser", loginService.selectByUserNo(articleData.getBoardInfo().getUserNo());
		model.addAttribute("boardInfo", readService.getArticle(boardNo));
		return "board/readArticle";
	}
}
