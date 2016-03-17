<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/static/core/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐单明细查询</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/wallet/detail.js"></script> --%>
<script type="text/javascript">

var toolbar = [{
	    text:'记帐',
	    iconCls:'icon-add',
	    handler:function(){alert('add')}
	},'-',{
	    text:'修改',
	    iconCls:'icon-edit',
	    handler:function(){alert('cut')}
	},'-',{
	    text:'删除',
	    iconCls:'icon-remove',
	    handler:function(){alert('save')}
	}];

var columns = [[
    {field:'time',title:'日期',width:100},
    {field:'type',title:'类型',width:100},
    {field:'account-type',title:'帐目分类',width:100,align:'right'},
    {field:'money',title:'金额',width:100},
    {field:'remark',title:'备注',width:100}
]];

$(function(){
	// detail
	$('#dg').datagrid({
	    url:'../securityUser/getDataList',
	    fit:true,
	    loadMsg: '数据正在加载,请耐心的等待...' ,
	    pagination: true , 
		pageSize: 10 ,
		pageList:[5,10,15,20,50] ,
		toolbar : toolbar,
	    columns:columns
	});
})


</script>


</head>
<body>
	<div id="detail-layout" fit="true" class="easyui-layout" border = "false">
        <div data-options="region:'north',title:'帐单明细查询'" style="height: 80px;">
        	<form action="">
        		帐目分类:<select id="account_types"></select>
        	</form>
        </div>
        <div data-options="region:'center',title:'帐单明细'" border = "false">
        	<table id="dg"></table>
        </div>
    </div>    
</body>
</html>