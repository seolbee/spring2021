package com.yydh.myapp.board;

import java.sql.Date;
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
		
//		BoardVO vo  = new BoardVO();
//		Date date = new Date(20210707);
//		vo.setCnt(1);
//		vo.setContent("asdf");
//		vo.setRegDate(date);
//		vo.setSeq(2);
//		vo.setTitle("title");
//		vo.setWriter("writer");
//		
//		boardService.insertBoard(vo);
		
	}

}
