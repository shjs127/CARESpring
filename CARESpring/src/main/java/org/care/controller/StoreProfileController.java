package org.care.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.care.domain.StoreInfo;
import org.care.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class StoreProfileController {

	@Inject
	private StoreService storeService;

	@RequestMapping(value = "/store/profile", method = RequestMethod.POST)
	public String profilePost(StoreInfo sInfo, HttpSession session, HttpServletRequest req, RedirectAttributes rttr)
			throws Exception {

		StoreInfo store = (StoreInfo) session.getAttribute("storein");

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

		storeService.changeInfo(sInfo);
		session.removeAttribute("storein");
		session.invalidate();
		return "redirect:/login";
	}

	

}
