package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.utils.DBHelper;

public class UserDao {
	private DBHelper db=new DBHelper();
	
	public List<Map<String,Object>> query() {
		String sql="select * from tbl_user";
		return db.find(sql);
	}
}
