package com.yc.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.TblReply;
import com.yc.bean.TblUser;
import com.yc.biz.impl.BizException;
import com.yc.biz.impl.ReplyBiz;
import com.yc.utils.MyUtils;


@WebServlet("/reply.s")
public class ReplyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ReplyBiz rb=new ReplyBiz();
       
	public void reply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		TblReply reply = MyUtils.mapToJavaBean(parameterMap, TblReply.class);
		TblUser user=(TblUser) request.getSession(true).getAttribute("user");
		reply.setPublishtime(new Timestamp(System.currentTimeMillis()));	
		reply.setUid(user.getUid());
		System.out.println(reply);
		
		try {
			rb.reply(reply);
			response.sendRedirect("topic.s?op=detail&topicid="+reply.getTopicid());
		} catch (BizException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("reply.jsp").forward(request, response);;
			return;
		}
	}

}
