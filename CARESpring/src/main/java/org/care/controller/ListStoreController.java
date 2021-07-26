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
import org.care.domain.Criteria;
import org.care.domain.DetailInfo;
import org.care.domain.MenuInfo;
import org.care.domain.PageMaker;
import org.care.domain.ReviewInfo;
import org.care.domain.ReviewPic;
import org.care.domain.SearchCriteria;
import org.care.domain.StoreInfo;
import org.care.domain.UserInfo;
import org.care.dto.ReviewDTO;
import org.care.service.DeleteFoodService;
import org.care.service.FoodService;
import org.care.service.ListStoreService;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/store")
public class ListStoreController {

	public static final Logger Logger = LoggerFactory.getLogger(ListStoreController.class);

	@Inject
	private ListStoreService service;

	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardPage(HttpServletRequest request, Model model) throws Exception {

		model.addAttribute("list", service.listAll());

		return "board/cafeGrid";
	}

	@RequestMapping(value = "/storeList", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		Logger.info(cri.toString());

		model.addAttribute("list", service.listCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount((service.countPaging(cri)));

		model.addAttribute("pageMaker", pageMaker);

		return "board/cafeGrid";
	}

	@RequestMapping(value = "/storeList", method = RequestMethod.POST)
	public String SearchListPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {

		model.addAttribute("list", service.listSearch(scri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);

		pageMaker.setTotalCount(service.listSearchCount(scri));

		model.addAttribute("pageMaker", pageMaker);

		return "board/cafeGrid";
	}

	@Inject
	public FoodService foodService;
	@Inject
	private DeleteFoodService deleteFoodService;

	@RequestMapping(value = "/storeList/detail", method = RequestMethod.GET)
	public String StoreDetailPage(@RequestParam("storeNo") int storeNo, Model model) throws Exception {

		StoreInfo storeInfo = foodService.selectStore(storeNo);
		model.addAttribute("storeInfo", storeInfo);

		DetailInfo detailInfo = foodService.selectDetail(storeNo);
		model.addAttribute("detailInfo", detailInfo);

		List<ReviewInfo> reviewInfo = foodService.selectReview(storeNo);
		model.addAttribute("reviewInfo", reviewInfo);

		List<MenuInfo> menuInfo = foodService.selectMenu(storeNo);
		model.addAttribute("menuInfo", menuInfo);

		return "detail/food-details";
	}

	@RequestMapping(value = "/storeList/detail", method = { RequestMethod.POST })
	public String Insert(@RequestParam("storeNo") int storeNo, MultipartFile file, ReviewDTO dto,
			HttpSession session, Model model) throws Exception {

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

		return "redirect:/store/storeList/detail?storeNo=" + storeNo;
		
	}

	
	
	@RequestMapping(value = "/storeList/deleteReview", method = RequestMethod.GET)
	public String delete(ReviewDTO dto, HttpServletRequest req, HttpServletResponse response, HttpSession session,
			Model model) throws Exception {

		int reviewNo = Integer.parseInt(req.getParameter("seq"));
		Integer storeNo= deleteFoodService.read(reviewNo);
		System.out.println("storeNo="+storeNo);
		
		
		deleteFoodService.deleteReview(reviewNo);

		
		return "redirect:/store/storeList/detail?storeNo=" + storeNo;
	}
	
	@Inject
	private ModifyFoodService modifyFoodService;
	
	
	@RequestMapping(value = "/storeList/modifyReview", method = RequestMethod.GET)
	public String modify1(ReviewDTO dto, HttpServletRequest req, Model model)throws Exception {
		

		
		return "detail/modifyReview";
	}
	
	
	@RequestMapping(value = "/storeList/modifyReview", method = RequestMethod.POST)
	public String modify(ReviewDTO dto, HttpServletRequest req, Model model)throws Exception {
		System.out.println("modify()");
		
		
		int reviewNo = Integer.parseInt(req.getParameter("seq"));
		Integer storeNo= modifyFoodService.read(reviewNo);
		System.out.println("storeNo="+storeNo);
		
		
		modifyFoodService.modifyReview(reviewNo);

		
		return "redirect:/store/storeList/detail?storeNo=" + storeNo;
	}

		

		

//	@RequestMapping(value = "/storeList/orderby", method = )	

	@RequestMapping(value = "/storeList/detailInfoChk", method = RequestMethod.POST)
	@ResponseBody
	public void detailInfoChk(@RequestParam(value = "valueArrTest[]") List<String> valueArr) {

	}
	
	/*
	 * @RequestMapping(value = "/uploadForm", method = RequestMethod.GET) public
	 * void uploadForm() { }
	 * 
	 * @RequestMapping(value = "/uploadForm", method = RequestMethod.POST) public
	 * String uploadForm(MultipartFile file, Model model) throws Exception {
	 * 
	 * Logger.info("originalName: " + file.getOriginalFilename());
	 * Logger.info("size: " + file.getSize()); Logger.info("contentType: " +
	 * file.getContentType());
	 * 
	 * String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
	 * 
	 * model.addAttribute("savedName", savedName);
	 * 
	 * return "/detail/uploadResult"; }
	 */
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
