package com.ssafy.ws.model.dto;

import java.sql.Date;

public class Article {

	private int id;
	private String title;
	private String content;
	private int board_id;
	private int user_seq;
	private int view_cnt;
	private int lft;
	private int rgt;
	private int depth;
	private Date created_at;
	private Date modified_at;
	

	public Article(String title, String content, int board_id, int user_seq, int view_cnt, int lft, int rgt, int depth,
			Date created_at, Date modified_at, int id) {
		super();
		this.title = title;
		this.content = content;
		this.board_id = board_id;
		this.user_seq = user_seq;
		this.view_cnt = view_cnt;
		this.lft = lft;
		this.rgt = rgt;
		this.depth = depth;
		this.created_at = created_at;
		this.modified_at = modified_at;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
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

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

}
