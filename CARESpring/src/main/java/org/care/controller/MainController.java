package org.care.controller;

import java.util.List;

import javax.inject.Inject;

import org.care.domain.BoardPicInfo;
import org.care.dto.BoardDTO;
import org.care.dto.StoreDTO;
import org.care.service.ListArticleService;
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
	@Inject
	private ListArticleService articleService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mainPage(BoardDTO bdto,StoreDTO dto, Model model) throws Exception {

		
		List<StoreDTO> storeTop=listStoreService.listTop(dto);
		model.addAttribute("sTop", storeTop);
		
		List<StoreDTO> reviewStore=listStoreService.reviewTop(dto);
		model.addAttribute("reviewTop", reviewStore);
		
		List<BoardDTO> boardTop=articleService.boardTop(bdto);
		 model.addAttribute("boardTop", boardTop);
		List<BoardPicInfo> boardPic=articleService.getBoardPic(boardTop);
		 model.addAttribute("boardPic", boardPic);
		 System.out.println("boardPic="+boardPic);
		return "main/index";
	}


}
