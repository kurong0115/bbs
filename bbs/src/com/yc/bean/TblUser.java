package com.yc.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class TblUser implements Serializable {
	private static final long serialVersionUID = -4750369623346428567L;

	private String uid;
	private String uname;
	private String upass;
	private String head;
	private Timestamp regtime;
	private Integer gender;
	private Timestamp starttime;
	private Timestamp endtime;
	private Integer time;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}
	

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Timestamp getRegtime() {
		return regtime;
	}

	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}

	

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	
	
	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public TblUser(String uid, String uname, String upass, String head,
			Timestamp regtime, int gender) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.head = head;
		this.regtime = regtime;
		this.gender = gender;
	}

	public TblUser() {
		super();
	}

	@Override
	public String toString() {
		return "TblUser [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", head=" + head + ", regtime="
				+ regtime + ", gender=" + gender + ", starttime=" + starttime + ", endtime=" + endtime + ", time="
				+ time + "]";
	}

	

}
