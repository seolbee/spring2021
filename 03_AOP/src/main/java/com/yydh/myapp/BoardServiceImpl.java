package com.yydh.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}
	
	@Override
	public BoardVO getBoard(int idx) {
		return boardDAO.getBoard(idx);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		
	}
	
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		
	}
}
