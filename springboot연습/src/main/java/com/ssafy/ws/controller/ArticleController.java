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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Article;
import com.ssafy.ws.model.dto.Comment;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.service.ArticleService;
import com.ssafy.ws.service.UserService;

@RestController
@RequestMapping("/board")
//article생성, 조회 방법에 따라 url바꾸기
public class ArticleController {

	@Autowired
	ArticleService as;

	private HttpStatus httpstatus(int result) {
		return result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
	}

	private String msg(int result) {
		return result == 1 ? "성공" : "실패";
	}

	//조회 - board_id
	@GetMapping({"/",""})
	public ResponseEntity<List<Article>> selectAll() {
		List<Article> article = as.selectAll();
		return new ResponseEntity<List<Article>>(article, HttpStatus.OK);
		
	}

	//작성
	@PostMapping({"/",""})
	public ResponseEntity<?> insert(@RequestBody Article article, @RequestParam ("board_id") int board_id) {
		
		//board를 클릭하면 querystring에 자동으로 board_id가 들어가게할 수 있나?
		article.setBoard_id(board_id);
		
		int result = as.insert(article);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}

	//수정 - article에서 빼와도 ?
	@PutMapping("/{board_id}/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Article article) {
		article.setId(id);
		int result = as.update(article);
		return new ResponseEntity<>(msg(result), httpstatus(result));
		
	}
	
	//id 조회
	@GetMapping("/{id}")
	public ResponseEntity<Article> select(@PathVariable ("id") int id) {
		Article a = as.select(id);
		return new ResponseEntity<Article>(a, HttpStatus.OK);

	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		int result = as.delete(id);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}
	
	//싫어요
	@PostMapping({"/{id}/dislike"})
	public ResponseEntity<?> dislike(@PathVariable ("id") int id) {
		int result = as.dislike(id);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}
	
	//좋아요
	@PostMapping({"/{id}/like"})
	public ResponseEntity<?> like(@PathVariable ("id") int id) {
		int result = as.like(id);
		return new ResponseEntity<>(msg(result), httpstatus(result));

	}
	
	
//	//답글
	@PostMapping({"/{id}/reply"})
	public ResponseEntity<?> reply(@PathVariable ("id") int id ,@RequestBody Comment comment) {
		comment.setArticle_id(id);
		
		return new ResponseEntity<>(msg(0), httpstatus(0));

	}
}
