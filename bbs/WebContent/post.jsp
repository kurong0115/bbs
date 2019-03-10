<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
function changeImage(){
	document.getElementById("image01").src="image.jsp?" + new Date();
}

</script>

<!--      导航        -->
<%@ include file="nav.jsp"%>
<!--      用户登录表单        -->
<DIV class="t" style="MARGIN-TOP: 15px" align="center">

	<FORM name="postForm" action="topic.s?op=post" method="post">
		<input type="hidden" name="boardid" value="${param.boardid }">
		<font color="red">${msg }</font>
	    <input type="hidden" name="op" value="post" />
		<br />标题 &nbsp;
		<INPUT class="input" tabIndex="1" type="text"
			maxLength="20" size="35" name="title" value="${param.title }"> <br />
			内容 &nbsp;
			
			<textarea rows="" cols="" id="content" name="content">${param.content }</textarea>
			 <script>            
                CKEDITOR.replace( 'content' );
            </script>
			 <br />
	<br/>
			
			
			
			 <INPUT class="btn" tabIndex="6"
			type="submit" value="发布">
	</FORM>

</DIV>

<%@ include file="bottom.jsp"%>