package com.yc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yc.bean.TblUser;
import com.yc.biz.impl.UserBizImpl;
import com.yc.utils.MyUtils;


@WebServlet("/user.s")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserBizImpl ubi=new UserBizImpl();
    
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		String val_code=request.getParameter("val_code");
		//判断信息是否为空
		if(uname==null||upass==null||val_code==null) {
			request.setAttribute("msg", "信息不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//判断验证码是否正确
		if(!val_code.equals(request.getSession().getAttribute("rand"))) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		TblUser user=new TblUser();
		user.setUname(uname);
		user.setUpass(upass);
		TblUser tblUser = ubi.login(user);
		//判断用户名是否存在
		if(tblUser==null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", tblUser);
		request.getSession().setMaxInactiveInterval(60*60);
		System.out.println(tblUser);
		String url=(String) request.getSession().getAttribute("callback-url");
		System.out.println("start"+url);		
		@SuppressWarnings("unchecked")
		Map<String,String[]> map = (Map<String,String[]>)request.getSession().getAttribute("callback-map");
		System.out.println(map);
		if(url!=null) {
			url+="?";
			if(map!=null) {
				Set<Entry<String,String[]>> entrySet = map.entrySet();
				for (Entry<String, String[]> entry : entrySet) {
					url+=entry.getKey()+"="+entry.getValue()[0]+"&";
				}
			}			
			System.out.println("final"+url);
			response.sendRedirect(url);
			return;
		}
		response.sendRedirect(request.getContextPath()+"/index.s");
	}

	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String,String[]>> entrySet = parameterMap.entrySet();
		Map<String, String[]> map=new HashMap<>();
		for (Entry<String, String[]> entry : entrySet) {
			if(entry.getKey().equals("op")) {
				continue;
			}
			map.put(entry.getKey(), entry.getValue());
		}
		TblUser user = MyUtils.mapToJavaBean(map, TblUser.class);
		int i = ubi.reg(user);
		if(i>0) {
			response.sendRedirect("index.s");
		}
		System.out.println(i);
		System.out.println(user);
	}
	
	/**
	 * 判断用户是否存在
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void judge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String uname=request.getParameter("uname");
		boolean isExist = ubi.isExists(uname);
		System.out.println(isExist);
		if(isExist) {
			response.getWriter().write("no");
		}else {
			response.getWriter().write("yes");
		}
	}
	
	/**
	 * 后台查询数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<Map<String,Object>> data=ubi.query();
		String json = JSON.toJSONString(data);
		response.getWriter().append(json);
	}
}
