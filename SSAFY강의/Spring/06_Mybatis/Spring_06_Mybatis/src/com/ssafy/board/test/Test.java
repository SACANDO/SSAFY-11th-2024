package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for(Board board : boards) {
				System.out.println(board);
			}
		}
		
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
//			session.selectOne(null) 해당 라인의 selectOne과 아래의 selectOne 출처가 다르다.
 			Board board = dao.selectOne(1);
			System.out.println(board);
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = new Board("아괜", "양띵균", "아직은 괜찮아~");
			dao.insertBoard(board);
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			dao.deleteBoard(2);
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			dao.updateViewCnt(3);
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = dao.selectOne(1);
			board.setContent("열심히 해야한다");
			dao.updateBoard(board);
		}
		
	}
}
