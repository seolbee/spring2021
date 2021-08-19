package com.yydh.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yydh.model.board.BoardDAO;
import com.yydh.model.board.BoardVO;

public class UpdateBoardController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 사용자 입력 정보 추출
		request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. 리다이렉트
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
}
