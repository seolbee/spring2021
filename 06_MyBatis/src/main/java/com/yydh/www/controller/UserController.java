package com.yydh.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yydh.www.user.UserDAO;
import com.yydh.www.user.UserVO;


@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/login.do")
	public String Login(UserVO vo, HttpServletRequest request) {
		UserVO user = userDAO.getUser(vo);
		// 3. 화면 네비게이션
		if(user != null) {
//			response.sendRedirect("getBoardList.do");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:getBoardList.do";
		} else {
//			response.sendRedirect("login.jsp");
			return "login";
		}
	}
	
	@RequestMapping("/logout.do")
	public String Logout(HttpServletRequest request) {
		// 1. 브라우저와 연결된 세션 객체를 강제 종료
		HttpSession session = request.getSession();
		session.invalidate();
					
		// 2. 세션 종료 후, 메인 화면으로 이동
//		response.sendRedirect("login.jsp");
		return "redirect:login.jsp";

	}
}
