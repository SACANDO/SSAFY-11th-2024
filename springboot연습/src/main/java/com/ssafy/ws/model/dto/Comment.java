package com.ssafy.ws.model.dto;

import java.util.Date;

public class Comment {
	private int id;
	private String content;
	private int user_seq;
	private int article_id;
	private int board_id;
	private int lft;
	private int rgt;
	private int depth;
	private Date created_at;

	public Comment(int id, String content, int user_seq, int article_id, int board_id, int lft, int rgt, int depth,
			Date created_at) {
		super();
		this.id = id;
		this.content = content;
		this.user_seq = user_seq;
		this.article_id = article_id;
		this.board_id = board_id;
		this.lft = lft;
		this.rgt = rgt;
		this.depth = depth;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public int getLft() {
		return lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getRgt() {
		return rgt;
	}

	public void setRgt(int rgt) {
		this.rgt = rgt;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

}
