package com.ssafy.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.model.dto.SearchCondition;

@Service
public interface BoardService {
	List<Board> selectAll();

	Board select(int id);

	int delete(int id);

	int update(Board board);

	int insert(Board board);

	List<Board> searchByCondition(SearchCondition condition);

}
