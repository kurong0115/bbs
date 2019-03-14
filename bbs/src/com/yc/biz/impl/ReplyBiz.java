package com.yc.biz.impl;

import com.yc.bean.TblReply;
import com.yc.dao.ReplyDao;

/**
 * 
 * @author Administrator
 *
 */
public class ReplyBiz {
	
	private ReplyDao rd=new ReplyDao();
	
	/**
	 * 用户帖子的回复
	 * @param reply
	 * @throws BizException
	 */
	public void reply(TblReply reply) throws BizException {
		if(reply.getTitle().length()<2) {
			throw new BizException("标题不能少于两个字符");
		}
		if(reply.getContent().length()<10) {
			throw new BizException("内容不能少于10个字符");
		}
		rd.insert(reply);
	}
	

}
