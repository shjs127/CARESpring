package org.care.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.care.domain.DetailInfo;
import org.care.domain.ReviewPic;
import org.care.domain.StoreInfo;
import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;
import org.care.service.FoodService;
import org.care.service.StoreProfileService;
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
@RequestMapping("/")
public class StoreProfileController {
	public static final Logger Logger = LoggerFactory.getLogger(StoreProfileController.class);
	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	public FoodService foodService;

	@Inject
	private StoreProfileService storeProfileService;

	@RequestMapping(value = "/login/storeinSuccess", method = RequestMethod.POST)
	public String storeinPOST(StoreDTO dto, HttpSession session, Model model, RedirectAttributes rttr)
			throws Exception {

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
	public String profilePage(HttpServletRequest request, HttpSession session, Model model, DetailInfo dInfo)
			throws Exception {

		StoreInfo storeInfo = (StoreInfo) session.getAttribute("storein");
		int storeNo = storeInfo.getStoreNo();

		dInfo.setStoreNo(storeNo);
		DetailInfo storeDetail = storeProfileService.selectDetail(dInfo);
		model.addAttribute("detail", storeDetail);
		session.setAttribute("detail", storeDetail);

		return "profile/storeProfile";
	}

	@RequestMapping(value = "/store/profile", method = RequestMethod.POST)
	public String profilePost(MultipartFile file, DetailDTO dto, StoreInfo sInfo, HttpSession session,
			HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		StoreInfo store = (StoreInfo) session.getAttribute("storein");
		DetailInfo detail = (DetailInfo) session.getAttribute("detail");
		System.out.println("detail=" + detail);
		if (!store.getManageNo().equals(sInfo.getManageNo())) {

			rttr.addFlashAttribute("msg", "fail");
			return "redirect:/store/profile";
		}

		if (sInfo.getAddress() == null || sInfo.getAddress().isEmpty()) {
			sInfo.setAddress(store.getAddress());
		}
		if (sInfo.getHours() == null || sInfo.getHours().isEmpty()) {
			sInfo.setHours(store.getHours());
		}
		if (sInfo.getClosedDays() == null || sInfo.getClosedDays().isEmpty()) {
			sInfo.setClosedDays(store.getClosedDays());
		}
		if (sInfo.getCallNumber() == null || sInfo.getCallNumber().isEmpty()) {
			sInfo.setCallNumber(store.getCallNumber());
		}
		System.out.println("dto totalseat=" + dto.getTotalSeat());
		System.out.println("detail totalseat=" + detail.getTotalSeat());
		if (dto.getTotalSeat() == null) {
			dto.setTotalSeat(detail.getTotalSeat());
		}
		if (dto.getSocketSeat() == null) {
			dto.setSocketSeat(detail.getSocketSeat());
		}

		if (file.getOriginalFilename() != "") {
			System.out.println("/*** file.getOriginalFileName()=" + file.getOriginalFilename());
			String save = uploadFile(file.getOriginalFilename(), file.getBytes());

			sInfo.setStorePic(save);
		}else {
			sInfo.setStorePic("");
		}

		storeProfileService.changeInfo(sInfo);
		storeProfileService.changeDetail(dto);
		session.removeAttribute("storein");
		session.invalidate();
		return "redirect:/login";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;

	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/displayFile") public ResponseEntity<byte[]>
	 * displayFile(String fileName) throws Exception {
	 * 
	 * InputStream in = null; ResponseEntity<byte[]> entity = null;
	 * 
	 * Logger.info("FILE NAME: " + fileName);
	 * 
	 * try {
	 * 
	 * String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
	 * 
	 * MediaType mType = MediaUtils.getMediaType(formatName);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * 
	 * in = new FileInputStream(uploadPath + fileName);
	 * 
	 * if (mType != null) { headers.setContentType(mType); } else {
	 * 
	 * fileName = fileName.substring(fileName.indexOf("_") + 1);
	 * headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	 * headers.add("Content-Disposition", "attachment; filename=\"" + new
	 * String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\""); }
	 * 
	 * entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,
	 * HttpStatus.CREATED); } catch (Exception e) { e.printStackTrace(); entity =
	 * new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST); } finally { in.close(); }
	 * return entity; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/deleteFile", method = RequestMethod.POST) public
	 * ResponseEntity<String> deleteFile(String fileName) {
	 * 
	 * Logger.info("delete file: " + fileName);
	 * 
	 * String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
	 * 
	 * MediaType mType = MediaUtils.getMediaType(formatName);
	 * 
	 * if (mType != null) {
	 * 
	 * String front = fileName.substring(0, 12); String end =
	 * fileName.substring(14); new File(uploadPath + (front + end).replace('/',
	 * File.separatorChar)).delete(); }
	 * 
	 * new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
	 * 
	 * return new ResponseEntity<String>("deleted", HttpStatus.OK); }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/deleteAllFiles", method = RequestMethod.POST)
	 * public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[]
	 * files) {
	 * 
	 * Logger.info("delete all files: " + files);
	 * 
	 * if (files == null || files.length == 0) { return new
	 * ResponseEntity<String>("deleted", HttpStatus.OK); }
	 * 
	 * for (String fileName : files) { String formatName =
	 * fileName.substring(fileName.lastIndexOf(".") + 1);
	 * 
	 * MediaType mType = MediaUtils.getMediaType(formatName);
	 * 
	 * if (mType != null) {
	 * 
	 * String front = fileName.substring(0, 12); String end =
	 * fileName.substring(14); new File(uploadPath + (front + end).replace('/',
	 * File.separatorChar)).delete(); }
	 * 
	 * new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
	 * 
	 * } return new ResponseEntity<String>("deleted", HttpStatus.OK); }
	 */

}
