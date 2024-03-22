package com.ssafy.board.test;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class BoardTest {

	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
//		for(Board b : dao.selectAll()) {
//			System.out.println(b);
//		}
		
//		System.out.println(dao.selectOne(0));
		
//		Board board = new Board("제목","저자","콘텐츠");
//		dao.insertBoard(board);
//		
//		dao.deleteBoard(5);
		
		Board board1 = dao.selectOne(6);
		board1.setTitle("이제는 알아야한다");
		board1.setContent("back");
		
		dao.updateBoard(board1);
	}
}