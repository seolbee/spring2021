package com.yydh.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yydh.www.board.BoardDAO;
import com.yydh.www.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAO boardDAO;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, HttpServletRequest request) {
			
		String searchString = request.getParameter("searchKeyword");
		List<BoardVO> boardList = null;
		
		if(searchString != null) {
			boardList = boardDAO.searchBoardList(searchString);
		} else {
			// 1. DB 연동 처리
			boardList = boardDAO.getBoardList();
		}
		
		// 2. 검색 결과를 세션에 저장하고 목록 화면으로 이동
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		response.sendRedirect("getBoardList.jsp");
		
		// ModelAndView로 결과 화면을 생성
		model.addAttribute("boardList", boardList); // Model 정보 저장 
		return "getBoardList";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		// 2. DB 연동 처리
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo.getSeq()));
		return "getBoard";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo.getSeq());
		return "redirect:getBoardList.do";
	}
}
