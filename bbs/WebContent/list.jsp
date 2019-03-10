<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<TITLE>论坛--帖子列表</TITLE>
<%@ include file="links.jsp" %>
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>
<%@ include file="header.jsp" %>


<!--      主体        -->
<DIV>
<!--      导航        -->
<br/>
<%@ include file="nav.jsp"%>
<br/>
<!--      新帖        -->
	<DIV>
		<A href="post.jsp?boardid=${param.boardid }"><IMG src="image/post.gif" name="td_post" border="0" id=td_post></A>
	</DIV>
<!--         翻 页         -->
	<DIV>
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</DIV>

	<DIV class="t">
		<TABLE style="width:100%;" >		
			<TR>
				<TH class="h" style="WIDTH: 100%" colSpan="4"><SPAN>&nbsp;</SPAN></TH>
			</TR>
<!--       表 头           -->
			<TR class="tr2">
				<TD>&nbsp;</TD>
				<TD style="WIDTH: 80%" align="center">文章</TD>
				<TD style="WIDTH: 10%" align="center">作者</TD>
				<TD style="WIDTH: 10%" align="center">回复</TD>
			</TR>
<!--         主 题 列 表        -->
			<c:forEach items="${data }" var="i">
				<TR class="tr3">
					<TD><IMG src="image/topic.gif" border=0></TD>
					<TD style="FONT-SIZE: 15px">
						<A href="topic.s?op=detail&topicid=${i.topicid }">${i.title }</A>
					</TD>
					<TD align="center">${i.uname }</TD>
					<c:if test="${i.count ==null}"><TD align="center">0</TD></c:if>
					<c:if test="${i.count !=null}"><TD align="center">${i.count }</TD></c:if>
				</TR>
			</c:forEach>
			
			
		</TABLE>
	</DIV>
<!--            翻 页          -->
	<DIV>
		<a href="list.html">上一页</a>|
		<a href="list.html">下一页</a>
	</DIV>
</DIV>
<!--             声 明          -->
<BR/>
<%@ include file="foot.jsp" %>
</BODY>
</HTML>
