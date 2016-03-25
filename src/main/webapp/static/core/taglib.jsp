<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- ${pageContext.request.contextPath} -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!-- JQuery -->
<script type="text/javascript" src="${ctx}/static/js/jquery-2.1.1.min.js"></script>

<!-- JQuery Validate -->
<script src="${ctx}/static/js/jquery-validation/dist/jquery.validate.min.js"></script>

<!-- JQueryEasyUI -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/js/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/js/jquery-easyui-1.4.3/themes/icon.css">
<script type="text/javascript" src="${ctx}/static/js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>


<!-- <link rel="stylesheet" type="text/css" href="../demo.css"> -->

<!-- BootStrap -->
<%-- <link href="${ctx}/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"> --%>
<%-- <script src="${ctx}/static/js/bootstrap/js/bootstrap.min.js"></script> --%>

<!-- 自定义JQueryEasyUI -->
<script type="text/javascript" src="${ctx}/static/js/JQueryEasyUI.js"></script>

	