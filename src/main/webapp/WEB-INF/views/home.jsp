<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/static/core/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="cc" class="easyui-layout" fit=true style="width:100%;height:100%;">  
		<div data-options="region:'north',border:false" style="height:60px;padding:10px">
			<h1>我的钱包${pageContext.request.contextPath}</h1>
		</div>
		
		<div data-options="region:'west',split:true,title:'导航菜单'" style="width:250px;padding:0px;">
			<div id="aa" class="easyui-accordion" fit=true border="true">  
			    
			    <div title="系统管理"  selected="true" style="overflow:auto;padding:10px;">  
					<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,lines:true"></ul>
			    </div>  
			    
			    <div title="用户管理" style="overflow:auto;padding:10px;">  
			    	<a id="aa" onclick="addTab('用户管理列表','datagrid.jsp')" title="jsp/001_message.jsp">用户列表</a> <br/>
			    	<a title="jsp/002_window.jsp" >用户功能</a> 
			    </div>  
			    <div title="岗位管理"  style="padding:10px;">  
			    	<a href="#" onclick="addTab('用户管理列表','${pageContext.request.contextPath}/securityuser/list')">用户管理列表</a>
			    </div>  
			</div>  
		</div>
		
		<div data-options="region:'south',border:true" style="height:50px;padding:10px;">south region</div>
		
		<div data-options="region:'center'" id="tt" class="easyui-tabs" border = "true">
			<div title="Home">
				
			</div>
		</div>
	</div>
</body>
</html>