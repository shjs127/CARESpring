package org.care.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.care.domain.ArticlePage;
import org.care.domain.BoardInfo;
import org.care.dto.BoardDTO;
import org.care.service.ListArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class ListArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ListArticleController.class);

	@Inject
	private ListArticleService listService;

	@RequestMapping(value = "/listArticle", method = RequestMethod.GET)
	public void boardList(BoardDTO dto, HttpServletRequest req, Model model) throws Exception {

//		String search=req.getParameter("searching");
//		String pageNoVal = req.getParameter("p");
//		String pageView = req.getParameter("v");
//		int pageNo = 1;
//		int pageV = 10;
//		if (pageNoVal != null) {
//			pageNo = Integer.parseInt(pageNoVal);
//		}
//		if(pageView != null) {
//			pageV = Integer.parseInt(pageView);
//		}
//		ArticlePage articlePage = listService.getArticlePage(pageNo,pageV,search);
		List<BoardInfo> boardInfo = listService.board(dto);
		model.addAttribute("articlePage", boardInfo);
	}

}
