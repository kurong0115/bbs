package com.yc.biz.impl;


import java.util.List;
import java.util.Map;

import com.yc.bean.TblUser;
import com.yc.dao.UserDao;
import com.yc.utils.DBHelper;
import com.yc.utils.DBUtil;
import com.yc.utils.Encrypt;
import com.yc.utils.MyUtils;

public class UserBizImpl {
	
	private DBHelper db=new DBHelper();
	private UserDao ud=new UserDao();
	/**
	 * 
	 * @param user:  uname ,upass
	 * @return  user: 
	 */
	public TblUser login( TblUser user) {
		if(  user.getUname()==null ||"".equals(user.getUname())) {
			throw new RuntimeException("user name should not be empty");
		}
		String pwd=Encrypt.md5(  Encrypt.md5(user.getUpass()) );
		List<Map<String,Object>> list = db.find("select * from tbl_user where uname=? and upass=?", user.getUname(),pwd);
		List<TblUser> javaBean = MyUtils.ListMapToJavaBean(list, TblUser.class);
		return javaBean.get(0);
	}
	
	public int reg(TblUser user) {
		String sql="insert into tbl_user(uname,upass,head,regtime,gender) values(?,?,?,now(),?);";
		String pwd=Encrypt.md5(Encrypt.md5(user.getUpass()));
		return new DBHelper().update(sql, user.getUname(),pwd,user.getHead(),user.getGender());
	}
	
	public TblUser isUnameExists(String uname) {
		String sql="select count(*) from tbl_user where uname=?";
		TblUser user = DBUtil.get(TblUser.class, sql, uname);
		return user;
	}
	
	public boolean isExists(String username) {
		String sql="select * from tbl_user where uname=?";
		List<Map<String,Object>> list = new DBHelper().find(sql, username);
		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}

	public List<Map<String, Object>> query() {
		return ud.query();
	}
}
