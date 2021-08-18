package com.yydh.myapp;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService service = (BoardService) context.getBean("boardService");
		List<BoardVO> boardList = service.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println(board.toString());
		}
	}
}
