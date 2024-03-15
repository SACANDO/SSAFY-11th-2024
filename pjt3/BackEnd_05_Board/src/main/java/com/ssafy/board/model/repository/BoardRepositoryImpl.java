package com.ssafy.board.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Board;

//싱글턴으로 관리
public class BoardRepositoryImpl implements BoardRepository {
	// DB와 연결되어 해당 로직을 호출
	private static BoardRepository repository = new BoardRepositoryImpl();

	// 메모리를 DB라고 생각하고 처리하겠다!!
	private List<Board> list = new ArrayList<>(); // 리스트관리
	private Map<Integer, Board> boards = new HashMap<>(); // 맵으로 관리

	private BoardRepositoryImpl() {
		boards.put(1, new Board("SSAFY 완벽가이드", "양띵균", "1학기를 잘 이수하는 방법은...."));
		
	}

	public static BoardRepository getInstance() {
		return repository;
	}

	@Override
	public List<Board> selectAll() {
//		return list; 
//		return (List<Board>)boards.values();
		
		List<Board> tmp = new ArrayList<>();
		for(int i : boards.keySet()) {
			tmp.add(boards.get(i));
		}
		return tmp;
	}

	@Override
	public Board selectOne(int id) {
		//List 썼었으면 반복문을 돌려야해
//		for(Board b : list) {
//			if(b.getId() == id)
//				return b;
//		}
		
		return boards.get(id); //ㅡmap을 씀
	}

	@Override
	public void insertBoard(Board board) {
		boards.put(board.getId(), board); // ID를 Key로 저장
		list.add(board); // 리스트에 저장할 수 도 있음
	}

	@Override
	public void updateBoard(Board board) {
		boards.put(board.getId(), board);
	}

	@Override
	public void deleteBoard(int id) {
		boards.remove(id);
	}

	@Override
	public void updateViewCnt(int id) {
		Board b = boards.get(id);
		b.setViewCnt(b.getViewCnt()+1);
	}

}
