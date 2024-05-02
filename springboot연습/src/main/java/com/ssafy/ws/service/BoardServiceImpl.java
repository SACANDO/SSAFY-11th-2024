package com.ssafy.ws.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BoardDao;
import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {

		this.boardDao = boardDao;
	}

	@Override
	public List<Board> selectAll() {
		return boardDao.selectAll();
	}

	@Override
	public Board select(int id) {
		// TODO Auto-generated method stub
		return boardDao.select(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return boardDao.delete(id);
	}

	@Override
	public int update(Board board) {

		return boardDao.update(board);
	}

	@Override
	public int insert(Board board) {
		Date now = new Date();
		board.setCreated_at(now);
		return boardDao.insert(board);
	}

	@Override
	public List<Board> searchByCondition(SearchCondition condition) {
		return boardDao.searchByCondition(condition);
	}

	
	

}
