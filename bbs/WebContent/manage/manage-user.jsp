<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%">
<head>
<script type="text/javascript">
	
</script>
<meta charset="UTF-8">
<title>后台管理</title>
<%@ include file="../links.jsp" %>
</head>
<body id="cc" class="easyui-layout" style="width:100%;height:100%;">
	    <div data-options="region:'north'" style="height:100px;"></div>	      
    	<div id="tt"   data-options="region:'center',title:'用户面板'" style="padding:5px;background:#eee;height:100%">
		    <table class="easyui-datagrid" style="height:100%"
   	 			data-options="url:'user.s?op=query',fitColumns:true,singleSelect:true">
    			<thead>
					<tr>
						<th data-options="field:'uid',width:100">编号</th>
						<th data-options="field:'uname',width:100">用户名</th>
						<th data-options="field:'head',width:100,formatter:getHeadDisplay">头像</th>
						<th data-options="field:'regtime',width:100,formatter:getRegTimeDisplay">注册时间</th>
						<th data-options="field:'gender',width:100,formatter:getGenderDisplay">性别</th>
					</tr>
    			</thead>
			</table>		
	    </div>

<script type="text/javascript">
	function getHeadDisplay(value,row,index){
		return '<img src="image/head/'+value+'">';
	}
	function getRegTimeDisplay(value,row,index){
		var date=new Date(value);
		return date.toLocaleString();
	}
	function getGenderDisplay(value,row,index){
		if(value=="2"){
			return "男";
		}
		if(value=="1"){
			return "女";
		}
	}
</script>
</body>
</html>