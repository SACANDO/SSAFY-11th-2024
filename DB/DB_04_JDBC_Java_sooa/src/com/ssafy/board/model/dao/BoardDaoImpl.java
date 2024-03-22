package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

//싱글턴으로 관리
public class BoardDaoImpl implements BoardDao{
	
	private final DBUtil dbUtil = DBUtil.getInstance();
	private static BoardDao instance = new BoardDaoImpl();
	
	private BoardDaoImpl() {
		
	}
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	@Override
	public List<Board> selectAll() {
		
		List<Board> list = new ArrayList<>();
		String sql = "select * FROM board";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		
		
		try {
			conn = dbUtil.getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board(); // 바구니 빈 게시글 준비
				board.setId(rs.getInt("id")); // 컬럼명이나 인덱스 넣기
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				
				list.add(board);
							
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs,stmt,conn);
		}
		return list;
	}

	@Override
	public Board selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		List<Board> list = new ArrayList<>();
		String sql = "select * FROM board where id=?";
		
		Board board = null;

		try {
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setId(rs.getInt("1")); // 컬럼명이나 인덱스 넣기
				board.setWriter(rs.getString("2"));
				board.setTitle(rs.getString("3"));
				board.setContent(rs.getString("4"));
				board.setViewCnt(rs.getInt("5"));
				board.setRegDate(rs.getString("6"));
										
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs,pstmt,conn);
		}
		
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board(title,writer,content) values (?,?,?)";
		
		try {
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
			conn.commit();
		} catch (SQLException e) {
//			conn.rollback();
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}
	}

	@Override
	public void deleteBoard(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where id=?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}
		
				
	}

	@Override
	public void updateBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set title=?,content=?where id=?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
//			conn.commit();
		} catch (SQLException e) {
//			conn.rollback();
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}		
	}

	@Override
	public void updateViewCnt(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set view_cnt = view_cnt+1 where id=?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
//			conn.commit();
		} catch (SQLException e) {
//			conn.rollback();
			e.printStackTrace();
		}finally {
			dbUtil.close(pstmt,conn);
		}		
		
	}
	
}
