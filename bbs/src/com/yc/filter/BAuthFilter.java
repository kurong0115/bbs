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

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		TblUser user=(TblUser)req.getSession().getAttribute("user");
		
		
		//�ж��Ƿ��¼
		if(user==null) {
			//��ȡ�����ַ
			String uri=req.getRequestURI();
			System.out.println(uri);
			//��ȡ�������
			Map<String, String[]> map = req.getParameterMap();
			//�����ַ�Ͳ���--->session
			Map<String,String[]> newmap=new HashMap<>();
			newmap.putAll(map);
			req.getSession().setAttribute("callback-url", uri);
			req.getSession().setAttribute("callback-map", newmap);
			req.setAttribute("msg", "���ȵ�¼");
			req.getRequestDispatcher("login.jsp").forward(req, res);			
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
