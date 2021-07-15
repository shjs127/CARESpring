/*
 * package org.care.controller;
 * 
 * import java.util.Date; import java.util.List;
 * 
 * import javax.inject.Inject; import javax.servlet.http.Cookie; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.care.domain.StoreInfo; import org.care.domain.UserInfo; import
 * org.care.dto.LoginDTO; import org.care.dto.StoreDTO; import
 * org.care.service.StoreService; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.servlet.ModelAndView; import
 * org.springframework.web.util.WebUtils;
 * 
 * @Controller public class DetailController {
 * 
 * @Inject public DetailService detailService;
 * 
 * @RequestMapping(value = "/storeDetail", method = RequestMethod.GET) public
 * String DetailInfoList(DetailDTO dto, HttpServletRequest req, Model model)
 * throws Exception {
 * 
 * List<DetailInfo> detailInfo = detailService.selectStore(dto);
 * model.addAttribute("detailInfo", detailInfo); return "detail/food-details"; }
 * 
 * }
 */