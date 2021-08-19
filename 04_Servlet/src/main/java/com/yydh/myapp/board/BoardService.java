package com.yydh.myapp.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(int seq);
	BoardVO getBoard(int seq);
	List<BoardVO> getBoardList();
}
