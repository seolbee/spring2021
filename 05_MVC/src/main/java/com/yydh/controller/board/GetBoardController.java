package com.yydh.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yydh.model.board.BoardDAO;
import com.yydh.model.board.BoardVO;

public class GetBoardController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String seq = request.getParameter("seq");
		int intSeq = Integer.parseInt(seq);
		
		// DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(intSeq);
		
		// 세션에 데이터 전달
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard");
		
		// 리다이렉트
//		response.sendRedirect("getBoard.jsp");
		return mav;
	}
}
