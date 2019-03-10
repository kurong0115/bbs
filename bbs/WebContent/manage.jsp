<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%">
<head>
<script type="text/javascript">
	function openUserTab(){
		var tab=$("#tt").tabs("getTab","用户管理");
		
		if(tab==null){
			$("#tt").tabs("add",
				{
					title:"用户管理",
					selected:true,
					closable:true,
					href:"manage-user.jsp"
				}		
			);
		}else{
			$("#tt").tabs("select","用户管理");
		}
	}
</script>
<meta charset="UTF-8">
<title>后台管理</title>
<%@ include file="links.jsp" %>
</head>
<body id="cc" class="easyui-layout" style="width:100%;height:100%;">
	    <div data-options="region:'north'" style="height:100px;"></div>
	    <div data-options="region:'south'" style="height:100px;"></div>	    
    	<div id="aa" class="easyui-accordion" style="width:12%;height:100%;" data-options="region:'west',title:'West'">
		    <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
				<a href="#" class="easyui-linkbutton c1" style="width:100%" onclick="openUserTab()" >用户管理</a>
				<a href="#" class="easyui-linkbutton c1" style="width:100%" onclick="" >主题管理</a>
		    </div>
		    <div title="Title2" data-options="iconCls:'icon-reload'" style="padding:10px;">
				content2
		    </div>
		    <div title="Title3">
				content3
		    </div>
		</div>    
    	<div id="tt" class="easyui-tabs"  data-options="region:'center',title:'主面板'" style="padding:5px;background:#eee;">
		    <div title="Tab1" style="padding:20px;display:none;">
				tab1
		    </div>
		    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
				tab2
		    </div>
		    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">
				tab3
		    </div>		
	    </div>

</body>
</html>