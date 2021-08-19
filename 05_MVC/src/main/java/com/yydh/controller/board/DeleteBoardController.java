package com.yydh.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yydh.model.board.BoardDAO;

public class DeleteBoardController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 삭제 처리");
		
		String seq = request.getParameter("seq");
		
		// DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(Integer.parseInt(seq));
		
		ModelAndView mav = new ModelAndView();
		// 리다이렉트
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
}
