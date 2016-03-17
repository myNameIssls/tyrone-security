<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/static/core/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	$(function(){
		
		$("#login-btn").click(function(){
			$("#login-form").submit();
		});


	});
</script>

</head>
<body>
	<div style="position:absolute;top:50%;margin-top:-132px;left:50%;margin-left:-200px;">
		<form id="login-form" method="post" >
		    <div class="easyui-panel" title="Login to system"  style="width:400px;padding:30px 70px 20px 70px;" >
		        <div style="margin-bottom:10px">
		            <input name="username" class="easyui-textbox" value="admin" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
		        </div>
		        <div style="margin-bottom:20px">
		            <input name="password" class="easyui-textbox" value="admin" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
		        </div>
		        <div style="margin-bottom:20px">
		            <input type="checkbox" checked="checked">
		            <span>Remember me</span>
		        </div>
		        <div>
		            <a id="login-btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
		                <span style="font-size:14px;">Login</span>
		            </a>
		        </div>
		    </div>
		 </form>
	</div>
</body>
</html>