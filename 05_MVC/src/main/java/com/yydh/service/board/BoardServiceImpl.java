package com.yydh.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yydh.model.board.BoardDAO;
import com.yydh.model.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard ����!!!");
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(int seq) {
		boardDAO.deleteBoard(seq);
	}

	@Override
	public BoardVO getBoard(int seq) {
		return boardDAO.getBoard(seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	

}
