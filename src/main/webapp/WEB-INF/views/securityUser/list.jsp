<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/static/core/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐单明细查询</title>

<script type="text/javascript">

</script>


</head>
<body>
	<div id="detail-layout" fit="true" class="easyui-layout" border = "false">
        <div data-options="region:'north',title:'帐单明细查询'" style="height: 80px;">
        	<form action="">
        		帐目分类:<select id="account_types"></select>
        	</form>
        </div>
        <div data-options="region:'center',title:'帐单明细查询'" border = "true">
        	<table border="1" width="100%" cellspacing="0">
        		<tr>
        			<td><input type="checkbox" /> </td>
        			<td>用户名</td>
        			<td>是否锁定</td>
        			<td>所属员工</td>
        			<td>操作</td>
        		</tr>
        		<c:forEach items="${itemDataList}" var="item">
        			<tr>
        				<td><input type="checkbox"  name="cbo-id" value="${item.userId}" /></td>
        				<td>${item.username}</td>
        				<td>${item.locked}</td>
        				<td>${item.empId}</td>
        				<td>锁定</td>
        			</tr>
        		</c:forEach>
        	</table>
        </div>
    </div>    
</body>
</html>