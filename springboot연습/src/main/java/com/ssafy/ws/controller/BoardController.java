package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.service.BoardService;
import com.ssafy.ws.service.UserService;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService bs;

	private HttpStatus httpstatus(int result) {
		return result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
	}

	private String msg(int result) {
		return result == 1 ? "성공" : "실패";
	}


	@PostMapping({"","/"})
	public ResponseEntity<?> insert(@RequestBody Board board) {
		int result = bs.insert(board);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}

	@GetMapping({"/",""})
	public ResponseEntity<List<Board>> selectAll() {
		List<Board> boards = bs.selectAll();
		return new ResponseEntity<List<Board>>(boards, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Board> select(@PathVariable ("id") int id) {
		Board board = bs.select(id);
		return new ResponseEntity<Board>(board, HttpStatus.OK);

	}

	@PostMapping("/search")
	public ResponseEntity<List<Board>> searchByCondition(@RequestBody SearchCondition condition) {
		List<Board> boards = bs.searchByCondition(condition);
		return new ResponseEntity<List<Board>>(boards, boards == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		int result = bs.delete(id);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Board board) {
		board.setId(id);
		int result = bs.update(board);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}
}
