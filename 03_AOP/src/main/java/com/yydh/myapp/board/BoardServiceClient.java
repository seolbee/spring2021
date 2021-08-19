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
		
	}

}
