package com.ssafy.board.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import com.ssafy.board.model.dto.Board;
//싱글턴
public class BoardServiceImpl implements BoardService{
	
	Repository
	
	private static BoardService service = new BoardServiceImpl();
	
	private BoardServiceImpl() {
		
	}
	public static BoardService getInstance() {
		return service;
	}
	
	
	@Override
	public List<Board> getList() {
		// TODO Auto-generated method stub
		return repository.selectAll();
	}

	@Override
	public Board getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeBoard(Board board) {

		
	}

	@Override
	public void modifyBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub
		
	}

}
