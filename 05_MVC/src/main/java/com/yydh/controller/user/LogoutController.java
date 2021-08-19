package com.yydh.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. 브라우저와 연결된 세션 객체를 강제 종료
		HttpSession session = request.getSession();
		session.invalidate();
					
		// 2. 세션 종료 후, 메인 화면으로 이동
//		response.sendRedirect("login.jsp");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}
}
