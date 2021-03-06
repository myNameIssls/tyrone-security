<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Shiro 标签库 -->
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

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

<!-- 自定义JQueryEasyUI -->
<script type="text/javascript" src="${ctx}/static/js/JQueryEasyUI.js"></script>

	