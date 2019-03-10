package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.TblUser;
import com.yc.utils.DBHelper;
import com.yc.utils.Encrypt;
import com.yc.utils.MyUtils;

public class BoardDao {
	private DBHelper db=new DBHelper();
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
	
	public TblUser login(String uname,String upass) {
		String sql="select * from tbl_user where uname=? and upass=?";
		List<Map<String,Object>> list = db.find(sql, uname,upass);		
		return (TblUser) MyUtils.ListMapToJavaBean(list, TblUser.class);		
	}
	
	public int reg(TblUser user) {
		String sql="insert into tbl_user(uname,upass,head,regtime,gender) values(?,?,?,now(),?);";
		String pwd=Encrypt.md5(Encrypt.md5(user.getUpass()));
		return new DBHelper().update(sql, user.getUname(),pwd,user.getHead(),user.getGender());
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
}
