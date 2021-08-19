package com.yydh.myapp.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService)context.getBean("boardService");
		
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println("===> " + board.toString());
		}
		
		BoardVO vo = new BoardVO();
		vo.setSeq(3);
		vo.setTitle("제목3");
		vo.setContent("내용3");
		vo.setWriter("글쓴이3");
		vo.setRegDate(null);
		vo.setCnt(2);
		
		boardService.insertBoard(vo);
		System.out.println("===>" + vo.toString());
		
	}

}
