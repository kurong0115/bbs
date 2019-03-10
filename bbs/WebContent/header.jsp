<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<TITLE>论坛--登录</TITLE>
<Link rel="stylesheet" type="text/css" href="style/style.css" />

</HEAD>

<BODY>
	<DIV>
		<IMG src="image/logo.gif">
	</DIV>
	<!--      用户信息、登录、注册        -->

	<DIV class="h">
		<c:if test="${user==null }">
			您尚未 <a href="login.jsp">登录</a> &nbsp;| &nbsp; 
		</c:if>
		<c:if test="${user!=null }">
			欢迎${user.uname }
		</c:if>
		<A href="reg.jsp">注册</A>		|
	</DIV>
	<BR />