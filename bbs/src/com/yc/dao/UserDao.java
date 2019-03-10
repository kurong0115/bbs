package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.TblUser;
import com.yc.utils.DBHelper;
import com.yc.utils.Encrypt;
import com.yc.utils.MyUtils;

public class UserDao {
	private DBHelper db=new DBHelper();
	
	/**
	 * 后台管理界面查询用户的所有信息
	 * @return
	 */
	public List<Map<String,Object>> query() {
		String sql="select * from tbl_user";
		return db.find(sql);
	}
	
	/**
	 * 用户登录
	 * @param uname
	 * @param upass
	 * @return
	 */
	public TblUser login(String uname,String upass) {
		String sql="select * from tbl_user where uname=? and upass=?";
		List<Map<String,Object>> list = db.find(sql, uname,upass);		
		return (TblUser) MyUtils.ListMapToJavaBean(list, TblUser.class);		
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public int reg(TblUser user) {
		String sql="insert into tbl_user(uname,upass,head,regtime,gender) values(?,?,?,now(),?);";
		String pwd=Encrypt.md5(Encrypt.md5(user.getUpass()));
		return new DBHelper().update(sql, user.getUname(),pwd,user.getHead(),user.getGender());
	}
	
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean isExists(String username) {
		String sql="select * from tbl_user where uname=?";
		List<Map<String,Object>> list = new DBHelper().find(sql, username);
		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}
}
