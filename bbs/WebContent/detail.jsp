<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<TITLE>论坛--看贴</TITLE>
<%@ include file="links.jsp" %>
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>
<%@ include file="header.jsp"%>

<!--      主体        -->
<DIV><br/>
	<!--      导航        -->
<DIV>
	&gt;&gt;<B><a href="index.s">论坛首页</a></B>&gt;&gt;
	<B><a href="list.html">灌水乐园</a></B>
</DIV>
	<br/>
	<!--      回复、新帖        -->
	<DIV>
		<A href="reply.jsp?topicid=${data[0].topicid }"><IMG src="image/reply.gif"  border="0" id=td_post></A> 
		<A href="post.html"><IMG src="image/post.gif"   border="0" id=td_post></A>
	</DIV>
	<!--         翻 页         -->
	<DIV>
		<a href="detail.html">上一页</a>|
		<a href="detail.html">下一页</a>
	</DIV>
	<!--      本页主题的标题        -->
	<DIV>
		<TABLE style="width:100%;">
			<TR>
				<TH class="h">本页主题: 灌水</TH>
			</TR>
			<TR class="tr2">
				<TD>&nbsp;</TD>
			</TR>
		</TABLE>
	</DIV>
	
	<!--      主题        -->
	<c:forEach items="${data }" var="i">
		<DIV class="t">
			<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed;width:100%;" >
				<TR class="tr1">
					<TH style="WIDTH: 20%">
						<B>${i.uname }</B><BR/>
						<img src="image/head/${i.head }"/><BR/>
						注册:<fmt:formatDate value="${i.regtime }" pattern="yyyy-MM-dd"/><BR/>
					</TH>
					<TH>
						<H4>${i.title }</H4>
						<DIV>${i.content }</DIV>
						<DIV class="tipad gray">
							发表：[<fmt:formatDate value="${i.publishtime }"  pattern="yyyy-MM-dd HH:mm"/>] &nbsp;
							最后修改:[<fmt:formatDate value="${i.modifytime }"  pattern="yyyy-MM-dd HH:mm"/>]
						</DIV>
					</TH>
				</TR>
			</TABLE>
		</DIV>
	</c:forEach>
	<!--      回复        -->
	
	
	
	
	
</DIV>

<!--      声明        -->
<BR>
<%@ include file="foot.jsp" %>
</BODY>
</HTML>

