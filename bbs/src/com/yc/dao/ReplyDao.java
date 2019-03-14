package com.yc.dao;

import com.yc.bean.TblReply;
import com.yc.utils.DBHelper;

public class ReplyDao {
	
	/**
	 * 将帖子添加到回复列表
	 * @param reply
	 * @return
	 */
	public int insert(TblReply reply) {
		String sql="insert into tbl_reply values(null,?,?,?,?,?,?)";
		return new DBHelper().update(sql, reply.getTitle(),reply.getContent(),reply.getPublishtime(),null,reply.getUid(),reply.getTopicid());
	}

}
