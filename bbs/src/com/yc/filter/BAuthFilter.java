package com.yc.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.TblUser;


@WebFilter(urlPatterns= {"/post.jsp","/reply.jsp"})
public class BAuthFilter implements Filter {

    public BAuthFilter() {
        
    }
	
	public void destroy() {
		
	}

	/**
	 * 判断是否登录,如未登录则转到登录界面,登陆成功后返回上一个界面
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		TblUser user=(TblUser)req.getSession().getAttribute("user");
		
		
		//判断登录状态
		if(user==null) {
			//获取请求的urlַ
			String uri=req.getRequestURI();
			System.out.println(uri);
			//获取请求参数
			Map<String, String[]> map = req.getParameterMap();
			//将数据保存--->session
			Map<String,String[]> newmap=new HashMap<>();
			newmap.putAll(map);
			req.getSession().setAttribute("callback-url", uri);
			req.getSession().setAttribute("callback-map", newmap);
			req.setAttribute("msg", "请先登录");
			req.getRequestDispatcher("login.jsp").forward(req, res);			
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
