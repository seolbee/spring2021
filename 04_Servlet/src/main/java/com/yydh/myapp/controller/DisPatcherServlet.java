package com.yydh.myapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yydh.myapp.board.BoardDAO;
import com.yydh.myapp.board.BoardVO;
import com.yydh.myapp.user.UserDAO;
import com.yydh.myapp.user.UserService;
import com.yydh.myapp.user.UserServiceImpl;
import com.yydh.myapp.user.UserVO;

public class DisPatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisPatcherServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();  // login.do
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 클라이언트의 요청 path에 따라 적저리 분기처리 한다.
		if(path.equals("/login.do")) {
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
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			
			
			// 3. 화면 네비게이션
			if(user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
	
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			// 1. 브라우저와 연결된 세션 객체를 강제 종료
			HttpSession session = request.getSession();
			session.invalidate();
						
			// 2. 세션 종료 후, 메인 화면으로 이동
			response.sendRedirect("login.jsp");
			
		} else if(path.equals("/getBoardList.do")) {
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
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");	
			
			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			String seq = request.getParameter("seq");
			int intSeq = Integer.parseInt(seq);
			
			// DB 연동 처리
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(intSeq);
			
			// 세션에 데이터 전달
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			// 리다이렉트
			response.sendRedirect("getBoard.jsp");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			// 1. 사용자 입력 정보 추출
			request.setCharacterEncoding("EUC-KR");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 리다이렉트
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
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
			response.sendRedirect("getBoardList.do");		
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			String seq = request.getParameter("seq");
			
			// DB 연동 처리
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(Integer.parseInt(seq));
			
			// 리다이렉트
			response.sendRedirect("getBoardList.do");
		}
		
		
		
		
		
		
	}
	
}
