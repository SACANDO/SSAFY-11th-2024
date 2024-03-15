package com.ssafy.board.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardService {
	public abstract List<Board> getList();
	public abstract Board getBoard();
	public abstract void writeBoard(Board board);
	public abstract void modifyBoard(Board board);
	public abstract void removeBoard(int id);
}
