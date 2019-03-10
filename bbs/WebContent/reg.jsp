<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<TITLE>论坛--注册</TITLE>
<%@ include file="links.jsp" %>
<Link rel="stylesheet" type="text/css" href="style/style.css"/>
<script src="js/jquery.min.js"></script>
</HEAD>
<BODY>

<!--      用户信息、登录、注册        -->

	<%@ include file="header.jsp"%>


<BR/>
<!--      导航        -->
<DIV>
	&gt;&gt;<B><a href="index.jsp">论坛首页</a></B>
</DIV>
<!--      用户注册表单        -->
<DIV  class="t" style="MARGIN-TOP: 15px" align="center" id="form">
	<FORM name="regForm" action="user.s" method="post">
		<input type="hidden" name="op" value="reg">
		<br/>
		<br/>用&nbsp;&nbsp;户&nbsp;&nbsp;名 &nbsp;
			<INPUT class="easyui-textbox" tabIndex="1" type="text"
			maxLength="20" size="40" name="uname" id="uname">
		<br/><br/>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 &nbsp;
			
			<INPUT
			class="easyui-passwordbox" tabIndex="2" type="password" maxLength="20" size="40"
			name="upass" id="upass">
		<br/><br/>重复密码 &nbsp;
			<INPUT
			class="easyui-passwordbox" tabIndex="2" type="password" maxLength="20" size="40"
			name="upass1" id="upass1">
		<br/>性别 &nbsp;
			女<input type="radio" name="gender" value="1">
			男<input type="radio" name="gender" value="2" checked="checked" />
		<br/>请选择头像 <br/>
		<img src="image/head/1.gif"/><input type="radio" name="head" value="1.gif" checked="checked">
		<img src="image/head/2.gif"/><input type="radio" name="head" value="2.gif">
		<img src="image/head/3.gif"/><input type="radio" name="head" value="3.gif">
		<img src="image/head/4.gif"/><input type="radio" name="head" value="4.gif">
		<img src="image/head/5.gif"/><input type="radio" name="head" value="5.gif">
		<BR/>
		<img src="image/head/6.gif"/><input type="radio" name="head" value="6.gif">
		<img src="image/head/7.gif"/><input type="radio" name="head" value="7.gif">
		<img src="image/head/8.gif"/><input type="radio" name="head" value="8.gif">
		<img src="image/head/9.gif"/><input type="radio" name="head" value="9.gif">
		<img src="image/head/10.gif"/><input type="radio" name="head" value="10.gif">
		<BR/>
		<img src="image/head/11.gif"/><input type="radio" name="head" value="11.gif">
		<img src="image/head/12.gif"/><input type="radio" name="head" value="12.gif">
		<img src="image/head/13.gif"/><input type="radio" name="head" value="13.gif">
		<img src="image/head/14.gif"/><input type="radio" name="head" value="14.gif">
		<img src="image/head/15.gif"/><input type="radio" name="head" value="15.gif">
		<br/>
					
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="form.submit()">注册</a>
	</FORM>
</DIV>
<!--      声明        -->
<BR>
<%@ include file="foot.jsp" %>
	<script  type="text/javascript">
		var flag=true; 
		$(function(){
			$("#upass1").blur(function(){
				if($("#upass").val()!=$("#upass1").val()){
					alert("两次输入的密码不一致");
					flag=false;
				}
			});
			
			$("#reg").click(function(){
				if($("#upass").val()!=$("#upass1").val()){
					alert("两次输入的密码不一致");
					flag=false;
				}
				return flag;
			})
			
			$("#uname").blur(function(){
				$.ajax({
					async:true,
					method:"post",
					url:"user.s?op=judge",
					data:{"uname":$("#uname").val()},
					dataType:"text",
					success:function(data){
						if(data.trim()=="no"){
							alert("用户名已存在");
							flag=false;
						}else{
							flag=true;
						}
					},
					error:function(){
						alert("服务器异常,注册失败!");
						return false;
					}
				})
			});
		})
		
	</script>
</BODY>
</HTML>
