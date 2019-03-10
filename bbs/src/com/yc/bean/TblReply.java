package com.yc.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class TblReply implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5330823786885757520L;
	private Integer replyid;
	private String title;
	private String content;
	private Timestamp publishtime;
	private Timestamp modifytime;
	private String uid;
	private Integer topicid;

	public Integer getReplyid() {
		return replyid;
	}

	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getTopicid() {
		return topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
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

	public TblReply() {
		super();
	}

	private String uname;
	private String head;
	private String regtime;

	@Override
	public String toString() {
		return "Reply [content=" + content + ", modifytime=" + modifytime + ", publishtime=" + publishtime
				+ ", replyid=" + replyid + ", title=" + title + ", topicid=" + topicid + ", uid=" + uid + "]";
	}

}
