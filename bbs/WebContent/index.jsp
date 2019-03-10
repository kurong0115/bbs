<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<TITLE>论坛</TITLE>
<%@ include file="links.jsp" %>
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>

<%@ include file="header.jsp" %>

<!--      主体        -->
<DIV class="t">
	<TABLE style="width:100%;">
		<TR class="tr2" align="center">
			<TD colSpan="2">论坛</TD>
			<TD style="WIDTH: 10%;">主题</TD>
			<TD style="WIDTH: 30%">最后发表</TD>
		</TR>
	<!--       主版块       -->
		
		<!-- <TR class="tr3">
			<TD colspan="4">.NET技术</TD>
		</TR> -->
	<!--       子版块       -->
	<%
		String currentBoard=null;
	%>
		<c:forEach items="${data }" var="i">
			<!-- <TR class="tr3">
				<TD colspan="4">.NET技术</TD>
			</TR> -->
			<%
				Map<String,Object> i =(Map<String,Object>)pageContext.getAttribute("i");
				String pname=(String)i.get("pname");
			%>
			<%
				if(!pname.equals(currentBoard)){
					currentBoard=pname;
			%>
					<TR class="tr3">
						<TD colspan="4">${i.pname }</TD>
					</TR>
			<% 		
				}
			%>
			<TR class="tr3">
			<TD width="5%">&nbsp;</TD>
			<TH align="left">
				<IMG src="image/board.gif">
				<A href="topic.s?op=list&boardid=${i.boardid }&boardname=${i.cname}">${i.cname }</A>
			</TH>
			<TD align="center">${i.cnt }</TD>
			<TH>
				<SPAN>
					<A href="topic.s?op=detail&topicid=${i.topicid }">${i.title } </A>
				</SPAN>
				<BR/>
				<SPAN>${i.uname }</SPAN>
				<SPAN class="gray">[<fmt:formatDate value="${i.publishtime }"   pattern="yyyy-MM-dd HH:mm"/>]</SPAN>
			</TH>
		</TR>
		</c:forEach>
	</TABLE>
</DIV>

<BR/>
<%@ include file="foot.jsp" %>
</BODY>
</HTML>
