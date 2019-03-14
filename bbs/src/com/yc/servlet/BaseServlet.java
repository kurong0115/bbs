package com.yc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *    公共Servlet父类
 * @author Administrator
 *
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BaseServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取op字段
		String op=request.getParameter("op");
		//获取op的值调用相对应的方法
		Class<?>[] clazz=new Class<?>[] {
			HttpServletRequest.class,HttpServletResponse.class
		};
		//获取op对应的方法
		try {
			Method m = this.getClass().getMethod(op, clazz);	
			//通过反射调用此方法
			m.invoke(this, request,response);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
