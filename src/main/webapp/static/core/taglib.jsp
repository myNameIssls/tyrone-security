<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- ${pageContext.request.contextPath} -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!-- JQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.3/jquery.min.js"></script>

<!-- JQueryEasyUI -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>

<!-- 自定义JQueryEasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/JQueryEasyUI.js"></script>
	