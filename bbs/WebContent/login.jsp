<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<%@ include file="links.jsp" %>
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

	<FORM name="loginForm" action="<%=request.getContextPath() %>/user.s" method="post" id="form">
		<font color="red">${msg }</font>
	    <input type="hidden" name="op" value="login" />
		<br />用户名 &nbsp;
		<INPUT class="easyui-textbox" tabIndex="1" type="text"
			maxLength="20" size="40" name="uname"> <br/>
			<br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码 &nbsp;<INPUT
			class="easyui-passwordbox" tabIndex="2" type="password" maxLength="20" size="40"
			name="upass"> <br/><br/>验&nbsp;证&nbsp;码&nbsp;
	<input class="easyui-textbox" type="text" name="val_code" maxLength="21" size="23"/>
	<img id="image01" src="image.jsp"/>
	<a href="javascript:void(0)"  onclick="changeImage()">看不清</a>
	<br/><br/>			
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="form.submit()">登录</a>					 
	</FORM>
</DIV>

<%@ include file="bottom.jsp"%>