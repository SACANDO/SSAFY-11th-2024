package com.ssafy.ws.model.dto;

import java.sql.SQLException;
import java.util.Date;


public class User {
	private int userSeq;
	private String id; //not null
	private String userPwd; // not null
	private String userName; // 그냥 넣어
	private String nickname;
	private String email;
	private int userRank;
	private Date joinedAt;

	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", id=" + id + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", userRank=" + userRank + ", joinedAt=" + joinedAt + "]";
	}

	public User(int userSeq, String id, String userPwd, String userName, String nickname, String email, int userRank,
			Date joinedAt) {
		super();
		this.userSeq = userSeq;
		this.id = id;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickname = nickname;
		this.email = email;
		this.userRank = userRank;
		this.joinedAt = joinedAt;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() throws SQLException, NumberFormatException{
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserRank() {
		return userRank;
	}

	public void setUserRank(int userRank) {
		this.userRank = userRank;
	}

	public Date getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}

}
