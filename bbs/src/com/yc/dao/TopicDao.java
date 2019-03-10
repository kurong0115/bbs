package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.TblTopic;
import com.yc.utils.DBHelper;

public class TopicDao {
	
	private DBHelper db=new DBHelper();
	
	public List<Map<String, Object>> query(String boardId) {
		String sql="SELECT\n" +
				"	a.count,\n" +
				"	b.*\n" +
				"FROM\n" +
				"	(\n" +
				"		SELECT\n" +
				"			count(*) count,\n" +
				"			topicid\n" +
				"		FROM\n" +
				"			tbl_reply\n" +
				"		GROUP BY\n" +
				"			topicid\n" +
				"	) a\n" +
				"right JOIN (\n" +
				"	SELECT\n" +
				"		a.uname,\n" +
				"		b.*\n" +
				"	FROM\n" +
				"		tbl_user a\n" +
				"	JOIN tbl_topic b ON a.uid = b.uid\n" +
				"	WHERE\n" +
				"		b.boardid = ?\n" +
				") b ON a.topicid = b.topicid";
		return db.find(sql, boardId);
	}

	public int insert(TblTopic topic) {
		String sql="insert into tbl_topic values(null,?,?,?,?,?,?)";
		return db.update(sql, topic.getTitle(),topic.getContent(),topic.getPublishtime(),null,topic.getUid(),topic.getBoardid());
	}
	
	public List<Map<String, Object>> selectByDetail(String topicid) {
		String sql="SELECT\n" +
				"	a.*, b.uname,\n" +
				"	b.head,\n" +
				"	b.regtime\n" +
				"FROM\n" +
				"	tbl_topic a\n" +
				"JOIN tbl_user b ON a.uid = b.uid\n" +
				"WHERE\n" +
				"	a.topicid = ?\n" +
				"UNION ALL\n" +
				"	SELECT\n" +
				"		a.*, b.uname,\n" +
				"		b.head,\n" +
				"		b.regtime\n" +
				"	FROM\n" +
				"		tbl_reply a\n" +
				"	JOIN tbl_user b ON a.uid = b.uid\n" +
				"	WHERE\n" +
				"		a.topicid = ?";
		return db.find(sql, topicid,topicid);
	}
	
}
