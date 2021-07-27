package org.care.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.care.dto.StoreDTO;
import org.care.service.StoreService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class ApiController {

//	public static final Logger Logger = LoggerFactory.getLogger(ApiController.class);
//
//	@Inject
//	private StoreService service;
//
//	@Inject
//	private StoreDTO storeDTO;
//
//	@RequestMapping(value = "/apiSync", method = RequestMethod.GET)
//	public void ApiPage(Model model) {
//
//	}
//
//	@RequestMapping(value = "/apiSync", method = RequestMethod.POST)
//	public void ApiPOSTPage(HttpServletRequest req, HttpServletResponse response, Model model) {

//		JSONObject jsonObj = null;
//		JSONObject jsonObj2 = null;
//		String list_total_count = "";
//
//		try {
//			BufferedReader br = null;
//			String chkTotalCountResult = "";
//
//			String urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/1/1/";
//			URL url = new URL(urlstr);
//			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//			String line;
//			while ((line = br.readLine()) != null) {
//				chkTotalCountResult = chkTotalCountResult + line;
//			}
//
//			JSONParser parser = new JSONParser();
//			jsonObj = (JSONObject) parser.parse(chkTotalCountResult);
//			jsonObj2 = (JSONObject) jsonObj.get("LOCALDATA_072405");
//			list_total_count = jsonObj2.get("list_total_count").toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		int endNo = Integer.parseInt(list_total_count) / 500;
//		int lastNo = Integer.parseInt(list_total_count) % 500;
//		int pageNo = 500;
//
//		for (int j = 0; j < endNo; j++) {
//
//			String urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/";
//			if (j == endNo - 1) {
//				urlstr = urlstr + ((j * pageNo) + 1) + "/" + ((j * pageNo) + lastNo) + "/";
//			} else {
//				urlstr = urlstr + ((j * pageNo) + 1) + "/" + ((j * pageNo) + pageNo) + "/";
//			}
//
//			String result = "";
//			BufferedReader br = null;
//
//			try {
//				URL url = new URL(urlstr);
//				HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//				br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//
//				String line;
//
//				while ((line = br.readLine()) != null) {
//					result = result + line;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			try {
//				JSONParser parser = new JSONParser();
//				jsonObj = (JSONObject) parser.parse(result);
//				jsonObj2 = (JSONObject) jsonObj.get("LOCALDATA_072405");
//
//				JSONArray jsonArray = (JSONArray) ((JSONObject) jsonObj2).get("row");
//
//				for (int i = 0; i < jsonArray.size(); i++) {
//					JSONObject jsonObj3 = new JSONObject();
//					jsonObj3 = (JSONObject) jsonArray.get(i);
//
//					if (jsonObj3.get("BPLCNM").toString() != null
//							&& !jsonObj3.get("BPLCNM").toString().trim().equals("")) {
//						if (jsonObj3.get("RDNWHLADDR").toString() != null
//								&& !jsonObj3.get("RDNWHLADDR").toString().trim().equals("")) {
//							if (jsonObj3.get("DTLSTATEGBN").toString().equals("01")) { // 01:�쁺�뾽, 02:�룓�뾽
//								if (jsonObj3.get("UPTAENM").toString().equals("떡카페")
//										|| jsonObj3.get("UPTAENM").toString().equals("과자점")
//										|| jsonObj3.get("UPTAENM").toString().equals("아이스크림")
//										|| jsonObj3.get("UPTAENM").toString().equals("전통찻집")
//										|| jsonObj3.get("UPTAENM").toString().equals("커피숍")) {
//
//									storeDTO.setStoreName(jsonObj3.get("BPLCNM").toString());
//									storeDTO.setAddress(jsonObj3.get("RDNWHLADDR").toString());
//									storeDTO.setManageNo(jsonObj3.get("MGTNO").toString());
//
//									if (jsonObj3.get("SITETEL").toString() == null
//											|| "".equals(jsonObj3.get("SITETEL").toString())) {
//										storeDTO.setCallNumber(null);
//									} else {
//										String callNum = jsonObj3.get("SITETEL").toString().replaceAll(" ", "");
//										storeDTO.setCallNumber(callNum);
//									}
//
//									service.store(storeDTO);
//								}
//							}
//						}
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} // for End

//	}
}
