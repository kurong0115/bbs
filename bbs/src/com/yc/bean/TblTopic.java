package com.yc.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class TblTopic implements Serializable {
	private static final long serialVersionUID = -4666196229407434784L;
	private Integer topicid;
	private String title;
	private String content;
	private Timestamp publishtime;
	private Timestamp modifytime;
	private String uid;
	private Integer boardid;

	public Integer getTopicid() {
		return topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setBoardid(Integer boardid) {
		this.boardid = boardid;
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

	public Timestamp getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Timestamp publishtime) {
		this.publishtime = publishtime;
	}

	public Timestamp getModifytime() {
		return modifytime;
	}

	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public TblTopic() {
		super();
	}

	@Override
	public String toString() {
		return "TblTopic [topicid=" + topicid + ", title=" + title + ", content=" + content + ", publishtime="
				+ publishtime + ", modifytime=" + modifytime + ", uid=" + uid + ", boardid=" + boardid + "]";
	}

}
