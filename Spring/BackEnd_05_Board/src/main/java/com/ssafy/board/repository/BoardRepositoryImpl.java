package com.ssafy.board.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Board;

public class BoardRepositoryImpl implements BoardRepository {

	private static BoardRepository repository = new BoardRepositoryImpl();

	private Map<Integer, Board> boards = new HashMap<>();
	
	private BoardRepositoryImpl() {
	}
	public static BoardRepository getInstance() {
		return repository;
	}
	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		List<Board> tmp = new ArrayList<>();
		for()
	}
	@Override
	public Board selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertBoard(Board board) {

		boards.put(board.getId(), board);
	}
	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
