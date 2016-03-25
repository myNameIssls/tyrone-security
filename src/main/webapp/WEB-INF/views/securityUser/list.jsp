<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/static/core/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐单明细查询</title>

<script type="text/javascript">
    $(function(){
        var pager = $('#dg').datagrid().datagrid('getPager');    // get the pager of datagrid
    })
</script>


</head>
<body>
	<div id="detail-layout" fit="true" class="easyui-layout" border = 'false'>
        <div data-options="region:'north',title:'帐单明细查询'" style="height: 80px;" border = 'true'>
        	<form action="">
        		帐目分类:<select id="account_types"></select>
        	</form>
        </div>
        <div data-options="region:'center'" border = 'false'>
		    <table id="dg" title="用户列表" style="width:100%;height:100%" border = 'false'
		            data-options="rownumbers:true,pagination:true,method:'get'" fitColumns='true' fit = 'true'>
		        <thead>
		            <tr>
		            	<th field="itemID" checkbox="true"></th>
		                <th data-options="field:'productid',width:100">用户名</th>
		                <th data-options="field:'listprice',width:80,align:'right'">是否锁定</th>
		                <th data-options="field:'unitcost',width:80,align:'right'">员工编号</th>
		            </tr>
		        </thead>
		        	
		        	<c:forEach items="${itemDataList }" var="item" >
		        		<tr>
		        			<td>${item.userId }</td>
		        			<td>${item.username }</td>
		        			<td>${item.locked }</td>
		        			<td>${item.empId }</td>
		        		</tr>
		        	</c:forEach>
		        	
		    </table>
        </div>
    </div>    
</body>
</html>