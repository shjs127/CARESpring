package org.care.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StoreinInterceptor extends HandlerInterceptorAdapter {

	private static final String STOREIN = "storein";
	private static final Logger logger = LoggerFactory.getLogger(StoreinInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();

		ModelMap modelMap = modelAndView.getModelMap();
		Object storeVO = modelMap.get("storeVo");

		if (storeVO != null) {

			logger.info("new login success");
			session.setAttribute(STOREIN, storeVO);

	
			  Object dest = session.getAttribute("dest");
			  
			  
			  response.sendRedirect(dest != null ? (String) dest :  request.getContextPath()+"/index");

		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute(STOREIN) != null) {
			logger.info("clear login data before");
			session.removeAttribute(STOREIN);
		}

		return true;
	}
}
