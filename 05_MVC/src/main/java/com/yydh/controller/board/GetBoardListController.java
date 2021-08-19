package com.yydh.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yydh.model.board.BoardDAO;
import com.yydh.model.board.BoardVO;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 목록 검색 처리");
		
		String searchString = request.getParameter("searchKeyword");
		List<BoardVO> boardList = null;
		
		if(searchString != null) {
			BoardDAO boardDAO = new BoardDAO();
			boardList = boardDAO.searchBoardList(searchString);
		} else {
			// 1. DB 연동 처리
			BoardDAO boardDAO = new BoardDAO();
			boardList = boardDAO.getBoardList();
		}
		// 2. 검색 결과를 세션에 저장하고 목록 화면으로 이동
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		response.sendRedirect("getBoardList.jsp");
		
		ModelAndView mav = new ModelAndView();
		request.setAttribute("boardList", boardList);
		mav.setViewName("getBoardList");
		
		return mav;
	}
	
}
