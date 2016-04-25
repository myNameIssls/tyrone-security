<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/static/core/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据字典维护列表</title>

<script type="text/javascript">
	
	// 菜单项
	var toolbar = [{
	    text:'新增字典',
	    iconCls:'icon-add',
	    handler:function(){
	    	$('#w').window('open');
	    }
	},'-',{
	    text:'Cut',
	    iconCls:'icon-cut',
	    handler:function(){alert('cut')}
	},'-',{
	    text:'Save',
	    iconCls:'icon-save',
	    handler:function(){alert('save')}
	}];

	// 新增用户提交
	function submitForm(){
        $('#ff').form('submit',{
        	url:"${ctx}/sysDict/saveDict",
            onSubmit:function(){
            	var result = $(this).form('enableValidation').form('validate');
                return result;
            },
            success:function(data){
            	console.log("提交成功后，返回：" + data);
            }
        });
    }
	
    $(function(){
    	
    	// 加载数据列表
    	$('#dg').datagrid({
			singleSelect:true,
			checkOnSelect:false,
			selectOnCheck:false,
			rownumbers:true,
			toolbar:toolbar,
			fit:true,
			fitColumns:false,
			pagination:true,
			pageList:[10,20,30,40,50]
    	});
    	
        $('#isAvilable').switchbutton({
            onChange: function(checked){
                if(checked === true){
                	$('#isAvilable').switchbutton("setValue","0");
                }else{
                	$('#isAvilable').switchbutton("setValue","1");
                }
            }
        })
        
        // 
        $('#dictType').combobox({
            editable:false,
        	onChange: function(param){
        		if(param == 1){
        			console.log("dictType === 1");
            		$("#dictGroupTypeTr").show();
            		$('#dictGroupKey').combobox('enable');
            	}else{
            		$("#dictGroupTypeTr").hide();
            		$('#dictGroupKey').combobox('disable');
            	}
        	}
        });
        
    })
</script>


</head>
<body>
	<!-- 数据区域 -->
	<div id="detail-layout" fit="true" class="easyui-layout" border = 'false'>
        <div data-options="region:'north',title:'帐单明细查询'" style="height: 80px;" border = 'true'>
        	<form action="">
        		帐目分类:<select id="account_types"></select>
        	</form>
        </div>
        <div data-options="region:'center'" border = 'false'>
        
        	<table id="dg">
        		<thead>
		            <tr>
		            	<th field="id" checkbox="true"></th>
		                <th data-options="field:'dictKey'">字典编码</th>
		                <th data-options="field:'dictValue'">字典名称</th>
		                <th data-options="field:'dictTypeValue'">字典类型</th>
		                <th data-options="field:'avilable'">是否可用</th>
		            </tr>
		        </thead>
		        
		        <c:forEach items="${itemDataList }" var="item" >
	        		<tr>
	        			<td>${item.id }</td>
	        			<td>${item.dictKey }</td>
	        			<td>${item.dictValue }</td>
	        			<td>${item.dictType }</td>
	        			<td>${item.dictTypeValue }</td>
	        			<td>${item.avilable }</td>
	        		</tr>
	        	</c:forEach>
        	</table>
        </div>
    </div> 
    
    <!-- 新增用户窗口 -->
    <div id="w" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:600px;height:400px;padding:10px;">
        <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
            <table cellpadding="5">
            	<tr>
                    <td align="right">请选择字典类型:</td>
                    <td>
                    	<select class="easyui-combobox" data-options="required:true" id= "dictType" name="dictType" style="width: 150px;">
                    		<option>-- 请选择字典类型 --</option>
							<option value="0">&nbsp;字典组类型</option>
							<option value="1">&nbsp;字典类型</option>        
						</select>
                    </td>
                </tr>
                
                <tr id="dictGroupTypeTr" style="display: none;">
                    <td align="right">请选择字典组类型:</td>
                    <td>
                    	<!-- 需要查询数据库加载 -->
                    	<select class="easyui-combobox" id= "dictGroupKey" disabled="disabled" name="dictGroupKey" style="width: 150px;">
                    		<option>-- 请选择字典组 --</option>
							<option value="001">角色组类型</option>
							<option value="002">机构组类型</option>
							<option value="003">职位组类型</option>
							<option value="170">slsadmin</option>
						</select>
                    </td>
                </tr>
                
                <tr>
                    <td align="right">请输入字典名称:</td>
                    <td><input class="easyui-textbox" type="text" name="dictValue" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td align="right" style="width:180px">是否可用:</td>
            		<td><input class="easyui-switchbutton" id = "isAvilable" name="avilable" checked></td>
                </tr>
            </table>
        </form>
        
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
        </div>
        
    </div>
       
</body>
</html>