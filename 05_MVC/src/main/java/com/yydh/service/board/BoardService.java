package com.yydh.service.board;

import java.util.List;

import com.yydh.model.board.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(int seq);
	BoardVO getBoard(int seq);
	List<BoardVO> getBoardList();
}
