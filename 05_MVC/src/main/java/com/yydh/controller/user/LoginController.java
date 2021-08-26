package com.yydh.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yydh.model.user.UserDAO;
import com.yydh.model.user.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB연동 처리 
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		
		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if(user != null) {
//			response.sendRedirect("getBoardList.do");
			mav.setViewName("redirect:getBoardList.do");
		} else {
//			response.sendRedirect("login.jsp");
			mav.setViewName("redirect:login.jsp");
		}
		
		return mav;
	}

}
