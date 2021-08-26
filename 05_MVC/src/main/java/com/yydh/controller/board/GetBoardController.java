package com.yydh.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yydh.model.board.BoardDAO;
import com.yydh.model.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 상세 조회 처리");
		
		String seq = request.getParameter("seq");
		int intSeq = Integer.parseInt(seq);
		
		// DB 연동 처리
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(intSeq);
		
		// 세션에 데이터 전달
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
		
		// 리다이렉트
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);
		mav.setViewName("getBoard");
		return mav;
	}

}
