package com.yc.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;


import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 工具类
 * @author Administrator
 *
 */
public class MyUtils {
	public static String code;
	/**
	 * 借助于fastJSON工具把Map<String, String[]>转成javaBean
	 * @param mapStrArr	包含所有请求参数的map集合
	 * @param t	javaBean类型
	 * @return
	 */
	public static<T> T mapToJavaBean(Map<String, String[]> mapStrArr,Class<T> t){
		//把Map<String,String[]>转成Map<String,String>
		Set<Entry<String, String[]>> entrySet = mapStrArr.entrySet();
		Map<String,String> map = new HashMap<String, String>();
		for (Entry<String, String[]> entry : entrySet) {
			map.put(entry.getKey(), entry.getValue()[0]);
		}		
		//把map对象转成json字符串
		String strJson = JSON.toJSONString(map);
		//把json字符串转成JSONObject对象
		JSONObject json = JSONObject.parseObject(strJson);
		//把JSONObject对象转成javaBean并添加到集合
		return JSON.toJavaObject(json,t);
	}
	
	
	/**
	 * 借助于fastJSON工具把List<Map>转List<javaBase>对象
	 * @param mList DBHelper工具从数据库查询返回的对象
	 * @param t	javaBase的类型
	 * @return
	 */
	public static<T> List<T> ListMapToJavaBean(List<Map<String, Object>> mList,Class<T> t) {
		List<T> tList = new ArrayList<T>();
		for (Map<String, Object> map : mList) {
			 //把map对象转成json字符串
			String strJson = JSON.toJSONString(map);
			//把json字符串转成JSONObject对象
			JSONObject json = JSONObject.parseObject(strJson);
			//把JSONObject对象转成javaBean并添加到集合
			tList.add(JSON.toJavaObject(json, t));
		}
		return tList;
	}
	
	/**
	 * 验证功能
	 * @param session
	 * @return
	 */
	public static BufferedImage createImageCode(HttpSession session) {
	    //创建图片缓冲对象
	    BufferedImage bi = new BufferedImage(68, 22,BufferedImage.TYPE_INT_RGB);
	    //通过图片缓冲对象获取画笔
	    Graphics g = bi.getGraphics();
	    //设置画笔颜色(默认是白色)
	    g.setColor(new Color(200,188,255));
	    //把颜色填充到画布指定位置和大小
	    g.fillRect(0,0,68,22);

	    //创建一个随机对象
	    Random r = new Random();
	    //随机产生干扰线，使图象中的认证码不易被其它程序探测到。   
	    g.setColor(Color.BLACK);   
	    for (int i = 0; i < 50; i++) {
	        int x = r.nextInt(68);   
	        int y = r.nextInt(22);   
	        int xl = r.nextInt(5);   
	        int yl = r.nextInt(5);
	        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	        //x,y 为起点的坐标,x + xl, y + yl为终点的坐标
	        g.drawLine(x, y, x + xl, y + yl);   
	    }   


	    //准备一个字符数组（用于随机生成的验证码字符）
	    char[] c = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();
	    //用于存放生成的验证码字符
	    StringBuffer s = new StringBuffer();
	    //随机生成4个字符
	    for(int i = 0,len = c.length;i < 4;i++) {
	        //获取随机下标
	        int index = r.nextInt(len);
	        //设置画笔颜色
	        g.setColor(new Color(r.nextInt(80),r.nextInt(150),r.nextInt(200)));
	        //把字符画到画布指定的位置
	        g.drawString(c[index]+"",4+i*15,18);
	        //把生成的字符存到字符串缓冲区备用
	        s.append(c[index]);
	    }
	    session.setAttribute("code",s.toString());
	    return bi;
	}
	
	/**
	 * 生成一个图片验证码,供邮箱使用
	 * @return
	 */
	public static String createCode() {
		StringBuffer str=new StringBuffer();
		Random r=new Random();
		for(int i=0;i<6;i++) {
			str.append(r.nextInt(10));
		}
		code=str.toString();
		return str.toString();
	}
}
