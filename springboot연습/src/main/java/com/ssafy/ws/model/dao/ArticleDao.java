package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Article;

public interface ArticleDao {
	
	int insert(Article article);

	List<Article> selectAll();

	Article select(int id);

	int delete(int id);

	int update(Article article);

	int dislike(int id);

	int like(int id);
}
