package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.User;

public interface BoardDao {
	List<Board> selectAll();

	List<Board> searchByCondition(SearchCondition condition);

	Board select(int id);

	int delete(int id);

	int update(Board board);

	int insert(Board board);
}
