<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String basepath = request.getScheme() + "://"
					+ request.getServerName() + ":"
					+ request.getServerPort()
					+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Right</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
</head>
<body>
	<div id="header"><%@ include file="/jsp/manager/headerManager.jsp" %></div>
	<div id="main">
		<div class="nav"><%@ include file="/jsp/manager/navManager.jsp" %></div>
		<div class="container"><%@ include file="/jsp/right/manager/containerManager.jsp" %></div>
	</div>
	<div id="footer"></div>
<script>
function doEmployee(pageIndex){	
	document.getElementById("hiddenInput").value = pageIndex;
	document.getElementById("submitForm").submit();

}
</script>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src='js/leftnav.js'></script>
</body>
</html>