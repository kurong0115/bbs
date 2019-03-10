<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>

<script type="text/javascript">
function changeImage(){
	document.getElementById("image01").src="image.jsp?" + new Date();
}

</script>

<!--      导航        -->
<DIV>
	&gt;&gt;<B><a href="index.jsp">论坛首页</a></B>
</DIV>
<!--      用户登录表单        -->
<DIV class="t" style="MARGIN-TOP: 15px" align="center">

	<FORM name="loginForm" action="<%=request.getContextPath() %>/user.s" method="post">
		<font color="red">${msg }</font>
	    <input type="hidden" name="op" value="login" />
		<br />用户名 &nbsp;
		<INPUT class="input" tabIndex="1" type="text"
			maxLength="20" size="35" name="uname" required="required"> <br />
			密 码 &nbsp;<INPUT
			class="input" tabIndex="2" type="password" maxLength="20" size="40"
			name="upass" required="required"> <br />
			验证码：
	<input type="text" name="val_code" />
	<img id="image01" src="image.jsp"/>
	<a href="javascript:void(0)"  onclick="changeImage()">看不清</a>
	<br/>
			
			
			
			 <INPUT class="btn" tabIndex="6"
			type="submit" value="登 录">
	</FORM>

</DIV>

<%@ include file="bottom.jsp"%>