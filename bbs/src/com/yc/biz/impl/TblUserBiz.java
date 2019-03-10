package com.yc.biz.impl;

import com.yc.bean.TblUser;
import com.yc.dao.BoardDao;

public class TblUserBiz {
	private BoardDao bd=new BoardDao();
	
	/**
	 * 业务处理:当数据错误的时候,抛出用户自定义的异常,并且返回对应的错误信息
	 * @param user
	 * @param rePass
	 * @throws BizException
	 */
	public void reg(TblUser user,String rePass) throws BizException {
		if(!user.getUpass().equals(rePass)) {
			throw new BizException("两次密码不一致");
		}
		if(bd.isExists(user.getUname())) {
			throw new BizException("用户名已存在");
		}
		
		bd.reg(user);
	}
	
	public TblUser login(TblUser user) throws BizException {
		TblUser tbluser = bd.login(user.getUname(), user.getUpass());
		if(tbluser==null) {
			throw new BizException("用户名或密码错误");
		}
		return tbluser;
	}
}
