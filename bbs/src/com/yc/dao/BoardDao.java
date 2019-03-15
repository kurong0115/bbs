package com.yc.dao;

import java.util.List;
import java.util.Map;


import com.yc.utils.DBHelper;


public class BoardDao {
	private DBHelper db=new DBHelper();
	
	/**
	 * 查询主页的数据
	 * @return
	 */
	public List<Map<String,Object>> queryIndex() {
		String sql="SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	(\n" +
				"		SELECT\n" +
				"			a.boardname pname,\n" +
				"			b.boardname cname,\n" +
				"			c.cnt,\n" +
				"			d.*, e.uname\n" +
				"		FROM\n" +
				"			tbl_board a\n" +
				"		LEFT JOIN tbl_board b ON a.boardid = b.parentid\n" +
				"		LEFT JOIN (\n" +
				"			SELECT\n" +
				"				boardid,\n" +
				"				count(*) cnt\n" +
				"			FROM\n" +
				"				tbl_topic\n" +
				"			GROUP BY\n" +
				"				boardid\n" +
				"		) c ON b.boardid = c.boardid\n" +
				"		LEFT JOIN (\n" +
				"			SELECT\n" +
				"				*\n" +
				"			FROM\n" +
				"				tbl_topic a\n" +
				"			JOIN (\n" +
				"				SELECT\n" +
				"					max(topicid) maxid\n" +
				"				FROM\n" +
				"					tbl_topic\n" +
				"				GROUP BY\n" +
				"					boardid\n" +
				"			) b ON a.topicid = b.maxid\n" +
				"		) d ON b.boardid = d.boardid\n" +
				"		LEFT JOIN tbl_user e ON d.uid = e.uid\n" +
				"		WHERE\n" +
				"			a.parentid = 0\n" +
				"	) a;";
				
		return db.find(sql);
	}
	
	
}
