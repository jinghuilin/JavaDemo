<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
</head>
<body>
	<input id="success" type="hidden" value="${requestScope.success }">
	<div id="header"><%@ include file="/jsp/manager/headerManager.jsp" %></div>
	<div id="main">
		<div class="nav"><%@ include file="/jsp/manager/navManager.jsp" %></div>
		<div class="container">
			<h3>角色管理>> 创建角色</h3>
			<form id="updateRoleForm" action="role.do?action=insert" method="post">
				<table width="100%" border="1" cellpadding="10" cellspacing="0">
					<tbody>
				        <tr>
					    	<td>角色名称:</td>
					        <td>
					        	<input name="roleName" id="roleName" class="input" type="text" value="${requestScope.role.roleName }">
					        </td>
				        </tr>
				        <tr>
				          	<td>角色描述:</td>
				          	<td><input name="roleDesc" id="roleDesc" class="input" type="text" value="${requestScope.role.roleDesc }"></td>
				        </tr>
						<tr>
							<td>状态:</td>
							<td>
								<select name="status">
									<option value="-1">全部</option>
									<option value="1" <c:if test="${requestScope.employee.status eq 1 }">selected="selected"</c:if>>正常</option>
									<option value="0" <c:if test="${requestScope.employee.status eq 0 }">selected="selected"</c:if>>禁用</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
					      		<input type="submit" value="添加角色" />
					      		<input type="reset" />
					     	</td> 
					  	</tr>
			     	</tbody>
				</table>
			</form>
		</div>
	</div>
	<div id="footer"></div>
	<script>
		var success = document.getElementById("success").value;
		if(success){
			alert("添加成功");
		}
</script>
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src='js/leftnav.js'></script>
</body>
</html>