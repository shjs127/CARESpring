package org.care.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.care.domain.BoardPicInfo;
import org.care.domain.CommentInfo;
import org.care.domain.UserInfo;
import org.care.dto.BoardDTO;
import org.care.dto.CommentDTO;
import org.care.service.CommentService;
import org.care.service.DeleteArticleService;
import org.care.service.ListArticleService;
import org.care.service.ModifyArticleService;
import org.care.service.ReadArticleService;
import org.care.service.WriteArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/board")
public class ListArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ListArticleController.class);

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private ListArticleService listService;

	@Inject
	private ReadArticleService readService;

	@Inject
	private WriteArticleService writeService;

	@Inject
	private ModifyArticleService modifyService;

	@Inject
	private DeleteArticleService deleteService;

	@Inject
	private CommentService commentService;

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
	public void readArticleForm(HttpSession session, BoardDTO dto, Model model) throws Exception {

		logger.info("uploadPath:" + uploadPath);
		if (session.getAttribute("login") != null) {
			UserInfo user = (UserInfo) session.getAttribute("login");
			model.addAttribute("user", user);
		} else {
			UserInfo user = new UserInfo();
			user.setUserNo(0);
			model.addAttribute("user", user);
		}

		model.addAttribute("boardNo", dto.getBoardNo());
		model.addAttribute("boardInfoList", readService.view(dto));
		model.addAttribute("nextBoardNo", readService.nextView(dto));
		model.addAttribute("prevBoardNo", readService.prevView(dto));
		model.addAttribute("boardInfo", readService.getArticle(dto));
		model.addAttribute("nickName", readService.getName(dto));

	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(HttpServletRequest req) throws Exception {
		return "board/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeSubmit(HttpSession session, MultipartFile file, BoardDTO dto, Model model) throws Exception {

		UserInfo user = (UserInfo) session.getAttribute("login");
		BoardPicInfo pic = new BoardPicInfo();

		dto.setUserNo(user.getUserNo());
		writeService.writeArticle(dto);

		// �뙆�씪�쓣 �꽑�깮�븳 寃쎌슦�뿉留� �뾽濡쒕뱶 �떎�뻾
		if (file.getOriginalFilename() != "") {
			String save = uploadFile(file.getOriginalFilename(), file.getBytes());

			pic.setBoardPic1(save);
			pic.setBoardNo(dto.getBoardNo());
			writeService.writePic(pic);
		} else {
			writeService.writePicNull(dto);
		}

		return "board/success";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String ModifyForm(BoardDTO dto, Model model) throws Exception {

		model.addAttribute("nickName", readService.getName(dto));
		model.addAttribute("modReq", dto);

		return "board/modifyForm";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String ModifySubmit(MultipartFile file, BoardDTO dto, Model model) throws Exception {

		BoardPicInfo pic = new BoardPicInfo();
		BoardPicInfo boardPic = deleteService.getBoardPic(dto);
		modifyService.update(dto);

		// �뙆�씪�쓣 �꽑�깮�븳 寃쎌슦�뿉留� �뾽濡쒕뱶 �떎�뻾
		if (file.getOriginalFilename() != "") {
			if (boardPic != null) {
				File file_ = new File(uploadPath + "\\" + boardPic.getBoardPic1());
				if (file_.exists()) {
					file_.delete();
				}
			}
			String save = uploadFile(file.getOriginalFilename(), file.getBytes());

			pic.setBoardPic1(save);
			pic.setBoardNo(dto.getBoardNo());
			modifyService.updatePic(pic);
		} else {

			logger.info("짱");

			File file_ = new File(uploadPath + "\\" + boardPic.getBoardPic1());
			if (file_.exists()) {
				file_.delete();
			}
			modifyService.updatePicNull(dto);

		}

		return "board/success";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String DeleteForm(BoardDTO dto) throws Exception {

		BoardPicInfo boardPic = deleteService.getBoardPic(dto);

		if (boardPic != null) {
			File file = new File(uploadPath + "\\" + boardPic.getBoardPic1());
			if (file.exists()) {
				file.delete();
			}
		}
		deleteService.delete(dto);

		return "board/success";
	}

	@RequestMapping(value = "/insertComment", method = RequestMethod.POST)
	@ResponseBody
	public void Comment(HttpSession session, BoardDTO dto, @RequestParam("comment") String comment) throws Exception {

		logger.info("boardNo =" + dto.getBoardNo());
		logger.info("comment =" + comment);
		UserInfo user = (UserInfo) session.getAttribute("login");
		int userNo = user.getUserNo();
		dto.setUserNo(userNo);
		commentService.insertComment(dto, comment);

	}

	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentInfo> commentReload(BoardDTO dto, HttpServletRequest req) throws Exception {
		logger.info("boardNo =" + req.getParameter("boardNo"));
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		dto.setBoardNo(boardNo);

		return commentService.getComment(dto);
	}

	@RequestMapping(value = "/commentDelete", method = RequestMethod.POST)
	@ResponseBody
	public void commentDelete(CommentDTO dto) throws Exception {
		commentService.deleteComment(dto);
	}

	@RequestMapping(value = "/commentUpdate", method = RequestMethod.POST)
	@ResponseBody
	public void commentUpdate(CommentDTO dto) throws Exception {

		commentService.updateComment(dto);
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {

		// �씠由꾩씠 以묐났�릺吏� �븡�룄濡� �옖�뜡�븯寃� �씠由꾩쓣 異붽�
		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;

	}
}