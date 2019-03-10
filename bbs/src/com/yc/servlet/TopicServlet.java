package com.yc.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.TblTopic;
import com.yc.bean.TblUser;
import com.yc.biz.impl.BizException;
import com.yc.biz.impl.TopicBiz;
import com.yc.dao.TopicDao;
import com.yc.utils.MyUtils;


@WebServlet("/topic.s")
public class TopicServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private TopicDao td=new TopicDao();
	private TopicBiz tb=new TopicBiz();
	
	/**
	 * 雷剧当前板块下所有的帖子
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId=request.getParameter("boardid");
		//将板块名保存到session
		String boardname=request.getParameter("boardname");
		HttpSession session = request.getSession();
		session.setAttribute("boardname", boardname);
		session.setAttribute("boardId", boardId);
		List<Map<String,Object>> data=td.query(boardId);
		request.setAttribute("data", data);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	/**
	 * 实现发帖功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		TblTopic topic = MyUtils.mapToJavaBean(parameterMap, TblTopic.class);
		TblUser user=(TblUser) request.getSession(true).getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		topic.setPublishtime(new Timestamp(System.currentTimeMillis()));	
		topic.setUid(user.getUid());
		System.out.println("获取的"+topic);
		
		try {
			tb.post(topic);
			response.sendRedirect("topic.s?op=list&boardid="+topic.getBoardid());
		} catch (BizException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("post.jsp").forward(request, response);;
			return;
		}
	}
	
	/**
	 * 显示贴子的详细信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String topicid=request.getParameter("topicid");
		List<Map<String,Object>> data=tb.selectByDetail(topicid);
		request.setAttribute("data", data);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
