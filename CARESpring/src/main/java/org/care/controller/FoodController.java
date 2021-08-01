package org.care.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.care.domain.DetailInfo;
import org.care.domain.MenuInfo;
import org.care.domain.ReviewInfo;
import org.care.domain.ReviewPaging;
import org.care.domain.ReviewPic;
import org.care.domain.StoreInfo;
import org.care.domain.UserInfo;
import org.care.dto.ReviewDTO;
import org.care.dto.StoreDTO;
import org.care.service.DeleteFoodService;
import org.care.service.FoodService;
import org.care.service.ModifyFoodService;
import org.care.util.MediaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class FoodController {
	public static final Logger Logger = LoggerFactory.getLogger(ListStoreController.class);
	
	@Inject
	public FoodService foodService;

	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/login/storeinSuccess", method = RequestMethod.POST)
	public String storeinPOST(StoreDTO dto, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {

		StoreInfo sInfo = foodService.login(dto);

		if (sInfo == null) {
			model.addAttribute("storeInfo", null);
			rttr.addFlashAttribute("storeLoginFalse", false);
			return "redirect:/login";
		}
		model.addAttribute("storeVo", sInfo);
		
		return "/login/storeinSuccess";

	}

	@RequestMapping(value = "/storeLogout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		Object obj = session.getAttribute("storein");

		if (obj != null) {

			session.removeAttribute("storein");
			session.invalidate();

		}

		return "login/storeLogout";
	}

	@RequestMapping(value = "/store/profile", method = RequestMethod.GET)
	public String profilePage(HttpServletRequest request, HttpSession session, Model model) throws Exception {

		StoreInfo storeInfo = (StoreInfo) session.getAttribute("storein");
		int storeNo = storeInfo.getStoreNo();

		/*
		 * List<ReviewDTO> reviewInfoList = userService.selectReviewUser(storeNo);
		 * model.addAttribute("reviewInfoList", reviewInfoList);
		 * 
		 * List<Favorite> favorite = foodService.selectFavorite(userNo);
		 * model.addAttribute("favorite", favorite);
		 */

		return "profile/storeProfile";
	}

	@Inject
	private DeleteFoodService deleteFoodService;

	@RequestMapping(value = "/store/storeList/detail", method = RequestMethod.GET)
	public String StoreDetailPage(@RequestParam("storeNo") int storeNo, Model model, ReviewPaging reviewPaging,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {

		StoreInfo storeInfo = foodService.selectStore(storeNo);
		model.addAttribute("storeInfo", storeInfo);

		DetailInfo detailInfo = foodService.selectDetail(storeNo);
		model.addAttribute("detailInfo", detailInfo);

		List<ReviewDTO> reviewDTO = foodService.selectReview(storeNo);
		model.addAttribute("reviewDTO", reviewDTO);

		List<MenuInfo> menuInfo = foodService.selectMenu(storeNo);
		model.addAttribute("menuInfo", menuInfo);

		// 페이징
		int total = foodService.countReview();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		reviewPaging = new ReviewPaging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", reviewPaging);
		model.addAttribute("viewAll", foodService.selectReviewP(reviewPaging));

		return "detail/food-details";
	}

	@RequestMapping(value = "/store/storeList/detail", method = { RequestMethod.POST })
	public String Insert(@RequestParam("storeNo") int storeNo, MultipartFile file, ReviewDTO dto, HttpSession session,
			Model model) throws Exception {

		UserInfo login = (UserInfo) session.getAttribute("login");
		int userNo = login.getUserNo();
		foodService.insertReview(storeNo, userNo, dto);

		ReviewPic pic = new ReviewPic();
		// 파일을 선택한 경우에만 업로드 실행
		if (file.getOriginalFilename() != "") {
			System.out.println("/*** file.getOriginalFileName()=" + file.getOriginalFilename());
			String save = uploadFile(file.getOriginalFilename(), file.getBytes());

			pic.setReviewPic1(save);
			pic.setStoreNo(storeNo);
			pic.setUserNo(userNo);
			foodService.reviewPic(pic);
		}

		return "redirect:/store/storeList/detailreviews?storeNo=" + storeNo;

	}
	
	//새로 만든거 시작 - 리뷰
	@RequestMapping(value = "/store/storeList/detailreviews", method = RequestMethod.GET)
	public String detailreviews(@RequestParam("storeNo") int storeNo, Model model, ReviewPaging reviewPaging,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		System.out.println("storeNo:::::::::::::::" + storeNo);
		StoreInfo storeInfo = foodService.selectStore(storeNo);
		model.addAttribute("storeInfo", storeInfo);

		DetailInfo detailInfo = foodService.selectDetail(storeNo);
		model.addAttribute("detailInfo", detailInfo);

		List<ReviewDTO> reviewDTO = foodService.selectReview(storeNo);
		model.addAttribute("reviewDTO", reviewDTO);

		List<MenuInfo> menuInfo = foodService.selectMenu(storeNo);
		model.addAttribute("menuInfo", menuInfo);

		// 페이징
		int total = foodService.countReview();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		reviewPaging = new ReviewPaging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", reviewPaging);
		model.addAttribute("viewAll", foodService.selectReviewP(reviewPaging));

		return "detail/revfood-details";
	}
	
	@RequestMapping(value = "/store/storeList/detailreviews", method = { RequestMethod.POST })
	public String reviewsd(@RequestParam("storeNo") int storeNo, MultipartFile file, ReviewDTO dto, HttpSession session,
			Model model) throws Exception {

		UserInfo login = (UserInfo) session.getAttribute("login");
		int userNo = login.getUserNo();
		foodService.insertReview(storeNo, userNo, dto);

		ReviewPic pic = new ReviewPic();
		// 파일을 선택한 경우에만 업로드 실행
		if (file.getOriginalFilename() != "") {
			System.out.println("/*** file.getOriginalFileName()=" + file.getOriginalFilename());
			String save = uploadFile(file.getOriginalFilename(), file.getBytes());

			pic.setReviewPic1(save);
			pic.setStoreNo(storeNo);
			pic.setUserNo(userNo);
			foodService.reviewPic(pic);
		}

		return "redirect:/store/storeList/detailreviews?storeNo=" + storeNo;

	}
	//새로 만든거 끝
	
	

	@RequestMapping(value = "/store/storeList/deleteReview", method = RequestMethod.GET)
	public String delete(ReviewDTO dto, HttpServletRequest req, HttpServletResponse response, HttpSession session,
			Model model) throws Exception {

		int reviewNo = Integer.parseInt(req.getParameter("seq"));
		List<ReviewInfo> reviewInfo = deleteFoodService.selectReviewDetail(reviewNo);

		System.out.println("storeNo=" + reviewInfo.get(0).getStoreNo());

		deleteFoodService.deleteReview(reviewNo);

		return "redirect:/store/storeList/detailreviews?storeNo=" + reviewInfo.get(0).getStoreNo();
	}

	@Inject
	private ModifyFoodService modifyFoodService;

	@RequestMapping(value = "/store/storeList/modifyReview", method = RequestMethod.GET)
	public String modify1(ReviewDTO dto, HttpServletRequest req, HttpServletResponse response, HttpSession session,
			Model model) throws Exception {
		int reviewNo = Integer.parseInt(req.getParameter("seq"));
		List<ReviewInfo> reviewInfo = modifyFoodService.selectReviewDetail(reviewNo);

		model.addAttribute("reviewInfo", reviewInfo);

//	model.addAttribute("modReq", dto);

		return "detail/modifyReview";
	}

	@RequestMapping(value = "/store/storeList/modifyReview", method = RequestMethod.POST)
	public String modify(ReviewDTO dto, HttpServletRequest req, Model model) throws Exception {

		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		int storeNo = Integer.parseInt(req.getParameter("storeNo"));
		String reviewContents = req.getParameter("reviewContents");
		int avgScore = Integer.parseInt(req.getParameter("avgScore"));

		modifyFoodService.modifyReview(reviewNo, reviewContents, avgScore);

		return "redirect:/store/storeList/detailreviews?storeNo=" + storeNo;

	}
	
	
	
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;

	}
	

	
	  @ResponseBody
	  
	  @RequestMapping("/displayFile") public ResponseEntity<byte[]>
	  displayFile(String fileName)throws Exception{
	  
	  InputStream in = null; ResponseEntity<byte[]> entity = null;
	  
	  Logger.info("FILE NAME: " + fileName);
	  
	  try{
	  
	  String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	  
	  MediaType mType = MediaUtils.getMediaType(formatName);
	  
	  HttpHeaders headers = new HttpHeaders();
	  
	  in = new FileInputStream(uploadPath+fileName);
	  
	  if(mType != null){ headers.setContentType(mType); }else{
	  
	  fileName = fileName.substring(fileName.indexOf("_")+1);
	  headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	  headers.add("Content-Disposition", "attachment; filename=\""+ new
	  String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); }
	  
	  entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,
	  HttpStatus.CREATED); }catch(Exception e){ e.printStackTrace(); entity = new
	  ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST); }finally{ in.close(); }
	  return entity; }
	  
	  @ResponseBody
	  
	  @RequestMapping(value="/deleteFile", method=RequestMethod.POST) public
	  ResponseEntity<String> deleteFile(String fileName){
	  
	  Logger.info("delete file: "+ fileName);
	  
	  String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	  
	  MediaType mType = MediaUtils.getMediaType(formatName);
	  
	  if(mType != null){
	  
	  String front = fileName.substring(0,12); String end = fileName.substring(14);
	  new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
	  }
	  
	  new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
	  
	  
	  return new ResponseEntity<String>("deleted", HttpStatus.OK); }
	  
	  @ResponseBody
	  
	  @RequestMapping(value="/deleteAllFiles", method=RequestMethod.POST) public
	  ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files){
	  
	  Logger.info("delete all files: "+ files);
	  
	  if(files == null || files.length == 0) { return new
	  ResponseEntity<String>("deleted", HttpStatus.OK); }
	  
	  for (String fileName : files) { String formatName =
	  fileName.substring(fileName.lastIndexOf(".")+1);
	  
	  MediaType mType = MediaUtils.getMediaType(formatName);
	  
	  if(mType != null){
	  
	  String front = fileName.substring(0,12); String end = fileName.substring(14);
	  new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
	  }
	  
	  new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
	  
	  } return new ResponseEntity<String>("deleted", HttpStatus.OK); }
	 


}