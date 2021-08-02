package org.care.controller;


import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.care.dto.DetailDTO;
import org.care.dto.StoreDTO;
import org.care.service.StoreRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller



@RequestMapping("/")
public class StoreRegisterController {

	private static final Logger logger = LoggerFactory.getLogger(StoreRegisterController.class);

	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Inject
	StoreRegisterService storeRegisterService;
	


	@RequestMapping(value = "/StoreRegister", method = RequestMethod.GET)
	public String getStoreRegister() throws Exception {
		logger.info("get storeRegister");

		return "login/StoreRegister";
	}

	// 매장등록 처리
	@RequestMapping(value = "/StoreRegister", method = RequestMethod.POST)
	public String postRegister(MultipartFile file, StoreDTO dto , DetailDTO ddto) throws Exception {
		logger.info("post register");
		logger.info("storeName=" + dto.getStoreName());
		logger.info("address=" + dto.getAddress());
		
		logger.info("totalseat=" + ddto.getTotalSeat());
			
		if(ddto.getSocketSeat() == null) {
		 ddto.setSocketSeat(0);	
		}
		
		if(ddto.getTotalSeat() == null) {
			 ddto.setTotalSeat(0);	
			}
		logger.info("socketSeat=" + ddto.getSocketSeat());

		logger.info("totalseat=" + ddto.getTotalSeat());


		
		
		if(file.getOriginalFilename() != "") {
			String save = uploadFile(file.getOriginalFilename(), file.getBytes());
			
			
					dto.setStorePic(save);
			
			
			}else {dto.setStorePic("");
			}

			
		storeRegisterService.storeRegister(dto,ddto);
		
		return "login/login";
	
	
	
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {

		//�씠由꾩씠 以묐났�릺吏� �븡�룄濡� �옖�뜡�븯寃� �씠由꾩쓣 異붽�
		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;

	
}
	

}
