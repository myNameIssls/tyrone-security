<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/static/core/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐单明细查询</title>

<script type="text/javascript">

	var toolbar = [{
	    text:'新增用户',
	    iconCls:'icon-add',
	    handler:function(){
	    	$('#w').window('open');
	    }
	},{
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
        	url:"${ctx}/securityUser/addUser",
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
        var pager = $('#dg').datagrid().datagrid('getPager');    // get the pager of datagrid
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
		    <table id="dg" title="用户列表" style="width:100%;height:100%" border = 'false'
		            data-options="rownumbers:true,pagination:true,method:'get',toolbar:toolbar" fitColumns='true' fit = 'true'>
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
    
    <!-- 新增用户窗口 -->
    <div id="w" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:600px;height:400px;padding:10px;">
        <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
            <table cellpadding="5">
                <tr>
                    <td>用户名:</td>
                    <td><input class="easyui-textbox" type="text" name="username" data-options="required:true"></input></td>
                    <td>Email:</td>
                    <td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><input class="easyui-textbox" type="text" name="subject" data-options="required:true"></input></td>
                    <td>Message:</td>
                    <td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:60px"></input></td>
                </tr>
                <tr>
                    <td>Language:</td>
                    <td>
                        <select class="easyui-combobox" name="language"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
                    </td>
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