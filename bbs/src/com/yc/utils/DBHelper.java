package com.yc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBHelper {
	static {
		try {
			//加载驱动
			Class.forName(ConfigManager.getInstance().getProperty("driverClass"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 * @throws SQLException 
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(ConfigManager.getInstance().getProperty("url"),ConfigManager.getInstance());
//		return BaseDao.getConnection();
	}
	
	/**
	 * 关闭资源的方法1
	 * @param con
	 * @param ps
	 * @param rs
	 */
	public void close(Connection con,PreparedStatement ps,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭资源的方法2
	 * @param con
	 * @param ps
	 */
	public void close(Connection con,PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 给预编译语句中的占位符赋值1
	 * @param ps
	 * @param params
	 * @throws SQLException
	 */
	public void setParams(PreparedStatement ps,Object...params) throws SQLException {
		if(params != null && params.length>0) {
			for(int i = 0,len = params.length;i<len;i++) {
				ps.setObject(i+1, params[i]);
			}
		}
	}
	
	/**
	 * 给预编译语句中的占位符赋值2
	 * @param ps
	 * @param params
	 * @throws SQLException
	 */
	public void setParams(PreparedStatement ps,List<Object> params) throws SQLException {
		if(params != null && params.size()>0) {
			for(int i = 0,len=params.size();i<len;i++) {
				ps.setObject(i+1, params.get(i));
			}
		}
	}
	
	/**
	 * 增删改通用方法1
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object...params) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//获取连接
			con = this.getConnection();
			//预编译sql语句块
			ps = con.prepareStatement(sql);
			//设置预编译语句参数
			this.setParams(ps, params);
			//执行语句返回结果
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//释放资源
			this.close(con, ps);
		}
		return 0;
	}
	
	/**
	 * 增删改通用方法2
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,List<Object> params) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//获取连接
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			this.setParams(ps, params);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, ps);
		}
		return 0;
	}

	/**
	 * 查询方法1
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> find(String sql,Object...params){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			//获取连接
			con = this.getConnection();
			//预编译sql语句块
			ps = con.prepareStatement(sql);
			//设置预编译语句参数
			this.setParams(ps, params);
			//执行语句返回结果集
			rs = ps.executeQuery();
			
			//获取数据库表元数据（数据表结构相关信息）
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取数据表的列数
			int colCount = rsmd.getColumnCount();
			//处理结果集
			while(rs.next()) {
				Map<String,Object> map = new HashMap<>();
				for(int i = 0;i<colCount;i++) {
					//getColumnName():可以获取到指定位置列名
					map.put(rsmd.getColumnName(i+1).toLowerCase(),rs.getObject(rsmd.getColumnName(i+1)));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, ps,rs);
		}
		return list;
	}
	
	/**
	 * 查询方法2
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> find(String sql,List<Object> params){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			//获取连接
			con = this.getConnection();
			//预编译sql语句块
			ps = con.prepareStatement(sql);
			//设置预编译语句参数
			this.setParams(ps, params);
			//执行语句返回结果集
			rs = ps.executeQuery();
			
			//获取数据库表元数据（数据表结构相关信息）
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取数据表的列数
			int colCount = rsmd.getColumnCount();
			//处理结果集
			while(rs.next()) {
				Map<String,Object> map = new HashMap<>();
				for(int i = 0;i<colCount;i++) {
					//getColumnName():可以获取到指定位置列名
					map.put(rsmd.getColumnName(i+1).toLowerCase(),rs.getObject(rsmd.getColumnName(i+1)));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, ps,rs);
		}
		return list;
	}
}
