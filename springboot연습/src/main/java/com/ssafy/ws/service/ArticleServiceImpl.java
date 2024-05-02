package com.ssafy.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.ArticleDao;
import com.ssafy.ws.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleDao ad;
	
	
	
	public ArticleServiceImpl(ArticleDao ad) {
		this.ad = ad;
	}

	@Override
	public int insert(Article article) {
		return ad.insert(article);
	}

	@Override
	public List<Article> selectAll() {
		return ad.selectAll();
	}

	@Override
	public Article select(int id) {
		Article article = ad.select(id);
		article.setView_cnt(article.getView_cnt()+1);
		return article;
	}

	@Override
	public int delete(int id) {
		
		return ad.delete(id);
	}

	@Override
	public int update(Article article) {
		return ad.update(article);
	}

	@Override
	public int dislike(int id) {
		return 0;
		
	}

	@Override
	public int like(int id) {
		return 0;
	}
	
}
